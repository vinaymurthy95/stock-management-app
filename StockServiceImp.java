package com.agiliz.stock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agiliz.stock.dao.StockDAO;
import com.agiliz.stock.model.AdminDTO;
import com.agiliz.stock.model.ProductDTO;
import com.agiliz.stock.model.UserDTO;

@Component
public class StockServiceImp implements StockService {

	@Autowired
	private StockDAO dao;

	@Override
	public void adminRegistration(AdminDTO adto) {
		dao.adminRegistration(adto);
	}

	@Override
	public void userRegistration(UserDTO udto) {
		dao.userRegistration(udto);
	}

	@Override
	public AdminDTO loginAdmin(String userName, String password) {
		return dao.loginAdmin(userName, password);
	}

	@Override
	public UserDTO loginUser(String userName, String password) {
		return dao.loginUser(userName, password);
	}

	@Override
	public List<ProductDTO> getAll() {
		return dao.getAll();
	}

	@Override
	public void deleterecord(int id) {
		dao.deleterecord(id);

	}

	@Override
	public void insertProduct(ProductDTO pdto) {
		dao.insertProduct(pdto);

	}

	@Override
	public int updateQuantity(String name, int quantity) {
		return dao.updateQuantity(name, quantity);
	}

	@Override
	public int updatePrice(String name, double price) {
		return dao.updatePrice(name, price);
	}

	@Override
	public List<ProductDTO> search(String type, String key) {
		// TODO Auto-generated method stub
		return dao.search(type, key);
	}

}
