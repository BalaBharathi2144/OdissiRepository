package com.bala.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Myorder 
{
	@Id
	private String myorder_Id;
	
	@ManyToOne
	UserDetails userdetails;
	
	@ManyToOne
	Address address;
	
	@ManyToOne
	Product product;
	
	@Column
	@Temporal(TemporalType.DATE)
	Date order_Date;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private float grandTotal;

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getMyorder_Id() {
		return myorder_Id;
	}

	public void setMyorder_Id(String myorder_Id) {
		this.myorder_Id = myorder_Id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(float grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Date getOrder_Date() {
		return order_Date;
	}

	public void setOrder_Date(Date order_Date) {
		this.order_Date = order_Date;
	}
}
