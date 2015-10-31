import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.GasolineraDAO;
import dao.Tanqueo_gasolineraDAO;
import entity.Gasolinera;
import entity.Tanqueo;
import entity.Tanqueo_gasolinera;
import entity.User;

 
public class SpringHibernateMain {
 
    public static void main(String[] args) {
 
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
         
        Tanqueo_gasolineraDAO gasolineraDAO = context.getBean(Tanqueo_gasolineraDAO.class);
         
        Gasolinera gasolinera = new Gasolinera();
        gasolinera.setId(4);
        gasolinera.setCoordenadas("4.94"); gasolinera.setNombre("La de la 68");
        
        Tanqueo tanqueo= new Tanqueo();
        tanqueo.setId(1);
        tanqueo.setCantidad(3);
        tanqueo.setDinero(2000);
        tanqueo.setCantidad(3);
        tanqueo.setKm_antes_nuevo_reposteo(45);
        
        
        Tanqueo_gasolinera tanqueoTest = new Tanqueo_gasolinera();
        tanqueoTest.setGasolinera(gasolinera);
        tanqueoTest.setTanqueo(tanqueo);
        
        gasolineraDAO.save(tanqueoTest);
        List<Tanqueo_gasolinera> tanqueosPepe=gasolineraDAO.list(gasolinera);
        System.out.println("CANTINFLAIS+ :"+tanqueosPepe.toString());
        context.close();    
    }
}