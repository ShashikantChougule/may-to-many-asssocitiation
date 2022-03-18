package com.training.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.training.model.Customer;
import com.training.model.Vendor;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	public static Session getSession() {
		return factory.openSession();
	}
	
	public static void closeSessionFactory() {
		factory.close();
	}
	
	static {
		Configuration configuration = new Configuration().configure()
																					.addAnnotatedClass(Customer.class)
																					.addAnnotatedClass(Vendor.class);
				                                                                  
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
}
