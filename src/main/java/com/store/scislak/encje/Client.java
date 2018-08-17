package com.store.scislak.encje;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="postcode")
	private String postcode;
	
	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="email", insertable=false, updatable=false)
	private LoginDate loginDate;
	
	public Client() {}
	public Client(String name, String last_name, String address, String postcode, String email) {
		super();
		this.name = name;
		this.last_name = last_name;
		this.address = address;
		this.postcode = postcode;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LoginDate getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(LoginDate loginDate) {
		this.loginDate = loginDate;
	}
	@Override
	public String toString() {
		return "[" + id + " " + name + " " + last_name + " " + address + " " + postcode + " " + email + "]";
	}
}