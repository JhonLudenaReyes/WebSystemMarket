package com.webservices.market.persistence;

import java.util.List;

import com.webservices.market.persistence.crud.ProductoCrudRepository;
import com.webservices.market.persistence.entity.Producto;

public class ProductoRepository {
	
	private ProductoCrudRepository productoCrudRepository;
	
	public List<Producto> getAll(){
		return (List<Producto>) productoCrudRepository.findAll();
	}
	
	public List<Producto> getByCategoria(int idCategoria){
		return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
	}

}
