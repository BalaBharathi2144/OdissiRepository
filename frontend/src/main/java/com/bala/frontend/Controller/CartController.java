package com.bala.frontend.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bala.backend.DAO.CartDAO;
import com.bala.backend.DAO.ProductDAO;
import com.bala.backend.DAO.UserDAO;
import com.bala.backend.model.Cart;
import com.bala.backend.model.Product;

@Controller
public class CartController {
	@Autowired
	CartDAO cartDAO;

	@Autowired
	ProductDAO productDAO;

	@Autowired
	UserDAO userDAO;

	@RequestMapping("/user/viewcart")
	String viewCart(Model model, HttpSession session) {
		float tot = 0;
		List<Cart> cartitems = cartDAO.selectAllCart(Integer.parseInt(session.getAttribute("usercartid").toString()));
		Iterator<Cart> iterator = cartitems.listIterator();
		while (iterator.hasNext()) {
			Cart cart = (Cart) iterator.next();
			tot = tot + cart.getSubTotal();
		}
		model.addAttribute("cartpage", true);
		model.addAttribute("cartitems", cartitems);
		session.setAttribute("itemcount", cartitems.size());
		session.setAttribute("shipping", Integer.parseInt(session.getAttribute("itemcount").toString()) * 50);
		session.setAttribute("tot", tot + Integer.parseInt(session.getAttribute("itemcount").toString()) * 50);
		return "index";
	}

	@RequestMapping("/addToCart")
	String addToCart(HttpSession httpSession, @RequestParam("pid") int pid) {
		if (httpSession.getAttribute("usercartid") == null) {
			httpSession.setAttribute("pid", pid);
			return "redirect:/login";
		} else {
			ArrayList<Cart> cartlist = (ArrayList<Cart>) cartDAO
					.selectAllCart(Integer.parseInt(httpSession.getAttribute("usercartid").toString()));
			if (cartlist.isEmpty()) {
				Cart c = new Cart();
				Product p = productDAO.selectOneProduct(pid);
				c.setUserdetails(userDAO.selectOneUser(httpSession.getAttribute("useremail").toString()));
				c.setProduct(p);
				c.setQuantity(1);
				c.setSubTotal(p.getPrice());
				cartDAO.createCart(c);
			} else {
				Iterator<Cart> iterator = cartlist.listIterator();
				while (iterator.hasNext()) {
					Cart cart = (Cart) iterator.next();
					Product p = cart.getProduct();
					if (p.getProduct_Id() == pid) {
						int qty = cart.getQuantity();
						qty = qty + 1;
						cart.setQuantity(qty);
						cart.setSubTotal(qty * p.getPrice());
						cartDAO.updateCart(cart);
						return "redirect:/user/viewcart";
					}
				}
				Cart c1 = new Cart();
				Product p = productDAO.selectOneProduct(pid);
				c1.setUserdetails(userDAO.selectOneUser(httpSession.getAttribute("useremail").toString()));
				c1.setProduct(p);
				c1.setQuantity(1);
				c1.setSubTotal(p.getPrice());
				cartDAO.createCart(c1);
			}
			return "redirect:/user/viewcart";
		}
	}

	@RequestMapping("/user/deleteitem")
	String deleteItem(@RequestParam("catid") int cid) {
		cartDAO.deleteCart(cartDAO.selectOneCart(cid));
		return "redirect:/user/viewcart";
	}
}
