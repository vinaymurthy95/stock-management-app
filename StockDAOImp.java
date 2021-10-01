package com.agiliz.stock.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agiliz.stock.model.AdminDTO;
import com.agiliz.stock.model.ProductDTO;
import com.agiliz.stock.model.UserDTO;

@Component
public class StockDAOImp implements StockDAO {

	@Autowired
	EntityManagerFactory factory;

	@Override
	public void adminRegistration(AdminDTO adto) {
		System.out.println("Admin Data received  by dao and persists it to the database");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(adto);
		transaction.commit();
		manager.close();
	}

	@Override
	public void userRegistration(UserDTO udto) {
		System.out.println("User Data received  by dao and persists it to the database");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(udto);
		transaction.commit();
		manager.close();
	}

	@Override
	public AdminDTO loginAdmin(String userName, String password) {
		System.out.println("dao perform login validation  with database");
		try {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery("from AdminDTO where userName=?0 and password=?1");
			query.setParameter(0, userName);
			query.setParameter(1, password);
			return (AdminDTO) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public UserDTO loginUser(String userName, String password) {
		System.out.println("dao perform login validation  with database");
		try {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery("from UserDTO where userName=?0 and password=?1");
			query.setParameter(0, userName);
			query.setParameter(1, password);
			return (UserDTO) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public List<ProductDTO> getAll() {
		System.out.println("inside getall");
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery("from ProductDTO");
		System.out.println(query.getResultList());
		return query.getResultList();
	}

	@Override
	public void deleterecord(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserDTO dto = manager.find(UserDTO.class, id);
		manager.remove(dto);
		transaction.commit();
		manager.close();

	}

	@Override
	public void insertProduct(ProductDTO pdto) {
		System.out.println("Product Data received  by dao and persists it to the database");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(pdto);
		transaction.commit();
		manager.close();

	}

	@Override
	public int updateQuantity(String name, int quantity) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager
					.createQuery("update ProductDTO set quantity='" + quantity + "' where name='" + name + "'");
			int row = query.executeUpdate();
			transaction.commit();
			return row;
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	public int updatePrice(String name, double price) {
		try {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createQuery("update ProductDTO set price='" + price + "' where name='" + name + "'");
			int row = query.executeUpdate();
			transaction.commit();
			return row;
		} catch (NoResultException e) {
			return 0;
		}
	}

	@Override
	public List<ProductDTO> search(String type, String key) {

		List<ProductDTO> lispdto = null;
		Query query = null;
		EntityManager manager = factory.createEntityManager();
		if (type.equals("Select_By_Name")) {
			query = manager.createQuery("from ProductDTO where name='" + key + "'");
			lispdto = query.getResultList();
		} else if (type.equals("Select_By_Category")) {
			query = manager.createQuery("from ProductDTO where category='" + key + "'");
			lispdto = query.getResultList();

		} else if (type.equals("Select_By_Company")) {
			query = manager.createQuery("from ProductDTO where company='" + key + "'");
			lispdto = query.getResultList();
		}
		manager.close();
		return lispdto;
	}

}
