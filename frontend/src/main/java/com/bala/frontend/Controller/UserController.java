package com.bala.frontend.Controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bala.backend.DAO.CartDAO;
import com.bala.backend.DAO.SupplierDAO;
import com.bala.backend.DAO.UserDAO;
import com.bala.backend.model.Cart;
import com.bala.backend.model.Supplier;
import com.bala.backend.model.UserDetails;

@Controller
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	SupplierDAO supplierDAO;
	
	@Autowired
	CartDAO cartDAO;
	
	@RequestMapping("/login")
	String user(Model model)
	{
		model.addAttribute("user", true);
		model.addAttribute("myuser", new UserDetails());
//		model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
		model.addAttribute("error",false);
		return "index";
	}
	
	@RequestMapping("/loginsuccess")
	public String isLoggedin(HttpSession session) 
	{
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) SecurityContextHolder.getContext()
				.getAuthentication().getAuthorities();
		for (GrantedAuthority authority : authorities) 
		{
			if (authority.getAuthority().equals("ROLE_USER")) 
			{
				UserDetails user = userDAO.selectOneUser(email);
				List<Cart> cartitems=cartDAO.selectAllCart(user.getUser_id());
				session.setAttribute("cartitems", cartitems);
				session.setAttribute("itemcount", cartitems.size());
				session.setAttribute("useremail", user.getEmailid());
				session.setAttribute("usercartid", user.getUser_id());
				session.setAttribute("Loginname",user.getUser_Name());
				session.setAttribute("Userloggedin", true);
				if(session.getAttribute("pid")==null)
				{
					return "redirect:/viewAllProduct";
				}
				else
				{
					return "redirect:/addToCart?pid="+Integer.parseInt(session.getAttribute("pid").toString());
				}
			} 
			else if(authority.getAuthority().equals("ROLE_ADMIN"))
			{
				Supplier supplier=supplierDAO.selectOneSupplier(email);
				session.setAttribute("Supplierloggedin", true);
				session.setAttribute("supplierid",supplier.getSupplier_Id());
				session.setAttribute("Loginname", supplier.getSupplier_Name());
			}
			else
			{
				session.setAttribute("Adminloggedin", true);
				session.setAttribute("Loginname", "Administrator");
			}
		}
		return "redirect:/";
		
	}
	
	@RequestMapping("/flogin")
	String fuser(Model model)
	{
		model.addAttribute("user", true);
		model.addAttribute("myuser", new UserDetails());
//		model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
		model.addAttribute("error",true);
		return "index";
	}
	
	@RequestMapping("/addUser")
	String insertuser(@Valid@ModelAttribute("myuser")UserDetails u,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
				System.out.println(bindingResult.toString());
				model.addAttribute("user",true);
				model.addAttribute("myuser",new UserDetails());
				model.addAttribute("error1",true);	
				model.addAttribute("success",false);
				model.addAttribute("error2",false);
				model.addAttribute("fail",false);
				model.addAttribute("error",false);
//				model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
		}
		else
		{
			try
			{
				if(userDAO.createUser(u))
				{
					model.addAttribute("user",true);
					model.addAttribute("myuser",new UserDetails());
					model.addAttribute("error1",false);	
					model.addAttribute("success", true);
					model.addAttribute("error2",false);
					model.addAttribute("fail",false);
					model.addAttribute("error",false);
//					model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
				}
				else
				{
					model.addAttribute("user",true);
					model.addAttribute("myuser",u);
					model.addAttribute("error1",false);	
					model.addAttribute("success", false);
					model.addAttribute("error2",false);
//					model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
					model.addAttribute("fail",true);
					model.addAttribute("error",false);
				}
			}
			catch(Exception e)
			{
				model.addAttribute("user",true);
				model.addAttribute("myuser",u);
				model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("fail",false);
				model.addAttribute("error",false);
//				model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
			}
		}
		
		return "index";
	}
	
}
