package com.cdac.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="tbl_bidding")
public class Bidding {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bid_id;
	
	private Double offer_price;
	private LocalDate estimated_deliveryDate;
	private String remark;
	
	private boolean isBidFinalized=false;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="add_id")
	private Advertisement add;
	
	

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name="user_idt")
	private User user;
	

	

	
	public boolean isBidFinalized() {
		return isBidFinalized;
	}

	public void setBidFinalized(boolean isBidFinalized) {
		this.isBidFinalized = isBidFinalized;
	}
	
	

	public int getBid_id() {
		return bid_id;
	}

	public void setBid_id(int bid_id) {
		this.bid_id = bid_id;
	}

	public Double getOffer_price() {
		return offer_price;
	}

	public void setOffer_price(Double offer_price) {
		this.offer_price = offer_price;
	}

	

	public LocalDate getEstimated_deliveryDate() {
		return estimated_deliveryDate;
	}

	public void setEstimated_deliveryDate(LocalDate estimated_deliveryDate) {
		this.estimated_deliveryDate = estimated_deliveryDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Advertisement getAdd() {
		return add;
	}

	public void setAdd(Advertisement add) {
		this.add = add;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
