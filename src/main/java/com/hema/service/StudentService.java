
package com.hema.service;

import com.hema.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class StudentService {
    public static void createTable(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        System.out.println("Sucessfully create Student Table");
        sessionFactory.close();
        session.close();
    }
    public static void addStudents(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student sone= new Student();
        sone.setFirstName("Morgan");
        sone.setLastName("Jones");
        sone.setEmail("morgan.mj@gmail.com");
        sone.setMajor("Biology");

        Student stwo= new Student();
        stwo.setFirstName("Jane");
        stwo.setLastName("Smith");
        stwo.setEmail("jSmith@gmail.com");
        stwo.setMajor("Aviation");

        Student sthree= new Student();
        sthree.setFirstName("Jeffery");
        sthree.setLastName("Kimmel");
        sthree.setEmail("jKimmel@gmail.com");
        sthree.setMajor("Art");

        Student sfour= new Student("Nancy","Gordon","ng@gmail.com","Chemistry");
        Student sfive= new Student("Norm","Jones","nj@gmail.com","Accounting");

        session.persist(sone);
        session.persist(stwo);
        session.persist(sthree);
        session.persist(sfour);
        session.persist(sfive);

        transaction.commit();
        System.out.println("Sucessfully create Student Table");
        sessionFactory.close();
        session.close();
    }

    public static void findStudents(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        int studentId =2;
        Student s = session.load(Student.class, studentId);
        System.out.println("First: "+s.getFirstName());
        System.out.println("Last: "+s.getLastName());
        System.out.println("Email: "+s.getEmail());

        transaction.commit();
        sessionFactory.close();
        session.close();
    }
    public static void updateStudents(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student s= new Student();
        s.setId(2);
        s.setFirstName("Mattew");
        s.setLastName("Mortin");
        s.setEmail("mattew.mortin@gmail.com");
        session.merge(s);
        session.getTransaction().commit();
        sessionFactory.close();
        session.close();
    }
    public static void deleteStudents(){
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student s= new Student();
        s.setId(3);
        session.remove(s);
        transaction.commit();
        sessionFactory.close();
        session.close();

    }
}