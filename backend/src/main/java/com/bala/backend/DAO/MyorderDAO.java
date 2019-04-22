package com.bala.backend.DAO;

import java.util.List;

import com.bala.backend.model.Myorder;

public interface MyorderDAO 
{
	boolean createOrder(Myorder myorder);
	boolean updateOrder(Myorder myorder);
	boolean deleteOrder(Myorder myorder);
	List<Myorder> selectAllOrder(int user_Id);
	Myorder selectOneOrder(String myorder_Id);
}
