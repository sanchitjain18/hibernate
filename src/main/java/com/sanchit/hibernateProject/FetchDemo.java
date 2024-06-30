package com.sanchit.hibernateProject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Student student = (Student)session.get(Student.class, 101);
		Address address = (Address)session.get(Address.class, 1);
		session.close();
		factory.close();
		System.out.println(student+"\n"+address);
	}
}
