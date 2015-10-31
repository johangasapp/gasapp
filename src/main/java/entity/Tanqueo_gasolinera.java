package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo="Tanqueo_gasolinera")
public class Tanqueo_gasolinera {
	
 	@Id
    @Column(name="idTANQUEO_GASOLINERA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 	
 	@ManyToOne
 	@JoinColumn(name="idTANQUEO")
 	private Tanqueo tanqueo;
 	
 	@ManyToOne
 	@JoinColumn(name="idGASOLINERA")
 	private Gasolinera gasolinera;
 	
 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tanqueo getTanqueo() {
		return tanqueo;
	}
	public void setTanqueo(Tanqueo tanqueo) {
		this.tanqueo = tanqueo;
	}
	public Gasolinera getGasolinera() {
		return gasolinera;
	}
	public void setGasolinera(Gasolinera gasolinera) {
		this.gasolinera = gasolinera;
	}	
 
	
}
