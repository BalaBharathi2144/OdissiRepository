package com.bala.backend.DAOImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.UserDAO;
import com.bala.backend.model.UserCred;
import com.bala.backend.model.UserDetails;

@Repository("UserDAO")
@Transactional
public class UserDAOImpl implements UserDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean createUser(UserDetails user) 
	{
			// TODO Auto-generated method stub
			try
			{
				UserCred usercred=new UserCred();
				usercred.setEmailid(user.getEmailid());
				usercred.setUser_Password(user.getUser_Password());
				usercred.setRole("ROLE_USER");
				usercred.setStatus("true");
				sessionFactory.getCurrentSession().save(user);
				sessionFactory.getCurrentSession().save(usercred);
				return true;
			
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				return false;
			}
	}
	

	public boolean updateUser(UserDetails user) 
	{
		// TODO Auto-generated method stub
				try
				{
					sessionFactory.getCurrentSession().update(user);
					return true;
				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return false;
				}
	}

	public boolean deleteUser(UserDetails user) 
	{
				// TODO Auto-generated method stub
				try
				{
					sessionFactory.getCurrentSession().delete(user);
					sessionFactory.getCurrentSession().delete(user.getEmailid(), UserCred.class);
					return true;
				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return false;
				}
	}

	public UserDetails selectOneUser(String user_emailid) 
	{
				// TODO Auto-generated method stub
				try
				{
					
					return (UserDetails)sessionFactory.getCurrentSession().createQuery("from UserDetails where emailid='"+user_emailid+"'").uniqueResult();
				
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					return null;
				}
	}

}
