package com.bala.frontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.backend.DAO.CategoryDAO;
import com.bala.backend.model.Category;

@Controller
@RequestMapping("/admin")
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/category")
	String category(Model model)
	{
		model.addAttribute("category", true);
		model.addAttribute("mycategory", new Category());
		model.addAttribute("catlist",categoryDAO.selectAllCategory());
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
		model.addAttribute("edit", false);
		return "index";
	}
	@RequestMapping("/addCategory")
	String insertcategory(@Valid@ModelAttribute("mycategory")Category c,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
				model.addAttribute("category",true);
				model.addAttribute("mycategory",new Category());
				model.addAttribute("error1",true);	
				model.addAttribute("success",false);
				model.addAttribute("error2",false);
				model.addAttribute("fail",false);
				model.addAttribute("catlist",categoryDAO.selectAllCategory());
				model.addAttribute("edit", false);
		}
		else
		{
			try
			{
				if(categoryDAO.createCategory(c))
				{
					model.addAttribute("category",true);
					model.addAttribute("mycategory",new Category());
					model.addAttribute("error1",false);	
					model.addAttribute("success", true);
					model.addAttribute("error2",false);
					model.addAttribute("fail",false);
					model.addAttribute("catlist",categoryDAO.selectAllCategory());
					model.addAttribute("edit", false);
				}
				else
				{
					model.addAttribute("category",true);
					model.addAttribute("mycategory",c);
					model.addAttribute("error1",false);	
					model.addAttribute("success", false);
					model.addAttribute("error2",false);
					model.addAttribute("catlist",categoryDAO.selectAllCategory());
					model.addAttribute("fail",true);
					model.addAttribute("edit", false);
				}
			}
			catch(Exception e)
			{
				model.addAttribute("category",true);
				model.addAttribute("mycategory",c);
				model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("fail",false);
				model.addAttribute("catlist",categoryDAO.selectAllCategory());
				model.addAttribute("edit", false);
			}
		}
		
		return "index";
	}
	
	@RequestMapping("/updateCategory")
	String updatecategory(@Valid@ModelAttribute("mycategory")Category c,BindingResult bindingResult,Model model)
	{
		if(bindingResult.hasErrors())
		{
				model.addAttribute("category",true);
				model.addAttribute("mycategory",new Category());
				model.addAttribute("error1",true);	
				model.addAttribute("success",false);
				model.addAttribute("error2",false);
				model.addAttribute("fail",false);
				model.addAttribute("catlist",categoryDAO.selectAllCategory());
				model.addAttribute("edit", true);
		}
		else
		{
			try
			{
				if(categoryDAO.updateCategory(c))
				{
					model.addAttribute("category",true);
					model.addAttribute("mycategory",new Category());
					model.addAttribute("error1",false);	
					model.addAttribute("success", true);
					model.addAttribute("error2",false);
					model.addAttribute("fail",false);
					model.addAttribute("catlist",categoryDAO.selectAllCategory());
					model.addAttribute("edit", false);
				}
				else
				{
					model.addAttribute("category",true);
					model.addAttribute("mycategory",c);
					model.addAttribute("error1",false);	
					model.addAttribute("success", false);
					model.addAttribute("error2",false);
					model.addAttribute("catlist",categoryDAO.selectAllCategory());
					model.addAttribute("fail",true);
					model.addAttribute("edit", true);
				}
			}
			catch(Exception e)
			{
				model.addAttribute("category",true);
				model.addAttribute("mycategory",c);
				model.addAttribute("error1",false);
				model.addAttribute("error2",true);	
				model.addAttribute("success",false);
				model.addAttribute("fail",false);
				model.addAttribute("catlist",categoryDAO.selectAllCategory());
				model.addAttribute("edit", true);
			}
		}
		
		return "index";
	}
	
	@RequestMapping("/deleteCategory")
	String deletecategory(@RequestParam("catid")int category_Id,Model model)
	{
		try
		{
			if(categoryDAO.deleteCategory(categoryDAO.selectOneCategory(category_Id)))
			return "redirect:/category";
			else
			{
				model.addAttribute("category", true);
				model.addAttribute("mycategory", new Category());
				model.addAttribute("error1", false);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("fail",true);
				model.addAttribute("catlist",categoryDAO.selectAllCategory());
				model.addAttribute("edit", false);
				return "index";
			}
			
		}
		catch (Exception e) 
		{
			model.addAttribute("category", true);
			model.addAttribute("mycategory", new Category());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail",true);
			model.addAttribute("catlist",categoryDAO.selectAllCategory());
			model.addAttribute("edit", false);
			return "index";
		}
	}
	
	@RequestMapping("/editCategory")
	String editcategory(@RequestParam("catid")int category_Id,Model model)
	{
		model.addAttribute("category", true);
		model.addAttribute("mycategory",categoryDAO.selectOneCategory(category_Id));
		model.addAttribute("catlist",categoryDAO.selectAllCategory());
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
		model.addAttribute("edit", true);
		return "index";
	}
}
