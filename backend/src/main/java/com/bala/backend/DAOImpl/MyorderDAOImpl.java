package com.bala.backend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.MyorderDAO;
import com.bala.backend.model.Myorder;

@Repository("myorderDAO")
@Transactional
public class MyorderDAOImpl implements MyorderDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean createOrder(Myorder myorder) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(myorder);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateOrder(Myorder myorder) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(myorder);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteOrder(Myorder myorder) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(myorder);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Myorder> selectAllOrder(int user_Id) 
	{
		// TODO Auto-generated method stub
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Myorder where userdetails_user_id='"+user_Id+"'").list();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Myorder selectOneOrder(String order_Id) 
	{
		// TODO Auto-generated method stub
		try
		{
		return (Myorder)sessionFactory.getCurrentSession().createQuery("from Myorder where myorder_Id='"+order_Id+"'").uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
