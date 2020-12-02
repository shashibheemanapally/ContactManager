package com.qwert12321.contact.dao;

import java.util.List;

import com.qwert12321.contact.model.Contact;


public interface ContactDAO {
	public int save(Contact contact);
	public int update(Contact contact);
	public Contact get(Integer c_id);
	public int delete(Integer c_id);
	public List<Contact> list();
}
