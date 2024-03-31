package com.cdac.dto;

import java.time.LocalDate;

import com.cdac.entity.User;


public class PlaceBidData {
 
	
	private double offer_price; 
	private LocalDate estimated_deliveryDate;
	private String remark ; 
	private User user;
	
	
	public double getOffer_price() {
		return offer_price;
	}
	public void setOffer_price(double offer_price) {
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
