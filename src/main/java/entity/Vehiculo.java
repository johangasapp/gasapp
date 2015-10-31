package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo="Vehiculo")
public class Vehiculo {

    @Id
    @Column(name="idVEHICULO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private String marca;
    
    private String modelo;
    
    private int ano;
    
    private int consumo_km_l;
    
    private int capacidad_tanque;
    
    @ManyToOne
    @JoinColumn(name="idUSER")
    private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getConsumo_km_l() {
		return consumo_km_l;
	}

	public void setConsumo_km_l(int consumo_km_l) {
		this.consumo_km_l = consumo_km_l;
	}

	public int getCapacidad_tanque() {
		return capacidad_tanque;
	}

	public void setCapacidad_tanque(int capacidad_tanque) {
		this.capacidad_tanque = capacidad_tanque;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    
    
    
    
    
}
