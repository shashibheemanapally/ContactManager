package com.qwert12321.contact.model;

public class Contact {
	private Integer c_id;
	private String name;
	private String email;
	private String address;
	private String phone;
	
	public Contact() {
		
	}
	public Contact(Integer c_id, String name, String email, String address, String phone) {
		
		
		this(name,email,address,phone);
		this.c_id = c_id;
	}
	public Contact( String name, String email, String address, String phone) {
		
		
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Contact [id=" + c_id + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	
}
