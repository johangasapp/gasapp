package dao;

import java.util.List;

import entity.Tanqueo;

public interface TanqueoDAO {
	
    public void save(Tanqueo t);
    
    public Tanqueo read(int id);
    
    public void update(Tanqueo t);
    
    public void delete(Tanqueo t);
     
    public List<Tanqueo> list();

}
