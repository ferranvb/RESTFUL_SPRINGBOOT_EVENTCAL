package cat.emprul.restfulspringboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This is a simple class to model table EVENTS 
 * @author ferran
 *
 */

@Entity
@Table(name = "events")
public class EventRace  implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_event; 
	
	@Column(name="nom")
	private String name;
	
	@Column(name="descripcio")
	private String description;
	
	@Column(name="lloc")
	private String site;
	
	@Column(name="pais")
	private String country;
	
	@Column(name="data_inici")
	private Date dateStart;
	
	@Column(name="data_fi")
	private Date dateEnd;
	
	//Constructors
	public EventRace() {
		
	}
	
	public EventRace(Long id_event, String name, String description, String site, String country, Date dateStart,
			Date dateEnd) {
		super();
		this.id_event = id_event;
		this.name = name;
		this.description = description;
		this.site = site;
		this.country = country;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}


	//Getters & Setters
	public Long getId_event() {
		return id_event;
	}

	@XmlElement
	public void setId_event(Long id_event) {
		this.id_event = id_event;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	public String getSite() {
		return site;
	}

	@XmlElement
	public void setSite(String site) {
		this.site = site;
	}

	public String getCountry() {
		return country;
	}

	@XmlElement
	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateStart() {
		return dateStart;
	}

	@XmlElement
	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	@XmlElement
	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Override
	public String toString() {
		return "EventRace [id_event=" + id_event + ", name=" + name + ", description=" + description + ", site=" + site
				+ ", country=" + country + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + "]";
	}
	
	

}
