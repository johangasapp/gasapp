package dao;

import java.util.List;

import entity.Gasolinera;



public interface GasolineraDAO {
	
    public void save(Gasolinera g);
       
    public Gasolinera readbyCoordinates(String coordenadas);
    
    public void update(Gasolinera g);
    
    public void delete(Gasolinera g);
     
    public List<Gasolinera> list();

}
