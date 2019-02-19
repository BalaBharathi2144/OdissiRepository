package com.bala.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Supplier 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int supplier_Id;

	@NotEmpty(message = "Supplier Name is mandatory")
	@Column(nullable = false)
	String supplier_Name;

	@NotEmpty(message = "Supplier Location is mandatory")
	@Column(nullable = false)
	String location;

	@NotEmpty(message = "Supplier Phone Number is mandatory")
	@Column(nullable = false, unique = true)
	String supplier_Phno;

	@NotEmpty(message = "Supplier EmailId is mandatory")
	@Column(nullable = false, unique = true)
	String supplier_Emailid;
	
	@Transient
	@NotEmpty(message = "Supplier Password is mandatory")
	@Column(nullable = false)
	String supplier_Password;
	

	public String getSupplier_Password() {
		return supplier_Password;
	}

	public void setSupplier_Password(String supplier_Password) {
		this.supplier_Password = supplier_Password;
	}

	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}

	public String getSupplier_Name() {
		return supplier_Name;
	}

	public void setSupplier_Name(String supplier_Name) {
		this.supplier_Name = supplier_Name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSupplier_Phno() {
		return supplier_Phno;
	}

	public void setSupplier_Phno(String supplier_Phno) {
		this.supplier_Phno = supplier_Phno;
	}

	public String getSupplier_Emailid() {
		return supplier_Emailid;
	}

	public void setSupplier_Emailid(String supplier_Emailid) {
		this.supplier_Emailid = supplier_Emailid;
	}
}
