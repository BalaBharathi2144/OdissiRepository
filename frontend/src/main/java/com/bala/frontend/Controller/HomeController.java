package com.bala.frontend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.backend.DAO.ProductDAO;
import com.bala.backend.model.Product;

@Controller
public class HomeController 
{
	@Autowired
	ProductDAO productDAO;
	
	@RequestMapping(value={"/","/home"})
	String carousel(Model model)
	{
		model.addAttribute("carousel", true);
		return "index";
	}
	@RequestMapping("/aboutus")
	String aboutUs(Model model)
	{
		model.addAttribute("aboutUs", true);
		return "index";
	}
	@RequestMapping("/contactus")
	String contactUs(Model model)
	{
		model.addAttribute("contactUs", true);
		return "index";
	}
	@RequestMapping("/viewAllProduct")
	String viewallproduct(Model model) 
	{
		model.addAttribute("viewallproduct", true);
		model.addAttribute("myproduct", new Product());
		model.addAttribute("prolist", productDAO.selectAllProduct());
		return "index";
	}
	@RequestMapping("/viewOneProduct")
	String viewoneproduct(@RequestParam("proid") int product_Id, Model model) 
	{
		model.addAttribute("viewoneproduct", true);
		model.addAttribute("myproduct", productDAO.selectOneProduct(product_Id));
		return "index";
	}
	@RequestMapping("/cart")
	String cart(Model model)
	{
		model.addAttribute("cart", true);
		return "index";
	}
}
