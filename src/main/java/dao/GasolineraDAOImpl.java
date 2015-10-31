package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Gasolinera;

public class GasolineraDAOImpl implements GasolineraDAO {
	
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

	@Override
	public void save(Gasolinera g) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Gasolinera tester=readbyCoordinates(g.getCoordenadas());
        if(tester==null){
            session.persist(g);
            tx.commit();
        }
        session.close();
	}

	@Override
	public Gasolinera readbyCoordinates(String coordenadas) {
		Session session = this.sessionFactory.openSession();
        String queryString = "select p from Gasolinera as p where coordenadas = :coordenadas";
        Query query = session.createQuery(queryString);
        query.setString("coordenadas", coordenadas);
        Gasolinera gasolinera = (Gasolinera) query.uniqueResult();
	    session.close();
	    return (gasolinera);
	}

	@Override
	public void update(Gasolinera g) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        try{
        	session.update(g);
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
	public void delete(Gasolinera g) {
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(g);
        tx.commit();
        session.close();	
	}

	@Override
	public List<Gasolinera> list() {
        Session session = this.sessionFactory.openSession();
        List<Gasolinera> gasolineraList = session.createQuery("from Gasolinera").list();
        session.close();
        return gasolineraList;
	}

}
