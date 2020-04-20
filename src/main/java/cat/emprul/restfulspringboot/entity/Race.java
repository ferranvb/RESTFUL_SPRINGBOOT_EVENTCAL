package cat.emprul.restfulspringboot.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "races")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Race implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_race")
    private Long id_race;
     
    private String nom;
    
//    private java.math.BigDecimal distancia;
//    
//    private boolean circular;
//    
//    @Column(name="desnivell_pos")
//    private int desnivellPos;
//    
//    @Column(name="desnivell_neg")
//    private int desnivellNeg;
//    
//    @Column(name="hora_inici")
//    private Date horaInici;
//    
//    @Column(name="temps_total")
//    private String tempsTotal;
//
//    private byte tipus;
    
    @ManyToOne
    @JoinColumn(name="id_event",nullable = false, updatable = true)
    private EventRace eventRace;

	public Long getId() {
		return id_race;
	}

	public void setId(Long id_race) {
		this.id_race = id_race;
	}

	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

//	public java.math.BigDecimal getDistancia() {
//		return distancia;
//	}
//
//	public void setDistancia(java.math.BigDecimal distancia) {
//		this.distancia = distancia;
//	}
//
//	public boolean isCircular() {
//		return circular;
//	}
//
//	public void setCircular(boolean circular) {
//		this.circular = circular;
//	}
//
//	public int getDesnivellPos() {
//		return desnivellPos;
//	}
//
//	public void setDesnivellPos(int desnivellPos) {
//		this.desnivellPos = desnivellPos;
//	}
//
//	public int getDesnivellNeg() {
//		return desnivellNeg;
//	}
//
//	public void setDesnivellNeg(int desnivellNeg) {
//		this.desnivellNeg = desnivellNeg;
//	}
//
//	public Date getHoraInici() {
//		return horaInici;
//	}
//
//	public void setHoraInici(Date horaInici) {
//		this.horaInici = horaInici;
//	}
//
//	public String getTempsTotal() {
//		return tempsTotal;
//	}
//
//	public void setTempsTotal(String tempsTotal) {
//		this.tempsTotal = tempsTotal;
//	}
//
//	public byte getTipus() {
//		return tipus;
//	}
//
//	public void setTipus(byte tipus) {
//		this.tipus = tipus;
//	}

	public EventRace getEventRace() {
		return eventRace;
	}

	public void setEventRace(EventRace eventRace) {
		this.eventRace = eventRace;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventRace == null) ? 0 : eventRace.hashCode());
		result = prime * result + ((id_race == null) ? 0 : id_race.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Race other = (Race) obj;
		if (eventRace == null) {
			if (other.eventRace != null)
				return false;
		} else if (!eventRace.equals(other.eventRace))
			return false;
		if (id_race == null) {
			if (other.id_race != null)
				return false;
		} else if (!id_race.equals(other.id_race))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	

}