package com.bala.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int category_Id;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Category Name is mandatory")
	private String category_Name;
	
	@Column(nullable=false,columnDefinition="text")
	@NotEmpty(message="Category Description is mandatory")
	private String category_Desc;

	
	public int getCategory_Id() {
		return category_Id;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public String getCategory_Desc() {
		return category_Desc;
	}

	public void setCategory_Desc(String category_Desc) {
		this.category_Desc = category_Desc;
	}

	
}
