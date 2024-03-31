package com.cdac.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="tbl_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	private String name;
	private String email;
	private String phone;
	private String pass; 
	private String state;
	private String city;
	
	
	@JsonProperty
	private boolean isTransporter;
	@JsonProperty
	private boolean isAdmin=false ;
	
	private String  role;
	
	@OneToMany(mappedBy="user" ,cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Advertisement> advertisements;
	
	@OneToMany(mappedBy="user" ,cascade = CascadeType.ALL)
	@JsonIgnore
    private List<Bidding> bids;


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Advertisement> getAdvertisements() {
		return advertisements;
	}

	public void setAdvertisements(List<Advertisement> advertisements) {
		this.advertisements = advertisements;
	}

	public List<Bidding> getBids() {
		return bids;
	}

	public void setBids(List<Bidding> bids) {
		this.bids = bids;
	}
	public void setRole(String role)
	{
		this.role=role;
	}
	
	public String getRole()
	{
		return role;
	}
	
	
}
