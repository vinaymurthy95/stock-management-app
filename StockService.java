package com.agiliz.stock.service;

import java.util.List;

import com.agiliz.stock.model.AdminDTO;
import com.agiliz.stock.model.ProductDTO;
import com.agiliz.stock.model.UserDTO;

public interface StockService {

	void adminRegistration(AdminDTO adto);

	void userRegistration(UserDTO udto);

	AdminDTO loginAdmin(String userName, String password);

	UserDTO loginUser(String userName, String password);

	List<ProductDTO> getAll();

	void deleterecord(int id);

	void insertProduct(ProductDTO pdto);

	int updateQuantity(String name, int quantity);

	int updatePrice(String name, double price);

	List<ProductDTO> search(String type, String key);

}
