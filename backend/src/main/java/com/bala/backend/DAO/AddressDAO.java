package com.bala.backend.DAO;

import java.util.List;

import com.bala.backend.model.Address;
import com.bala.backend.model.UserDetails;

public interface AddressDAO 
{
	boolean createAddress(Address address);
	boolean updateAddress(Address address);
	boolean deleteAddress(Address address);
	List<Address> selectAllAddress(int user_Id);
	Address selectOneAddress(int address_Id);
}
