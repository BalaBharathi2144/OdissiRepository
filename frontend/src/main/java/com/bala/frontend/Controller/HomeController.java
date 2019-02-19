package com.bala.frontend.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController 
{
	@RequestMapping("/")
	String carousel(Model model)
	{
		model.addAttribute("carousel", true);
		return "index";
	}
	@RequestMapping("home")
	String home(Model model)
	{
		model.addAttribute("home", true);
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
	@RequestMapping("/viewProducts")
	String viewProducts(Model model)
	{
		model.addAttribute("viewProducts", true);
		return "index";
	}
	@RequestMapping("/cart")
	String cart(Model model)
	{
		model.addAttribute("cart", true);
		return "index";
	}
}
