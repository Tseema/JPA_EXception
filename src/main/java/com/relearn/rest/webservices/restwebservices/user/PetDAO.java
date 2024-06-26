package com.relearn.rest.webservices.restwebservices.user;



import java.util.*;
import java.util.function.Predicate;
import java.util.logging.*;
import javax.persistence.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.query.Query;

public class PetDAO {

    public List<Pet> findNamedPetsBySpecies(Session session, String species) {
        List<Pet> pets = new ArrayList<>();
       Query query = session.createNamedQuery("select * from Pet where species = :species and name is NOT NULL",Pet.class);
        pets = query.getResultList();



        //pets.forEach(pet -> System.out.println());
        return pets;
       /* List<Pet> pets = session.createNativeQuery(
                        "SELECT * " +
                                "FROM Pet " +
                                "WHERE species like :species AND name is NOT NULL ")
                .addEntity( Pet.class )
                .setParameter("species", species)
                .list();
        return pets;*/
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    @Entity(name = "Pet")
    @Table
    public static class Pet {
        @Id
        public Integer id;
        @Column
        public String name;

        public Integer getId() {
            return id;
        }



        @Column
        public String species;

        public Pet() {}

        public Pet(Integer id, String name, String species) {
            this.id = id;
            this.name = name;
            this.species = species;
        }
    }

    public static void main(String[] args) {
        LogManager logManager = LogManager.getLogManager();
        Logger logger = logManager.getLogger("");
        logger.setLevel(Level.OFF);

        Properties prop = new Properties();
        prop.setProperty("hibernate.connection.url", "jdbc:h2:mem:db1");
        prop.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");

        SessionFactory sessionFactory = new Configuration().addProperties(prop)
                .addAnnotatedClass(Pet.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Pet dog = new Pet(0, "Lady", "Dog");
        Pet cat = new Pet(1, "Max", "Cat");
        Pet camel = new Pet(2, null, "Camel");

        session.save(dog);
        session.save(cat);
        session.save(camel);
        session.flush();

        PetDAO petDao = new PetDAO();
        List<Pet> pets = petDao.findNamedPetsBySpecies(session, "Cat");
        for(Pet p : pets) {
            System.out.println(p.id);
            System.out.println(p.name);
            System.out.println(p.species);
        }
    }
}

