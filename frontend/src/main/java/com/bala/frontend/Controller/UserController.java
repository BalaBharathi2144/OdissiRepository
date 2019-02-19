package com.bala.frontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bala.backend.DAO.UserDAO;
import com.bala.backend.model.UserDetails;

@Controller
public class UserController 
{
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping("/signInPage")
	String user(Model model)
	{
		model.addAttribute("user", true);
		model.addAttribute("myuser", new UserDetails());
//		model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
		model.addAttribute("error1",false);	
		model.addAttribute("success",false);
		model.addAttribute("error2",false);
		model.addAttribute("fail",false);
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
//				model.addAttribute("userlist",userDAO.selectOneUser(user_emailid));
			}
		}
		
		return "index";
	}
	
}
