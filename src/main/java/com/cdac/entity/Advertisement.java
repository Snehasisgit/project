package com.cdac.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="tbl_advertisement")
public class Advertisement {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int add_id;
	
	private String from_location;
	private String to_location;
	private String item_description;
	private double approx_weight;
	private String receiver_name;
	private String receiver_phone;
	private int dest_pincode;
	
	

	private LocalDate expected_deliveryDate;
	
	private boolean isBidFinalized;
	private boolean isPending=true;
	
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_idc")
	private User user;
	
	
	@OneToMany(mappedBy="add")
	@JsonIgnore
    private List<Bidding> bids;

	
	

	public void setBidFinalized(boolean isBidFinalized) {
		this.isBidFinalized = isBidFinalized;
	}


	public int getAdd_id() {
		return add_id;
	}


	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}


	public String getFrom_location() {
		return from_location;
	}


	public void setFrom_location(String from_location) {
		this.from_location = from_location;
	}


	public String getTo_location() {
		return to_location;
	}


	public void setTo_location(String to_location) {
		this.to_location = to_location;
	}


	public String getItem_description() {
		return item_description;
	}


	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}


	public double getApprox_weight() {
		return approx_weight;
	}


	public void setApprox_weight(double approx_weight) {
		this.approx_weight = approx_weight;
	}


	public String getReceiver_name() {
		return receiver_name;
	}


	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}


	public String getReceiver_phone() {
		return receiver_phone;
	}


	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}


	public int getDest_pincode() {
		return dest_pincode;
	}


	public void setDest_pincode(int dest_pincode) {
		this.dest_pincode = dest_pincode;
	}


	


	


	

	public LocalDate getExpected_deliveryDate() {
		return expected_deliveryDate;
	}


	public void setExpected_deliveryDate(LocalDate expected_deliveryDate) {
		this.expected_deliveryDate = expected_deliveryDate;
	}


	public boolean isBidFinalized() {
		return isBidFinalized;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Bidding> getBids() {
		return bids;
	}


	public void setBids(List<Bidding> bids) {
		this.bids = bids;
	}
	public boolean getisPending()
	{
		return isPending;
	}
	public void setisPending(boolean isPending)
	{
		this.isPending=isPending;
		
	}
	
}
