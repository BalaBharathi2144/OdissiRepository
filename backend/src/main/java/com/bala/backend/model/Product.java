package com.bala.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity
public class Product 
{
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Product Name is mandatory")
	private String product_Name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int product_Id;
	
	@Column(nullable=false,columnDefinition="text")
	@NotEmpty(message="Product Description is mandatory")
	private String product_Desc;
	
	@ManyToOne
	Category product_Category;

	@ManyToOne
	Supplier supplier;
	
	@Transient
	private MultipartFile product_Image;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column(nullable=false)
	private int price;

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public String getProduct_Desc() {
		return product_Desc;
	}

	public void setProduct_Desc(String product_Desc) {
		this.product_Desc = product_Desc;
	}

	public Category getProduct_Category() {
		return product_Category;
	}

	public void setProduct_Category(Category product_Category) {
		this.product_Category = product_Category;
	}

	public MultipartFile getProduct_Image() {
		return product_Image;
	}

	public void setProduct_Image(MultipartFile product_Image) {
		this.product_Image = product_Image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
}
