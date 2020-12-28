package com.project.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.project.model.Contact;
import com.project.services.DaoImplementation;


class Tests {
	DaoImplementation dao;
	Connection con;
	
	
	
	@BeforeEach
	public void beforeEachTest() {
		dao = new DaoImplementation();
	}
	
	
	
	@Test
	@DisplayName(value="Test whether the contact can be Added")
	void test() {
		Contact tempContact=new Contact("test","addr",12345,"abc.jpg",LocalDate.parse("1990-12-12"),"a@qwe","relatives");
	 int rowsAdded=dao.add(tempContact);
	 assertEquals(1,rowsAdded);
		
	}
	
	
	@Test
	@DisplayName(value="Test whether the contact can be updated")
	void testUpdate() {
		
		int rowsUpdated = dao.updateMobile("xyz",123345);
		assertEquals(1, rowsUpdated);
	}

}
