package com.bala.backend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.CategoryDAO;
import com.bala.backend.model.Category;

@Repository("categoryDAO")
@Transactional

public class CategoryDAOImpl implements CategoryDAO 
{
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean createCategory(Category category) 
	{
		// TODO Auto-generated method stub
		
		try{
			sessionFactory.getCurrentSession().save(category);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCategory(Category category) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteCategory(Category category) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(category);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Category> selectAllCategory() 
	{
		// TODO Auto-generated method stub
		try{
			return sessionFactory.getCurrentSession().createQuery("from Category").list();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Category selectOneCategory(int category_Id) 
	{
		try
		{
		return (Category)sessionFactory.getCurrentSession().createQuery("from Category where category_Id="+category_Id).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}