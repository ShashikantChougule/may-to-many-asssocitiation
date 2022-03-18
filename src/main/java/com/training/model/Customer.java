package com.training.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "customers")
@Data  
public class Customer {

	@Id
	@Column(name = "customer_id")
	@GenericGenerator(name = "my-id-generator", strategy = "com.training.util.CustomIdGenerator")
	@GeneratedValue(generator = "my-id-generator")
	private int id;
	private String name;
	private String address;
	@ManyToMany(cascade=CascadeType.PERSIST, mappedBy="customers")   // By default, lazy loading, you can make it eager loading using fetch=FetchType.EAGER
	private List<Vendor> vendors;
}









