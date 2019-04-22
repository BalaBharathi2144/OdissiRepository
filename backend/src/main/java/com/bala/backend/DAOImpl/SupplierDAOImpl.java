package com.bala.backend.DAOImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bala.backend.DAO.SupplierDAO;
import com.bala.backend.model.Supplier;
import com.bala.backend.model.UserCred;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO{
	@Autowired
	SessionFactory sessionFactory;

	public boolean createSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			UserCred usercred=new UserCred();
			usercred.setEmailid(supplier.getSupplier_Emailid());
			usercred.setUser_Password(supplier.getSupplier_Password());
			usercred.setRole("ROLE_ADMIN");
			usercred.setStatus("true");
			sessionFactory.getCurrentSession().save(supplier);
			sessionFactory.getCurrentSession().save(usercred);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().delete(supplier);
			sessionFactory.getCurrentSession().delete(supplier.getSupplier_Emailid(),UserCred.class);
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public List<Supplier> selectAllSupplier() {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from Supplier").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Supplier selectOneSupplier(String supplier_Email) {
		// TODO Auto-generated method stub
		try {
			return (Supplier) sessionFactory.getCurrentSession()
					.createQuery("from Supplier where supplier_Emailid='"+supplier_Email+"'").uniqueResult();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
