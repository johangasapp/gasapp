package dao;

import java.util.List;

import entity.Gasolinera;
import entity.Tanqueo;
import entity.Tanqueo_gasolinera;
import entity.User;

public interface Tanqueo_gasolineraDAO {
	
    public void save(Tanqueo_gasolinera tg);

    public void update(Tanqueo_gasolinera tg);
    
    public void delete(Tanqueo_gasolinera tg);
     
    public List<Tanqueo_gasolinera> list(Gasolinera p);

}
