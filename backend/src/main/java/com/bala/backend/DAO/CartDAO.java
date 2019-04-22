package com.bala.backend.DAO;

import java.util.List;

import com.bala.backend.model.Cart;
import com.bala.backend.model.UserDetails;

public interface CartDAO 
{
	boolean createCart(Cart cart);
	boolean updateCart(Cart cart);
	boolean deleteCart(Cart cart);
	List<Cart> selectAllCart(int user_Id);
	Cart selectOneCart(int item_Id);
}
