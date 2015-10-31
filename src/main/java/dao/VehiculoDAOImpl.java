package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.User;
import entity.Vehiculo;

public class VehiculoDAOImpl implements VehiculoDAO{

    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Vehiculo v) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(v);
        tx.commit();
        session.close();		
	}

	@Override
	public Vehiculo read(int id) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from User as p where nombre = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", id);
        Vehiculo v = (Vehiculo) query.uniqueResult();
	    session.close();
	    return (v);
	}

	@Override
	public void update(Vehiculo v) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
        	session.update(v);
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
	public void delete(Vehiculo v) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(v);
        tx.commit();
        session.close();
	}

	@Override
	public List<Vehiculo> list(User p) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from User as p where idUser = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", p.getId());
        List<Vehiculo> vehicles =  query.list();
	    session.close();
	    return (vehicles);
	}

	

}
