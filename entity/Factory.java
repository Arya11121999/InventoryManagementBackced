package com.lti.cld.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="factory_tbl")
public class Factory {
	@Id
	@GeneratedValue
	@Column(name = "factory_id")
	private int factoryId;
	
	private String factoryName;
	private String factoryLocation;
	
	@OneToMany(mappedBy = "factory" , cascade = CascadeType.ALL)
	List<Product> products;
	
	public int getFactoryId() {
		return factoryId;
	}
	public void setFactoryId(int factoryId) {
		this.factoryId = factoryId;
	}
	public String getFactoryName() {
		return factoryName;
	}
	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}
	public String getFactoryLocation() {
		return factoryLocation;
	}
	public void setFactoryLocation(String factoryLocation) {
		this.factoryLocation = factoryLocation;
	}
	@JsonIgnore
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
	

}
