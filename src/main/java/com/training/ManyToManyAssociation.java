package com.training;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.training.model.Customer;
import com.training.model.Vendor;
import com.training.util.HibernateUtil;

public class ManyToManyAssociation {
	
	public static void main(String[] args) {
		
		// save();
		fetchCustomers();
		HibernateUtil.closeSessionFactory();		
	}
	
	public static void save() {
		Customer customer1 = new Customer();
		customer1.setName("Pragati Software Pvt Ltd.");
		customer1.setAddress("Andheri");
		
		Customer customer2 = new Customer();
		customer2.setName("Capgemini");
		customer2.setAddress("Airoli");
		
		Vendor vendor1 = new Vendor();
		vendor1.setName("Synergetics");
		vendor1.setAddress("Andheri");
		
		Vendor vendor2 = new Vendor();
		vendor2.setName("Vinsys");
		vendor2.setAddress("Pune");
		
		customer1.setVendors(Arrays.asList(vendor1, vendor2));
		customer2.setVendors(Arrays.asList(vendor1, vendor2));
		
		vendor1.setCustomers(Arrays.asList(customer1, customer2));
		vendor2.setCustomers(Arrays.asList(customer1, customer2));
		
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		session.persist(customer1);
		session.persist(customer2);
		
		tx.commit();
		session.close();
	}
	
	public static void fetchCustomers() {
		
		Session session = HibernateUtil.getSession();
		Customer customer = session.get(Customer.class, 133000119);
		
		System.out.println("Customer details => ");
		System.out.println(customer.getName() + " - " + customer.getAddress());
		List<Vendor> vendors = customer.getVendors();
		
		System.out.println("Vendor details => ");
		vendors.forEach(vendor -> System.out.println(vendor.getName() + " - " + vendor.getAddress()));
		
		session.close();
	}
}







































