package com.bala.backend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.AddressDAO;
import com.bala.backend.model.Address;
import com.bala.backend.model.UserDetails;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean createAddress(Address address) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().save(address);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean updateAddress(Address address) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().update(address);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean deleteAddress(Address address) 
	{
		// TODO Auto-generated method stub
		try{
			sessionFactory.getCurrentSession().delete(address);
			return true;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public Address selectOneAddress(int address_Id) 
	{
		// TODO Auto-generated method stub
		try
		{
		return (Address)sessionFactory.getCurrentSession().createQuery("from Address where address_Id="+address_Id).uniqueResult();
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Address> selectAllAddress(int user_Id) 
	{
		// TODO Auto-generated method stub
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from Address where userdetails_user_id="+user_Id).list();	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return null;
		}
	}

}
