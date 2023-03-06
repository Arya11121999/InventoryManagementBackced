package com.lti.cld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lti.cld.dao.InventoryDao;
import com.lti.cld.entity.Factory;
import com.lti.cld.entity.Product;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryDao dao;
	
	public Factory addOrUpdateFactory(Factory factory) {
		return dao.addOrUpdateFactory(factory);
	}

	@Override
	public boolean removeFactory(int factoryId) {
		dao.deleteFactory(factoryId);
		return true;
	}

	@Override
	public List<Factory> viewAllFactories() {
		
		return dao.viewAllFactories();
	}

	@Override
	public Product addOrUpdateProduct(Product product,MultipartFile image) {
		return dao.addOrUpdateProduct(product);
	}

	@Override
	public boolean removeProduct(int productId) {
		return dao.deleteProduct(productId);
	}

	@Override
	public List<Product> viewAllProducts() {
		return dao.viewAllProducts();
	}
	

	@Override
	public List<Product> viewProductsByFactory(int factoryId) {
		return dao.viewAllProductsbyFactory(factoryId);
	}

	@Override
	public Factory getFactoryById(int factoryId) {
		
		return dao.getFactoryById(factoryId);
	}

	@Override
	public Product getProductById(int productId) {
		return dao.getProductById(productId);
	}


}
