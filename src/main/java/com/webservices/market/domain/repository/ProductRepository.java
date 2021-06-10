package com.webservices.market.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.market.domain.Product;

public interface ProductRepository {
	
	List<Product> getAll();
	Optional<List<Product>> getByCategory(int categoryId);
	Optional<List<Product>> getScaresProducts(int quantity);
	Optional<List<Product>> getProduct(int productId);
	Product save(Product product);
	void delete(int productId);

}