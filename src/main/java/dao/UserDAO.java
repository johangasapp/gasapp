package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	 
    public void save(User p);
    
    public User read(String name);
    
    public User passwordCheck(User p);
    
    public void update(User p);
    
    public void delete(User p);
     
    public List<User> list();
     
}