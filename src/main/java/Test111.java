
import entity.Cities;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test111 {
    public static void main(String[] args) {



        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Cities.class)
                .buildSessionFactory();


        try {
            Session session = factory.getCurrentSession();

            Cities cities = new Cities("1", "2-1");

            session.beginTransaction();
            session.save(cities);
            session.getTransaction().commit();

            System.out.println("DONE!");
        } finally {
            factory.close();
        }
    }
}

