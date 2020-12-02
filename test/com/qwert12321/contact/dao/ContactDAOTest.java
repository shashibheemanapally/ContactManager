package com.qwert12321.contact.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.qwert12321.contact.model.Contact;

class ContactDAOTest {
	
	private DriverManagerDataSource dataSource;
	private	ContactDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contact_db");
		dataSource.setUsername("root");
		dataSource.setPassword("bsk313352");
		
		dao=new ContactDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		
		
		Contact contact = new Contact("clark","mark@gg.com","USA,usa","987654321");
		
		int res=dao.save(contact);
		
		assertTrue(res>0);
	}

	@Test
	void testUpdate() {
		Contact contact = new Contact(4,"maaaark","mark@gg.com","USA,usa","987654321");
		
		int res=dao.update(contact);
		
		assertTrue(res>0);
	}

	@Test
	void testGet() {
		Integer c_id=4;
		Contact contact=dao.get(c_id);
		System.out.print(contact);
		assertNotNull(contact);
	}

	@Test
	void testDelete() {
		Integer c_id=5;
		int res=dao.delete(c_id);
		assertTrue(res>0);
	}

	@Test
	void testList() {
		List<Contact> list=dao.list();
		for(Contact c : list) {
			System.out.println(c);
		}
		assertTrue(!list.isEmpty());
	}

}
