package com.webservices.market.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.webservices.market.domain.Product;
import com.webservices.market.domain.repository.ProductRepository;
import com.webservices.market.persistence.crud.ProductoCrudRepository;
import com.webservices.market.persistence.entity.Producto;
import com.webservices.market.persistence.mapper.ProductMapper;

@Repository
public class ProductoRepository implements ProductRepository{
	
	private ProductoCrudRepository productoCrudRepository;
	private ProductMapper mapper;
	
	@Override
	public List<Product> getAll(){
		List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
		return mapper.toProducts(productos);
	}
	
	@Override
	public void delete(int productId) {
		productoCrudRepository.deleteById(productId);
	}

	@Override
	public Optional<List<Product>> getByCategory(int categoryId) {
		List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
		return Optional.of(mapper.toProducts(productos));
	}

	@Override
	public Optional<List<Product>> getScaresProducts(int quantity) {
		Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
		return productos.map(prods -> mapper.toProducts(prods));
	}

	@Override
	public Optional<Product> getProduct(int productId) {
		return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
	}

	@Override
	public Product save(Product product) {
		Producto producto = mapper.toProducto(product);
		return mapper.toProduct(productoCrudRepository.save(producto));
	}

}
