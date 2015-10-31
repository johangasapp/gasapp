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
@Table(appliesTo="User_gasolinera")
public class User_gasolinera {
	
 	@Id
    @Column(name="idUSER_GASOLINERA")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
 	
 	@ManyToOne
 	@JoinColumn(name="idUSER")
 	private User user;
 	
 	@ManyToOne
 	@JoinColumn(name="idGASOLINERA")
 	private Gasolinera gasolinera;
 	
 	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Gasolinera getGasolinera() {
		return gasolinera;
	}
	public void setGasolinera(Gasolinera gasolinera) {
		this.gasolinera = gasolinera;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}	
	
 
}
