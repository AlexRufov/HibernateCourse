import Enums.Days;
import entities.Address;
import entities.HomeAddress;
import entities.Person;
import entities.Student;
import entities.hierarchies.Car;
import entities.hierarchies.Opel;
import entities.hierarchies.Toyota;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try(SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sessionFactory.openSession()){
            session.beginTransaction();

            Student max = new Student("Max", Days.FRIDAY, new Date());
            max.setAddress(new Address("Lenina",22));
            session.save(max);
            Student load = session.load(Student.class, 1);

            HomeAddress homeAddress = new HomeAddress("Lenina");
            List<HomeAddress> list = new ArrayList<>();
            list.add(homeAddress);

            Person person = new Person("Max", list, "123");
            List<Person> people = new ArrayList<>();
            people.add(person);
            homeAddress.setPerson(people);
            session.persist(homeAddress);
            session.persist(person);
            Person iCode = session.byNaturalId(Person.class).using("iCode", "123").load();
            //Student get = session.get(Student.class, 1);
            //System.out.println(load.getIdPlusAge());
            //System.out.println(get.getName());

//            Map<String, String> books = new HashMap<>();
//            books.put("isbn", "978-9730228236");
//            books.put("title", "High-Performance Java Persistence");
//            books.put("author", "Vlad Mihalcea");
//
//            session.save("Books", books);

//            Car car = new Toyota("1", "220");
//            Car car2 = new Opel("2", 200000);
//            Car car3 = new Car("3");
//            session.persist(car);
//            session.persist(car2);
//            session.persist(car3);

            Car car = new Car("123");
            session.persist(car);
//            session.flush();
//            car.setNumber("321");
//            session.detach(car);
//            car.setNumber("456");
//            session.merge(car);
//            session.update(car);
//            session.remove(car);
//            session.refresh(car);
//            Query query = session.createQuery("from Car where number = ? and id = ?");
//            query.setParameter(0, 123);
//            query.setParameter(1, 1);
//            Query query = session.createQuery("from Car where number = :number1 and id = :myId");
////            Query query1 = session.createQuery("select distinct c.number from Car c");
//            query.setParameter("number1", 123);
//            query.setParameter("myId", 1);
//            Query from_car = session.createQuery("from Car c order by c.number desc ");
//            Query from_car = session.createQuery("from Car");
//            from_car.setMaxResults(3);
//            from_car.setFirstResult(1);
//            Query from_car = session.createQuery("select c.number from Car c group by c.number having c.number = '123'");

            session.createQuery("update Car c set c.number = 12345 where c.id = 1").executeUpdate();
            session.createQuery("insert into Car (id, number) select c.id + 5, concat(c.number, 6) from Car c where id = 1").executeUpdate();
            session.createQuery("delete Car c where c.id = 1").executeUpdate();
//            Query query = session.createQuery("from Car where number = 123 and id = 1");
//            Query query = session.createQuery("select c from Car c where c.number = '123'");
//            Query query = session.createQuery("select new entities.hierarchies.Car(c.number) from Car c where c.number = '123'");
            //List list1 = query.list();
//            Car car5 = (Car) query.uniqueResult();
            Query getCarByNumber = session.createNamedQuery("getCarByNumber");
            getCarByNumber.setParameter("number", "1");
            Car car8 = (Car) getCarByNumber.uniqueResult();

            NativeQuery nativeQuery = session.createNativeQuery("select * from Car");
            List<Object[]> resultList = nativeQuery.getResultList();
            for (Object[] objects : resultList){
                Number id = (Number) objects[0];
                String number = (String) objects[0];
                System.out.println(id + " " + number);
            }

            NativeQuery nativeQuery2 = session.createNativeQuery("select * from Car", Car.class);
            List<Car> resultList2 = nativeQuery.getResultList();
            for (Car car1 : resultList){
                System.out.println(car1.getId() + " " + car1.getNumber());
            }


            session.getTransaction().commit();


        }
    }
}
