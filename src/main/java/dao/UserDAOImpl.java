package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
 

public class UserDAOImpl implements UserDAO {
 
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
     
    @Override
    public void save(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(p);
        tx.commit();
        session.close();
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<User> list() {
        Session session = this.sessionFactory.openSession();
        List<User> personList = session.createQuery("from User").list();
        session.close();
        return personList;
    }

	@Override
	public User read(String name) {    
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from User as p where nombre = :name";
        Query query = session.createQuery(queryString);
        query.setString("name", name);
        User person = (User) query.uniqueResult();
	    session.close();
	    return (person);
	}

	@Override
	public void update(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
        	session.update(p);
        	tx.commit();
        }catch (Exception e) {
			if(tx!=null) tx.rollback();
			e.printStackTrace();
		}
        finally {
            session.close();
        }	
	}

	@Override
	public void delete(User p) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(p);
        tx.commit();
        session.close();		
	}

	@Override
	public User passwordCheck(User p) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from User as p where nombre = :name";
        Query query = session.createQuery(queryString);
        query.setString("name", p.getNombre());
        User person = (User) query.uniqueResult();
	    session.close();
        if(person.getContrasena()== p.getContrasena()){
    	    return (person);
        }
		return null;
	}
 
}