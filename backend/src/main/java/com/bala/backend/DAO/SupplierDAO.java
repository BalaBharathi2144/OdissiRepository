package com.bala.backend.DAO;

import java.util.List;

import com.bala.backend.model.Supplier;

public interface SupplierDAO 
{
	boolean createSupplier(Supplier supplier);
	boolean updateSupplier(Supplier supplier);
	boolean deleteSupplier(Supplier supplier);
	List<Supplier> selectAllSupplier();
	Supplier selectOneSupplier(int supplier_Id);
}
