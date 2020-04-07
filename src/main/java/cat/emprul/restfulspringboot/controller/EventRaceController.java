package cat.emprul.restfulspringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cat.emprul.restfulspringboot.entity.EventRace;
import cat.emprul.restfulspringboot.repository.EventRepository;

@RestController
public class EventRaceController {

	@Autowired
	EventRepository eventRepositoory;
	
	@RequestMapping("/")
	public String index() {
		return "OK - Service Working";
	}
	
	@GetMapping("/events")
    public List<EventRace> findAll(){
        return eventRepositoory.findAll();
    }
	
	@GetMapping("/event/{id}")
    public Optional<EventRace> findById(@PathVariable Long id){
        return eventRepositoory.findById(id);
    }

	 @PostMapping("/event")
	 public EventRace createFood(@RequestBody EventRace eventRace) {
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
	
}
