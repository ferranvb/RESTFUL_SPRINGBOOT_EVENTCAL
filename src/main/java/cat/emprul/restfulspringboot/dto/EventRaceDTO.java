package cat.emprul.restfulspringboot.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import cat.emprul.restfulspringboot.entity.Race;

public class EventRaceDTO {

	private Long id_event; 
	
	private String name;
	
	private String description;
	
	private String site;
	
	private String country;
	
	private Date dateStart;
	
	private List<Race> llistaRacesXXX = new ArrayList<>();

	public Long getId_event() {
		return id_event;
	}

	public void setId_event(Long id_event) {
		this.id_event = id_event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public List<Race> getLlistaRacesXXX() {
		return llistaRacesXXX;
	}

	public void setLlistaRacesXXX(List<Race> llistaRacesXXX) {
		this.llistaRacesXXX = llistaRacesXXX;
	}

	
	
}
