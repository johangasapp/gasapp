package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Gasolinera;
import entity.Tanqueo;
import entity.Tanqueo_gasolinera;
import entity.User;


public class Tanqueo_gasolineraDAOImpl implements Tanqueo_gasolineraDAO{
	
	   private SessionFactory sessionFactory;
	    
	    public void setSessionFactory(SessionFactory sessionFactory) {
	        this.sessionFactory = sessionFactory;
	    }

	@Override
	public void save(Tanqueo_gasolinera tg) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(tg);
        tx.commit();
        session.close();		
	}



	@Override
	public void update(Tanqueo_gasolinera tg) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
        	session.update(tg);
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
	public void delete(Tanqueo_gasolinera tg) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(tg);
        tx.commit();
        session.close();
		
	}

	@Override
	public List<Tanqueo_gasolinera> list(Gasolinera p) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from Tanqueo_gasolinera as p where idGASOLINERA = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", p.getId());
        List<Tanqueo_gasolinera> tg =  query.list();
	    session.close();
	    return (tg);
	}

}
