package com.bala.frontend.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.backend.DAO.SupplierDAO;
import com.bala.backend.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO supplierDAO;

//	void addimage(MultipartFile f, int id) 
//	{
//		try 
//		{
//				String path = "D:\\MyEclipseWorkSpace\\frontend\\src\\main\\webapp\\resources\\pimages\\";// location that u copied
//				path = path + String.valueOf(id) + ".jpg";
//				if (!f.isEmpty()) 
//				{
//					byte[] imagebytes = f.getBytes();
//					File x = new File(path);
//					if (x.exists()) 
//					{
//						x.delete();
//						BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
//						bs.write(imagebytes);
//						bs.close();
//					} else 
//					{
//						BufferedOutputStream bs = new BufferedOutputStream(new FileOutputStream(x));
//						bs.write(imagebytes);
//						bs.close();
//					}
//				}
//				Thread.sleep(5000);
//		} 
//		catch (Exception e) 
//		{
//
//		}
//	}

	@RequestMapping("/supplier")
	String product(Model model) {
		model.addAttribute("supplier", true);
		model.addAttribute("mysupplier", new Supplier());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("fail", false);
		model.addAttribute("suplist", supplierDAO.selectAllSupplier());
		model.addAttribute("edit", false);

		return "index";
	}

	@RequestMapping("/addSupplier")
	String insertproduct(@Valid @ModelAttribute("mysupplier") Supplier s, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) 
		{
			System.out.println(bindingResult.toString());
			model.addAttribute("supplier", true);
			model.addAttribute("mysupplier", s);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail", false);
			model.addAttribute("suplist", supplierDAO.selectAllSupplier());
			model.addAttribute("edit", false);
		} 
		else 
		{
			try 
			{
				if (supplierDAO.createSupplier(s)) 
				{
//					addimage(p.getProduct_Image(), s.getSupplier_Id());
					model.addAttribute("supplier", true);
					model.addAttribute("mysupplier", new Supplier());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("fail", false);
					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("supplier", true);
					model.addAttribute("mysupplier", new Supplier());
					model.addAttribute("error1", false);
					model.addAttribute("success", false);
					model.addAttribute("error2", false);
					model.addAttribute("fail", true);
					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
					model.addAttribute("edit", false);
				}
			} catch (Exception e) {
				model.addAttribute("supplier", true);
				model.addAttribute("mysupplier", s);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("fail", false);
				model.addAttribute("suplist", supplierDAO.selectAllSupplier());
				model.addAttribute("edit", false);
			}
		}

		return "index";
	}

	@RequestMapping("/updateSupplier")
	String updateproduct(@Valid @ModelAttribute("mysupplier") Supplier s, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult.toString());
			model.addAttribute("supplier", true);
			model.addAttribute("mysupplier", s);
			model.addAttribute("error1", true);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail", false);
			model.addAttribute("suplist", supplierDAO.selectAllSupplier());
			model.addAttribute("edit", true);
		} 
		else 
		{
			try 
			{
				if (supplierDAO.updateSupplier(s)) 
				{
//					addimage(s.getProduct_Image(), s.getSupplier_Id());
					model.addAttribute("supplier", true);
					model.addAttribute("mysupplier", new Supplier());
					model.addAttribute("error1", false);
					model.addAttribute("success", true);
					model.addAttribute("error2", false);
					model.addAttribute("fail", false);
					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
					model.addAttribute("edit", false);
				} else {
					model.addAttribute("supplier", true);
					model.addAttribute("mysupplier", s);
					model.addAttribute("error1", false);
					model.addAttribute("success", false);
					model.addAttribute("error2", false);
					model.addAttribute("fail", true);
					model.addAttribute("suplist", supplierDAO.selectAllSupplier());
					model.addAttribute("edit", true);
				}
			} catch (Exception e) {
				model.addAttribute("supplier", true);
				model.addAttribute("mysupplier", s);
				model.addAttribute("error1", false);
				model.addAttribute("error2", true);
				model.addAttribute("success", false);
				model.addAttribute("fail", false);
				model.addAttribute("suplist", supplierDAO.selectAllSupplier());
				model.addAttribute("edit", true);
			}
		}

		return "index";
	}

	@RequestMapping("/deleteSupplier")
	String deleteproduct(@RequestParam("supid") int supplier_Id, Model model) {
		try {
			if (supplierDAO.deleteSupplier(supplierDAO.selectOneSupplier(supplier_Id)))
				return "redirect:/supplier";
			else {
				model.addAttribute("supplier", true);
				model.addAttribute("mysupplier", new Supplier());
				model.addAttribute("error1", false);
				model.addAttribute("success", false);
				model.addAttribute("error2", false);
				model.addAttribute("fail", true);
				model.addAttribute("suplist", supplierDAO.selectAllSupplier());
				model.addAttribute("edit", false);
				return "index";
			}

		} catch (Exception e) {
			model.addAttribute("supplier", true);
			model.addAttribute("mysupplier", new Supplier());
			model.addAttribute("error1", false);
			model.addAttribute("success", false);
			model.addAttribute("error2", false);
			model.addAttribute("fail", true);
			model.addAttribute("suplist", supplierDAO.selectAllSupplier());
			model.addAttribute("edit", false);
			return "index";
		}
	}

	@RequestMapping("/editSupplier")
	String editproduct(@RequestParam("supid") int supplier_Id, Model model) {
		model.addAttribute("supplier", true);
		model.addAttribute("mysupplier", supplierDAO.selectOneSupplier(supplier_Id));
		model.addAttribute("suplist", supplierDAO.selectAllSupplier());
		model.addAttribute("error1", false);
		model.addAttribute("success", false);
		model.addAttribute("error2", false);
		model.addAttribute("fail", false);
		model.addAttribute("edit", true);
		return "index";
	}
}
