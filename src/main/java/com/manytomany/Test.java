package com.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		Session session = sessionFactory.openSession();
		
		Transaction t = session.beginTransaction();
		
		User user1 = new User();
		user1.setName("rushikesh");
		user1.setEmail("rushikesh@gmail.com");
		
		User user2  = new User();
		user2.setName("bhand");
		user2.setEmail("bhand@gmail.com");
		
		Nominee n1 = new Nominee();
		n1.setName("mahadev");
		
		Nominee n2 = new Nominee();
		n2.setName("asha");
		
		Nominee n3 = new Nominee();
		n3.setName("rutuja");
		
		user1.getNomineeList().add(n1);
		user1.getNomineeList().add(n2);
		user1.getNomineeList().add(n3);
		
		
		user2.getNomineeList().add(n2);
		user2.getNomineeList().add(n3);
		
		
		n1.getUserList().add(user1);
		n2.getUserList().add(user1);
		n3.getUserList().add(user1);
		
		n2.getUserList().add(user2);
		n3.getUserList().add(user2);
		
		
		session.persist(user1);
		session.persist(user2);
		
		
		t.commit();
		session.close();
		System.out.println("Record save Successfully");


	}

}
