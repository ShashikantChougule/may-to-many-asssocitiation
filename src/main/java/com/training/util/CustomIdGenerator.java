package com.training.util;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		Random random = new Random();
		int value = random.nextInt(100);
		LocalTime time = LocalTime.now();
		System.out.println(value + " - " + time.getMinute() + " - " + time.getSecond() + " - " + time.getNano());
		return value + time.getMinute() + time.getSecond() + time.getNano();		 
	}

}

// We can create a table in database that has only one column that contains primary key value.
// --------------------------
// primary_key_table |
// --------------------------
// 102                       |
// --------------------------

// ICICI1024
// SB1234














