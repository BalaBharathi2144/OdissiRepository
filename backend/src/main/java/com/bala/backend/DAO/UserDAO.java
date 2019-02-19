package com.bala.backend.DAO;

import com.bala.backend.model.UserDetails;

public interface UserDAO 
{
	boolean createUser(UserDetails user);
	boolean updateUser(UserDetails user);
	boolean deleteUser(UserDetails user);
	//List<User> selectAllUser();
	UserDetails selectOneUser(String user_emailid);
}
