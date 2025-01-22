package com.hema.repository;
//import javax.persistence.EntityManager;

import org.hibernate.Session;
import com.hema.model.Student;
//import com.mysql.cj.Session;
import jakarta.persistence.TypedQuery;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import javax.management.remote.rmi.RMIServerImpl_Stub;
import java.util.List;

public class HQLQuery {
    //    public static void getStudents() {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = (Session) factory.openSession();
//
//        //  String hql = "FROM Student";
//        //  String hql = "FROM Student s WHERE s.id = 2";
//        String hql = "FROM Student S WHERE S.id > 3 ORDER BY S.major DESC";
//        Query query = session.createQuery(hql);
//        List<Student> results = query.getResultList();
//        for (Student s : results) {
//            System.out.println("Student Id: " + s.getId() + "|" + " First Name: " + s.getFirstName() + "|" + "Last Name: " + s.getLastName() + "Email: " + s.getEmail() + "|" + "Major: " + s.getMajor());
//
//        }
//    }
    public static void getStudents() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = (Session) factory.openSession();

        String hql = "FROM Student S WHERE S.id > 3 ORDER BY S.major DESC";
        TypedQuery query = session.createQuery(hql);
        List<Student> results = query.getResultList();
        for (Student s : results) {
            System.out.println("Student Id: " + s.getId() + "|" + " First Name: " + s.getFirstName() + "|" + "Last Name: " + s.getLastName() + "Email: " + s.getEmail() + "|" + "Major: " + s.getMajor());

        }
    }

    public static void getStudentUsingObject() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = (Session) factory.openSession();
        TypedQuery<Object[]> query = session.createQuery("SELECT U.id, U.firstName,U.lastName FROM Student AS U", Object[].class);
        List<Object[]> results = query.getResultList();
        for (Object[] a : results) {
            System.out.println("ID: " + a[0] + ", Full name: " + a[1]);
        }
    }

    public static void useNameParameter() {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = (Session) factory.openSession();

        String hql = "FROM Student S WHERE S.id=:id";
        TypedQuery<Student> query = session.createQuery(hql);
        for (Student s : query.getResultList()) {
            System.out.println("Student Id: " + s.getId() + "|" + " First Name: " + s.getFirstName() + "|" + "Last Name: " + s.getLastName() + "Email: " + s.getEmail() + "|" + "Major: " + s.getMajor());
        }
    }
    public static void useNamedQuery(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        try{
            //Begin transaction
            session.beginTransaction();

            //Get Named Query
            Query query = session.getNamedQuery("findmajor");
            query.setParameter("major", "Aviation");

            //Execute and retrieve results
            List<Student> students = query.getResultList();
            students.forEach(student ->
                    System.out.println("ID:" + student.getId() + ", Major: " + student.getMajor()));

            //Commit transaction
            session.getTransaction().commit();
        }finally{
            session.close();
            factory.close();
        }
    }

}









