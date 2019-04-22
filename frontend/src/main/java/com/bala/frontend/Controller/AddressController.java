package com.bala.frontend.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.backend.DAO.AddressDAO;
import com.bala.backend.model.Address;

@Controller
@RequestMapping("/user")
public class AddressController 
{
	@Autowired
	AddressDAO addressDAO;
	
	@RequestMapping("/address")
	String category(Model model, HttpSession session)
	{
		model.addAttribute("address", true);
		model.addAttribute("myaddress", new Address());
		model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
		model.addAttribute("edit", false);
		return "index";
	}
	@RequestMapping("/addAddress")
	String insertcategory(@Valid@ModelAttribute("myaddress")Address a,BindingResult bindingResult,Model model,HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
				System.out.println(bindingResult.toString());
				model.addAttribute("address",true);
				model.addAttribute("myaddress",new Address());
				model.addAttribute("error1",true);	
				model.addAttribute("success",false);
				model.addAttribute("error2",false);
				model.addAttribute("fail",false);
				model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("edit", false);
		}
		else
		{
			try
			{
				if(addressDAO.createAddress(a))
				{
					model.addAttribute("address",true);
					model.addAttribute("myaddress",new Address());
					model.addAttribute("error1",false);	
					model.addAttribute("success", true);
					model.addAttribute("error2",false);
					model.addAttribute("fail",false);
					model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("edit", false);
				}
				else
				{
					model.addAttribute("address",true);
					model.addAttribute("myaddress",a);
					model.addAttribute("error1",false);	
					model.addAttribute("success", false);
					model.addAttribute("error2",false);
					model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("fail",true);
					model.addAttribute("edit", false);
				}
			}
			catch(Exception e)
			{
				model.addAttribute("address",true);
				model.addAttribute("myaddress",a);
				model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("fail",false);
				model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("edit", false);
			}
		}
		
		return "index";
	}
	
	@RequestMapping("/updateAddress")
	String updatecategory(@Valid@ModelAttribute("myaddress")Address a,BindingResult bindingResult,Model model,HttpSession session)
	{
		if(bindingResult.hasErrors())
		{
				model.addAttribute("address",true);
				model.addAttribute("myaddress",new Address());
				model.addAttribute("error1",true);	
				model.addAttribute("success",false);
				model.addAttribute("error2",false);
				model.addAttribute("fail",false);
				model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("edit", true);
		}
		else
		{
			try
			{
				if(addressDAO.updateAddress(a))
				{
					model.addAttribute("address",true);
					model.addAttribute("myaddress",new Address());
					model.addAttribute("error1",false);	
					model.addAttribute("success", true);
					model.addAttribute("error2",false);
					model.addAttribute("fail",false);
					model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("edit", false);
				}
				else
				{
					model.addAttribute("address",true);
					model.addAttribute("myaddress",a);
					model.addAttribute("error1",false);	
					model.addAttribute("success", false);
					model.addAttribute("error2",false);
					model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
					model.addAttribute("fail",true);
					model.addAttribute("edit", true);
				}
			}
			catch(Exception e)
			{
				model.addAttribute("address",true);
				model.addAttribute("myaddress",a);
				model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("fail",false);
				model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("edit", true);
			}
		}
		
		return "index";
	}
	
	@RequestMapping("/deleteAddress")
	String deletecategory(@RequestParam("addid")int address_Id,Model model,HttpSession session)
	{
		try
		{
			if(addressDAO.deleteAddress(addressDAO.selectOneAddress(address_Id)))
			return "redirect:/user/address";
			else
			{
				model.addAttribute("address", true);
				model.addAttribute("myaddress", new Address());
				model.addAttribute("error1", false);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("fail",true);
				model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
				model.addAttribute("edit", false);
				return "index";
			}
			
		}
		catch (Exception e) 
		{
			model.addAttribute("address", true);
			model.addAttribute("myaddress", new Address());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail",true);
			model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
			model.addAttribute("edit", false);
			return "index";
		}
	}
	
	@RequestMapping("/editAddress")
	String editcategory(@RequestParam("addid")int address_Id,Model model,HttpSession session)
	{
		model.addAttribute("address", true);
		model.addAttribute("myaddress",addressDAO.selectOneAddress(address_Id));
		model.addAttribute("addlist",addressDAO.selectAllAddress(Integer.parseInt(session.getAttribute("usercartid").toString())));
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
		model.addAttribute("edit", true);
		return "index";
	}
}