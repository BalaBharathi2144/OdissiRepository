package com.bala.backend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.ProductDAO;
import com.bala.backend.model.Product;

@Repository("ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean createProduct(Product product) 
	{
		try{
			sessionFactory.getCurrentSession().save(product);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateProduct(Product product) 
	{
		try{
			sessionFactory.getCurrentSession().update(product);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteProduct(Product product) 
	{
		try{
			sessionFactory.getCurrentSession().delete(product);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Product> selectAllProduct() 
	{
		try{
			return sessionFactory.getCurrentSession().createQuery("from Product").list();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Product selectOneProduct(int product_Id) 
	{
		try
		{
		return (Product)sessionFactory.getCurrentSession().createQuery("from Product where product_Id="+product_Id).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
