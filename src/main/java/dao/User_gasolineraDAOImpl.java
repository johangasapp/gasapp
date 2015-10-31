package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Gasolinera;
import entity.Tanqueo_gasolinera;
import entity.User;
import entity.User_gasolinera;

public class User_gasolineraDAOImpl implements User_gasolineraDAO{
	   
		private SessionFactory sessionFactory;
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	@Override
	public void save(User_gasolinera ug) {
		Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(ug);
        tx.commit();
        session.close();		
		
	}

	@Override
	public void update(User_gasolinera ug) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
        	session.update(ug);
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
	public void delete(User_gasolinera ug) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(ug);
        tx.commit();
        session.close();	
	}

	@Override
	public List<User_gasolinera> list(User p) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from Tanqueo_gasolinera as p where idTANQUEO = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", p.getId());
        List<User_gasolinera> ug =  query.list();
	    session.close();
	    return (ug);
	}

	@Override
	public List<User_gasolinera> list(Gasolinera g) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from Tanqueo_gasolinera as p where idGASOLINERA = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", g.getId());
        List<User_gasolinera> ug =  query.list();
	    session.close();
	    return (ug);
	}

}
