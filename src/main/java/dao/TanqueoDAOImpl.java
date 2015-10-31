package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Tanqueo;

public class TanqueoDAOImpl implements TanqueoDAO {

    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	@Override
	public void save(Tanqueo t) {
		  Session session = this.sessionFactory.openSession();
	        Transaction tx = session.beginTransaction();
	        session.persist(t);
	        tx.commit();
	        session.close();
	}

	@Override
	public Tanqueo read(int id) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from Tanqueo p where idTANQUEO = :id";
        Query query = session.createQuery(queryString);
        query.setInteger("id", id);
        Tanqueo tanqueo= (Tanqueo) query.uniqueResult();
	    session.close();
	    return (tanqueo);
	}

	@Override
	public void update(Tanqueo t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
        	session.update(t);
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
	public void delete(Tanqueo t) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(t);
        tx.commit();
        session.close();	
	}

	@Override
	public List<Tanqueo> list() {
        Session session = this.sessionFactory.openSession();
        List<Tanqueo> tanqueoList = session.createQuery("from Tanqueo").list();
        session.close();
        return tanqueoList;
	}

}
