package com.sanchit.hibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	public static void main(String[] args) {
		Certificate c1 = new Certificate("Java", "2 Months");
		Certificate c2 = new Certificate("Python", "3 Months");
		
		Student abhishek = new Student();
		abhishek.setId(1);
		abhishek.setName("Abhishek");
		abhishek.setCity("Delhi");
		abhishek.setCerti(c1);
		
		Student sanchit = new Student();
		sanchit.setId(1);
		sanchit.setName("Sanchit");
		sanchit.setCity("Jaipur");
		sanchit.setCerti(c2);
		
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(abhishek);
		session.save(sanchit);
		tx.commit();
		session.close();
		factory.close();
	}
}
