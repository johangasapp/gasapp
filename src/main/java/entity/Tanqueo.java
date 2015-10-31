package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo="Tanqueo")
public class Tanqueo {

    @Id
    @Column(name="idTANQUEO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    private int dinero;
    
    private int cantidad;
    
    private int km_antes_nuevo_reposteo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getKm_antes_nuevo_reposteo() {
		return km_antes_nuevo_reposteo;
	}

	public void setKm_antes_nuevo_reposteo(int km_antes_nuevo_reposteo) {
		this.km_antes_nuevo_reposteo = km_antes_nuevo_reposteo;
	}
    
    
    
}
