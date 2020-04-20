package cat.emprul.restfulspringboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cat.emprul.restfulspringboot.dto.EventRaceDTO;
import cat.emprul.restfulspringboot.entity.EventRace;
import cat.emprul.restfulspringboot.repository.EventRepository;
import cat.emprul.restfulspringboot.repository.RaceRepository;

import java.lang.reflect.Type;

@RestController
public class EventRaceController {

	@Autowired
	EventRepository eventRepositoory;
	
	@Autowired
	RaceRepository raceRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping("/")
	public String index() {
		return "OK - Service Working";
	}
	
	@GetMapping("/req")
    public String resInternational(Locale locale) {
        return messageSource.getMessage("error.notfound", null, locale);
    }
	

	@GetMapping("/events")
	public List<EventRaceDTO> findAll(){
		List<EventRace> listEventRace = eventRepositoory.findAll();
        
		return listEventRace.stream().map(this::convertToDto).collect(Collectors.toList());
    }
	
	private EventRaceDTO convertToDto(EventRace eventRace) {
		Type listType = new TypeToken<List<EventRaceDTO>>(){}.getType();
		EventRaceDTO eventRaceDTO = modelMapper.map(eventRace, EventRaceDTO.class);
	    return eventRaceDTO;
	}
	
	
	
	@GetMapping("/event/{id}")
    public Optional<EventRace> findById(@PathVariable Long id){
        return eventRepositoory.findById(id);
    }

	 @PostMapping("/event")
	 public EventRace createEventRace(@Valid @RequestBody EventRace eventRace) {
		 return eventRepositoory.save(eventRace);
	 }
	 
	 @PutMapping("/event")
	 public EventRace updateEventRace(@RequestBody EventRace eventRace) {
	        return eventRepositoory.save(eventRace);
	 }
	 
	 
	
	 @DeleteMapping(value = "/delete/{id}")
	 public ResponseEntity<Long> deletePost(@PathVariable Long id) {
		 try {
	        eventRepositoory.deleteById(id);
		 } catch (EmptyResultDataAccessException e) {
			    throw new EmptyResultDataAccessException(0);
		 }
	     return new ResponseEntity<>(id, HttpStatus.OK);
	    }
	 
	 @ResponseStatus(HttpStatus.BAD_REQUEST)
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public Map<String, String> handleValidationExceptions(
	   MethodArgumentNotValidException ex) {
	     Map<String, String> errors = new HashMap<>();
	     ex.getBindingResult().getAllErrors().forEach((error) -> {
	         String fieldName = ((FieldError) error).getField();
	         String errorMessage = error.getDefaultMessage();
	         errors.put(fieldName, errorMessage);
	     });
	     return errors;
	 }
	
}
