package com.bala.backend.DAO;

import java.util.List;

import com.bala.backend.model.Product;

public interface ProductDAO 
{
	boolean createProduct(Product product);
	boolean updateProduct(Product product);
	boolean deleteProduct(Product product);
	List<Product> selectAllProduct();
	Product selectOneProduct(int product_Id);
}
