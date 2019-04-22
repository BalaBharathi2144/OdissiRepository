package com.bala.frontend.Controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bala.backend.DAO.CategoryDAO;
import com.bala.backend.DAO.ProductDAO;
import com.bala.backend.model.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CategoryDAO categoryDAO;

	void addimage(MultipartFile f, int id) 
	{
		try 
		{
				String path = "D:\\MyEclipseWorkSpace\\frontend\\src\\main\\webapp\\resources\\pimages\\";// location that u copied
				path = path + String.valueOf(id) + ".jpg";
				if (!f.isEmpty()) 
				{
					byte[] imagebytes = f.getBytes();
					File x = new File(path);
					if (x.exists()) 
					{
						x.delete();
						BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
						bs.write(imagebytes);
						bs.close();
					} else 
					{
						BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
						bs.write(imagebytes);
						bs.close();
					}
				}
				Thread.sleep(5000);
		} 
		catch (Exception e) 
		{

		}
	}

	@RequestMapping("/supplier/product")
	String product(Model model) {
		model.addAttribute("product", true);
		model.addAttribute("myproduct", new Product());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("fail", false);
		model.addAttribute("prolist", productDAO.selectAllProduct());
		model.addAttribute("catlist", categoryDAO.selectAllCategory());
		model.addAttribute("edit", false);

		return "index";
	}

	@RequestMapping("/supplier/addProduct")
	String insertproduct(@Valid @ModelAttribute("myproduct") Product p, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
		{
			System.out.println(bindingResult.toString());
			System.out.println(bindingResult.toString());
			model.addAttribute("product", true);
			model.addAttribute("myproduct", p);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail", false);
			model.addAttribute("prolist", productDAO.selectAllProduct());
			model.addAttribute("catlist", categoryDAO.selectAllCategory());
			model.addAttribute("edit", false);
		} 
		else 
		{
			try 
			{
				if (productDAO.createProduct(p)) 
				{
					addimage(p.getProduct_Image(), p.getProduct_Id());
					model.addAttribute("product", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("fail", false);
					model.addAttribute("prolist", productDAO.selectAllProduct());
					model.addAttribute("catlist", categoryDAO.selectAllCategory());
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("product", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", false);
					model.addAttribute("error2", false);
					model.addAttribute("fail", true);
					model.addAttribute("prolist", productDAO.selectAllProduct());
					model.addAttribute("catlist", categoryDAO.selectAllCategory());
					model.addAttribute("edit", false);
				}
			} catch (Exception e) {
				model.addAttribute("product", true);
				model.addAttribute("myproduct", p);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("fail", false);
				model.addAttribute("prolist", productDAO.selectAllProduct());
				model.addAttribute("catlist", categoryDAO.selectAllCategory());
				model.addAttribute("edit", false);
			}
		}

		return "index";
	}

	@RequestMapping("/supplier/updateProduct")
	String updateproduct(@Valid @ModelAttribute("myproduct") Product p, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			model.addAttribute("product", true);
			model.addAttribute("myproduct", p);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail", false);
			model.addAttribute("prolist", productDAO.selectAllProduct());
			model.addAttribute("catlist", categoryDAO.selectAllCategory());
			model.addAttribute("edit", true);
		} 
		else 
		{
			try 
			{
				if (productDAO.updateProduct(p)) 
				{
					addimage(p.getProduct_Image(), p.getProduct_Id());
					model.addAttribute("product", true);
					model.addAttribute("myproduct", new Product());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("fail", false);
					model.addAttribute("prolist", productDAO.selectAllProduct());
					model.addAttribute("catlist", categoryDAO.selectAllCategory());
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("product", true);
					model.addAttribute("myproduct", p);
					model.addAttribute("error1", false);
					model.addAttribute("success", false);
					model.addAttribute("error2", false);
					model.addAttribute("fail", true);
					model.addAttribute("prolist", productDAO.selectAllProduct());
					model.addAttribute("catlist", categoryDAO.selectAllCategory());
					model.addAttribute("edit", true);
				}
			} catch (Exception e) {
				model.addAttribute("product", true);
				model.addAttribute("myproduct", p);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("fail", false);
				model.addAttribute("prolist", productDAO.selectAllProduct());
				model.addAttribute("catlist", categoryDAO.selectAllCategory());
				model.addAttribute("edit", true);
			}
		}

		return "index";
	}

	@RequestMapping("/supplier/deleteProduct")
	String deleteproduct(@RequestParam("proid") int product_Id, Model model) {
		try {
			if (productDAO.deleteProduct(productDAO.selectOneProduct(product_Id)))
				return "redirect:/product";
			else {
				model.addAttribute("product", true);
				model.addAttribute("myproduct", new Product());
				model.addAttribute("error1", false);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("fail", true);
				model.addAttribute("prolist", productDAO.selectAllProduct());
				model.addAttribute("catlist", categoryDAO.selectAllCategory());
				model.addAttribute("edit", false);
				return "index";
			}

		} catch (Exception e) {
			model.addAttribute("product", true);
			model.addAttribute("myproduct", new Product());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail", true);
			model.addAttribute("prolist", productDAO.selectAllProduct());
			model.addAttribute("catlist", categoryDAO.selectAllCategory());
			model.addAttribute("edit", false);
			return "index";
		}
	}

	@RequestMapping("/supplier/editProduct")
	String editproduct(@RequestParam("proid") int product_Id, Model model) {
		model.addAttribute("product", true);
		model.addAttribute("myproduct", productDAO.selectOneProduct(product_Id));
		model.addAttribute("prolist", productDAO.selectAllProduct());
		model.addAttribute("catlist", categoryDAO.selectAllCategory());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("fail", false);
		model.addAttribute("edit", true);
		return "index";
	}
}
