package com.bala.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Address 
{
	@ManyToOne
	UserDetails userdetails;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int address_Id;
	
	@Column(nullable=false)
	@NotEmpty(message="Billing Name is mandatory")
	private String billName;
	
	@Column(nullable=false)
	@NotEmpty(message="Billing Email is mandatory")
	private String billEmailid;
	
	@Column(nullable=false)
	@NotEmpty(message="Address Line1 is mandatory")
	private String line1;
	
	@Column(nullable=false)
	@NotEmpty(message="Address Line2 is mandatory")
	private String line2;
	
	@Column(nullable=false)
	@NotEmpty(message="User city is mandatory")
	private String city;
	
	@Column(nullable=false)
	@NotEmpty(message="User state is mandatory")
	private String state;
	
	@Column(nullable=false)
	@NotEmpty(message="User country is mandatory")
	private String country;
	
	@Column(nullable=false)
	private int pincode;

	public UserDetails getUserdetails() {
		return userdetails;
	}

	public void setUserdetails(UserDetails userdetails) {
		this.userdetails = userdetails;
	}

	public int getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(int address_Id) {
		this.address_Id = address_Id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getBillEmailid() {
		return billEmailid;
	}

	public void setBillEmailid(String billEmailid) {
		this.billEmailid = billEmailid;
	}

	public String getBillName() {
		return billName;
	}

	public void setBillName(String billName) {
		this.billName = billName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
