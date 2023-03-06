package com.lti.cld.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.cld.entity.Factory;
import com.lti.cld.entity.Product;

@Repository
public class InventoryDaoImpl implements InventoryDao {

	@PersistenceContext
	EntityManager em;
	
	@Transactional
	public Factory addOrUpdateFactory(Factory factory) {
		return em.merge(factory);
		
	}

	@Override
	@Transactional
	public boolean deleteFactory(int factoryId) {
		em.remove(em.find(Factory.class, factoryId));
		return true;
	}

	@Override
	public List<Factory> viewAllFactories() {
		
		String jpql="select f from Factory f";
		TypedQuery<Factory> query=em.createQuery(jpql,Factory.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Product addOrUpdateProduct(Product product) {
		
		return em.merge(product);
	}

	@Override
	@Transactional
	public boolean deleteProduct(int productId) {
		em.remove(em.find(Product.class,productId));
		return true;
	}

	@Override
	public List<Product> viewAllProducts() {
		String jpql="select p from Product p";
		TypedQuery<Product> query=em.createQuery(jpql,Product.class);
		return query.getResultList();
	}

	@Override
	public List<Product> viewAllProductsbyFactory(int factoryId) {
		String jpql="select p from Product p where factory_id=:id";
		TypedQuery<Product> query=em.createQuery(jpql,Product.class);
		query.setParameter("id", factoryId);
		return query.getResultList();
	}

	@Override
	public Factory getFactoryById(int factoryId) {
		return em.find(Factory.class,factoryId);
	}

	@Override
	public Product getProductById(int productId) {
		
		return em.find(Product.class, productId);
	}

}
