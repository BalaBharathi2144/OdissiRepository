package com.bala.frontend.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.backend.DAO.AddressDAO;
import com.bala.backend.DAO.CartDAO;
import com.bala.backend.DAO.MyorderDAO;
import com.bala.backend.DAO.ProductDAO;
import com.bala.backend.DAO.UserDAO;
import com.bala.backend.model.Cart;
import com.bala.backend.model.Myorder;
import com.bala.backend.model.Product;

@Controller
@RequestMapping("/user")
public class MyorderController {
	@Autowired
	CartDAO cartDAO;

	@Autowired
	AddressDAO addressDAO;

	@Autowired
	UserDAO userDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	MyorderDAO myorderDAO;

	@RequestMapping("/placeorder")
	String placeOrder(@RequestParam("addid") int addid, Model model, HttpSession httpSession) {
		Myorder oMyorder = new Myorder();
		ArrayList<Cart> carts = (ArrayList<Cart>) cartDAO
				.selectAllCart(Integer.parseInt(httpSession.getAttribute("usercartid").toString()));
		Iterator<Cart> iterator = carts.iterator();
		while (iterator.hasNext()) {
			Date d = new Date();
			long id = UUID.randomUUID().getMostSignificantBits();
			String oid = "OD-".concat(String.valueOf(id).replace("-", "5"));
			Cart cart = (Cart) iterator.next();
			Product p = productDAO.selectOneProduct(cart.getProduct().getProduct_Id());
			if (p.getQuantity() >= cart.getQuantity()) {
				oMyorder.setAddress(addressDAO.selectOneAddress(addid));
				oMyorder.setMyorder_Id(oid);
				oMyorder.setOrder_Date(d);
				oMyorder.setQuantity(cart.getQuantity());
				oMyorder.setProduct(cart.getProduct());
				oMyorder.setGrandTotal(cart.getSubTotal());
				oMyorder.setUserdetails(userDAO.selectOneUser(httpSession.getAttribute("useremail").toString()));
				int qty = p.getQuantity() - cart.getQuantity();
				p.setQuantity(qty);
				if (myorderDAO.createOrder(oMyorder)) {
					productDAO.updateProduct(p);
					cartDAO.deleteCart(cart);
				}
			}
		}
		ArrayList<Cart> cartitems = (ArrayList<Cart>) cartDAO
				.selectAllCart(Integer.parseInt(httpSession.getAttribute("usercartid").toString()));
		httpSession.setAttribute("itemcount", cartitems.size());
		model.addAttribute("orderlist",
				myorderDAO.selectAllOrder(Integer.parseInt(httpSession.getAttribute("usercartid").toString())));
		model.addAttribute("orderpage", true);
		return "index";
	}

	@RequestMapping("/vieworders")
	String viewallorders(Model model, HttpSession httpSession) {
		model.addAttribute("orderlist",
				myorderDAO.selectAllOrder(Integer.parseInt(httpSession.getAttribute("usercartid").toString())));
		model.addAttribute("orderpage", true);
		return "index";

	}

	@RequestMapping("/receipt")
	String receipt(@RequestParam("rid") String oid, Model model, HttpSession httpSession)

	{
		model.addAttribute("order", myorderDAO.selectOneOrder(oid));
		model.addAttribute("receiptpage", true);
		return "index";
	}
	
	
}
