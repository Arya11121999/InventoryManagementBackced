package com.lti.cld.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.criteria.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lti.cld.dto.ProductDTO;
import com.lti.cld.entity.Factory;
import com.lti.cld.entity.Product;
import com.lti.cld.service.InventoryService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/manage")
public class InventoryController {
	@Autowired
	InventoryService inventoryService;
	@GetMapping("/message")
     public String message() {
    	 return "congrats";
     }
	// Factories API
	@PostMapping("/add/factory")
	Factory addFactory(@RequestBody Factory factory) {
		return inventoryService.addOrUpdateFactory(factory);
	}

	@PutMapping("/update/factory")
	Factory updateFactory(@RequestBody Factory factory) {
		return inventoryService.addOrUpdateFactory(factory);
	}

	@DeleteMapping("/delete/factory/{factoryId}")
	ResponseEntity<Map<String,String>> deleteFactory(@PathVariable int factoryId) {
		boolean deleted = inventoryService.removeFactory(factoryId);
		
		if (deleted)
			return  ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Deleted Successfully " + factoryId));
		return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message","Not Deleted Successfully " + factoryId));
	}

	@GetMapping("/viewAll/factory")
	List<Factory> viewAllfactories() {
		return inventoryService.viewAllFactories();
	}

	// Products API

			
		
	@PostMapping(value="/add/product")
	Product addProduct(ProductDTO productdto) {
		Product product = new Product();
		product.setFactory(inventoryService.getFactoryById(productdto.getFactoryId()));
		product.setProductName(productdto.getProductName());
		product.setDescription(productdto.getDescription());
		product.setQuantity(productdto.getQuantity());
		return inventoryService.addOrUpdateProduct(product,productdto.getImage());
	}

	@PutMapping("/update/product")
	Product updateProduct(ProductDTO productdto) {
		Product product = new Product();
		product.setFactory(inventoryService.getFactoryById(productdto.getFactoryId()));
		product.setProductName(productdto.getProductName());
		product.setDescription(productdto.getDescription());
		product.setQuantity(productdto.getQuantity());
		product.setProductId(productdto.getProductId());
		return inventoryService.addOrUpdateProduct(product,productdto.getImage());
	}

	@DeleteMapping("/delete/product/{productId}")
	ResponseEntity<Map<String,String>> deleteProduct(@PathVariable int productId) {
		boolean deleted = inventoryService.removeProduct(productId);
		if (deleted)
			return  ResponseEntity.status(HttpStatus.OK).body(Map.of("message","Deleted Successfully " + productId));
		return ResponseEntity.status(HttpStatus.CONFLICT).body(Map.of("message","Not Deleted Successfully " + productId));
	}

	@GetMapping("/viewAll/products/{factoryId}")
	List<Product> viewALlProducts(@PathVariable int factoryId) {
		return inventoryService.viewProductsByFactory(factoryId);
	}
}
