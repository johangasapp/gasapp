package dao;

import java.util.List;

import entity.User;
import entity.Vehiculo;

public interface VehiculoDAO {
    public void save(Vehiculo v);
    
    public Vehiculo read(int id);    
   
    public void update( Vehiculo  v);
    
    public void delete( Vehiculo  v);
     
    public List<Vehiculo> list(User p);

}
