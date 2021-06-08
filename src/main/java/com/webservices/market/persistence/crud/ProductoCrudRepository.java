package com.webservices.market.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import com.webservices.market.persistence.entity.Producto;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{

}
