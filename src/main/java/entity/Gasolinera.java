package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo="Gasolinera")
public class Gasolinera {
	
	 	@Id
	    @Column(name="idGASOLINERA")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int id;
	 	
		private String nombre;
	     
	    private String direccion;
	    
	    private String coordenadas;
	    
	    private int precio_corriente;
	    
	    private int precio_premium;
	    
	    private int precio_diesel;
	    
	    private int precio_gnv;    
	    
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getCoordenadas() {
			return coordenadas;
		}

		public void setCoordenadas(String coordenadas) {
			this.coordenadas = coordenadas;
		}

		public int getPrecio_corriente() {
			return precio_corriente;
		}

		public void setPrecio_corriente(int precio_corriente) {
			this.precio_corriente = precio_corriente;
		}

		public int getPrecio_premium() {
			return precio_premium;
		}

		public void setPrecio_premium(int precio_premium) {
			this.precio_premium = precio_premium;
		}

		public int getPrecio_diesel() {
			return precio_diesel;
		}

		public void setPrecio_diesel(int precio_diesel) {
			this.precio_diesel = precio_diesel;
		}

		public int getPrecio_gnv() {
			return precio_gnv;
		}

		public void setPrecio_gnv(int precio_gnv) {
			this.precio_gnv = precio_gnv;
		}

 

}
