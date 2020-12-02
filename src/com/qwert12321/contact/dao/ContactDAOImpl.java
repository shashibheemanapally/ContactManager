package com.qwert12321.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.qwert12321.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public  ContactDAOImpl(DataSource dataSource) {
		
		this.jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Contact contact) {
		
		String sql="INSERT INTO contact (name,email,address,phone) VALUES(?,?,?,?)";
		return jdbcTemplate.update(sql,contact.getName(),contact.getEmail(),contact.getAddress(),contact.getPhone());
	}

	@Override
	public int update(Contact contact) {
		String sql="UPDATE contact SET name=?,email=?,address=?,phone=? WHERE c_id=?";
		return jdbcTemplate.update(sql,contact.getName(),contact.getEmail(),contact.getAddress(),contact.getPhone(),contact.getC_id());
	}

	@Override
	public Contact get(Integer c_id) {
		String sql="SELECT * FROM contact WHERE c_id="+c_id;
		
		ResultSetExtractor<Contact> extractor= new ResultSetExtractor<Contact>() {
			
			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name=rs.getString("name");
					String email=rs.getString("email");
					String address=rs.getString("address");
					String phone=rs.getString("phone");
					
					return new Contact(c_id,name,email,address,phone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer c_id) {
		String sql= "DELETE FROM contact WHERE c_id="+c_id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> list() {
		
		String sql="SELECT * FROM contact";
		
		ResultSetExtractor<List<Contact>> extractor= new ResultSetExtractor<List<Contact>>() {
			
			@Override
			public List<Contact> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<Contact> list= new ArrayList<Contact>();
				while(rs.next()) {
					Integer c_id=rs.getInt("c_id");
					String name=rs.getString("name");
					String email=rs.getString("email");
					String address=rs.getString("address");
					String phone=rs.getString("phone");
					
					list.add(new Contact(c_id,name,email,address,phone)) ;
				}
				return list;
				
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

}
