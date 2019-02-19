package com.bala.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
//import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class UserDetails 
{	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	
	@NotEmpty(message="User Name is mandatory")
	@Column(nullable=false,unique=true)
	private String user_Name;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Email id is mandatory")
//	@Pattern(regexp="^[a-zA-Z0-9_+&*-]+(?:\\."+ "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$")
	private String emailid;
	
	@Column(nullable=false,unique=true)
	@NotBlank(message="Phone Number is mandatory")
//	@Pattern(regexp="\\d{10}")
	private String phno;
	
	@Column(nullable=false)
	@NotBlank(message="Password is mandatory")
//	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")
	@Transient
	private String user_Password;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getUser_Password() {
		return user_Password;
	}

	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	
	}
