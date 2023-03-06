package com.lti.cld.dao;

import java.util.List;

import com.lti.cld.entity.Factory;
import com.lti.cld.entity.Product;

public interface InventoryDao {

	Factory addOrUpdateFactory(Factory factory);
	boolean deleteFactory(int factoryId);
	Factory getFactoryById(int factoryId);
	List<Factory> viewAllFactories();
	
	Product addOrUpdateProduct(Product product);
	boolean deleteProduct(int productId);
	Product getProductById(int productId);
	List<Product> viewAllProducts();
	List<Product> viewAllProductsbyFactory(int factoryId);
}
