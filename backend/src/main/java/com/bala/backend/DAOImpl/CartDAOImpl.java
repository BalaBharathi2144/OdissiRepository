package com.bala.backend.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.CartDAO;
import com.bala.backend.model.Cart;
import com.bala.backend.model.UserDetails;

@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean createCart(Cart cart) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(cart);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateCart(Cart cart) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteCart(Cart cart) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(cart);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Cart> selectAllCart(int user_Id) 
	{
		// TODO Auto-generated method stub
		List<Cart> cartlist = new ArrayList<Cart>();
		try
		{
			cartlist=sessionFactory.getCurrentSession().createQuery("from Cart where userdetails_user_id="+user_Id).list();	
			return cartlist;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return cartlist;
		}
	}
	
	public Cart selectOneCart(int cart_Id) 
	{
		// TODO Auto-generated method stub
		try
		{
		return (Cart)sessionFactory.getCurrentSession().createQuery("from Cart where cart_Id="+cart_Id).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}
}
