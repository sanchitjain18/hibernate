package com.sanchit.hibernateProject;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Project started.." );
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        
        //Creating a Student
        Student st = new Student(101, "Sanchit", "Jaipur");
        st.setId(102);
        st.setName("JOHN");
        st.setCity("DELHI");
        
        //Creating Address of the Student
        Address ad = new Address();
        ad.setAddressId(1);
        ad.setStreet("Sanganer");
        ad.setCity("Jaipur");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(15.78);
        
        System.out.println(st);
        
        Session session =  factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
    }
}
