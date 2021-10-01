package com.agiliz.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.agiliz.stock.model.AdminDTO;
import com.agiliz.stock.model.ProductDTO;
import com.agiliz.stock.model.UserDTO;
import com.agiliz.stock.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockservice;

	@RequestMapping("/link1")
	public String getView1() {
		return "admin";
	}

	@RequestMapping("/link2")
	public String getView2() {
		return "user";
	}

	@RequestMapping("/registeradmin")
	public String registeradmin() {
		return "registeradmin";
	}

	@RequestMapping("/loginadmin")
	public String loginadmin() {
		return "loginadmin";
	}

	@RequestMapping("/registeruser")
	public String registeruser() {
		return "registeruser";
	}

	@RequestMapping("/loginuser")
	public String loginuser() {
		return "loginuser";
	}

	@PostMapping("/registeradmindata")
	public String adminRegistration(@ModelAttribute AdminDTO adto) {
		System.out.println("Admin Data received by controller and passed it to DAO and response for incoming request ");
		// System.out.println(dto.getName()+" "+dto.getUserName()+"
		// "+dto.getPassword()+" "+dto.getAge()+" "+dto.getAddress()+"
		// "+dto.getPhone());
		stockservice.adminRegistration(adto);
		return "success";
	}

	@PostMapping("/registeruserdata")
	public String userRegistration(@ModelAttribute UserDTO udto) {
		System.out.println("Admin Data received by controller and passed it to DAO and response for incoming request ");
		// System.out.println(dto.getName()+" "+dto.getUserName()+"
		// "+dto.getPassword()+" "+dto.getAge()+" "+dto.getAddress()+"
		// "+dto.getPhone());
		stockservice.userRegistration(udto);
		return "success";
	}

	@PostMapping("/adminlogin")
	public ModelAndView loginAdmin(@RequestParam String userName, @RequestParam String password) {
		System.out.println("Data received by controller and passed it to the service ");
		AdminDTO adto = stockservice.loginAdmin(userName, password);
		if (adto != null) {
			return new ModelAndView("successadmin", "dto", adto);
		} else {
			return new ModelAndView("loginadmin", "msg", "login failed pls try again");
		}
	}

	@PostMapping("/userlogin")
	public ModelAndView loginUser(@RequestParam String userName, @RequestParam String password) {
		System.out.println("Data received by controller and passed it to the service ");
		UserDTO udto = stockservice.loginUser(userName, password);
		if (udto != null) {
			return new ModelAndView("successuser", "dto", udto);
		} else {
			return new ModelAndView("loginuser", "msg", "login failed pls try again");
		}
	}

	@GetMapping("/view_all")
	private ModelAndView getAll() {
		List<ProductDTO> pDtos = stockservice.getAll();
		System.out.println("pdtos" + pDtos);
		return new ModelAndView("viewAll", "pDtos", pDtos);

	}

	@PostMapping("/updatequantity")
	public String updateQuantity(@RequestParam String name, @RequestParam int quantity) {
		int row = stockservice.updateQuantity(name, quantity);
		if (row == 1) {
			return "successupdate";
		} else {
			return "failupdate";

		}
	}

	@PostMapping("/updateprice")
	public String updatePrice(@RequestParam String name, @RequestParam double price) {
		System.err.println("inside price");
		int row = stockservice.updatePrice(name, price);
		if (row == 1) {
			return "successupdate";
		} else {
			return "failupdate";

		}
	}

	@RequestMapping("/insert")
	public String insert() {
		return "insert";
	}

	@PostMapping("/insertproduct")
	public String insertProduct(@ModelAttribute ProductDTO pdto) {
		System.out
				.println("Product Data received by controller and passed it to DAO and response for incoming request ");
		System.out.println(pdto.getName());
		stockservice.insertProduct(pdto);
		return "productsuccess";

	}

	@RequestMapping("/link3")
	public String Quantity() {
		return "quantity";
	}

	@RequestMapping("/link4")
	public String Price() {
		return "price";
	}

	@RequestMapping("/link5")
	public String search() {
		return "search";
	}

	@PostMapping("/searchproduct")
	public ModelAndView SearchProduct(@RequestParam String type, @RequestParam String key) {
		List<ProductDTO> lispdto = stockservice.search(type, key);
		if (lispdto != null && !lispdto.isEmpty()) {
			return new ModelAndView("searchpass", "lispdto", lispdto);
		} else {
			return new ModelAndView("searchfail");
		}

	}
}
