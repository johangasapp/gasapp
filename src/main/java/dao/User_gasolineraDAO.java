package dao;

import java.util.List;

import entity.Gasolinera;
import entity.User;
import entity.User_gasolinera;

public interface User_gasolineraDAO {
	
    public void save(User_gasolinera ug);

    public void update(User_gasolinera ug);
    
    public void delete(User_gasolinera ug);
     
    public List<User_gasolinera> list(User p);
    
    public List<User_gasolinera> list(Gasolinera g);

}
