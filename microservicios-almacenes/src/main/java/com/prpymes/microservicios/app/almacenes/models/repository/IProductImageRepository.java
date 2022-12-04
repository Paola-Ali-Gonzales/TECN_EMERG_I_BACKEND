package com.prpymes.microservicios.app.almacenes.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.almacenes.models.entity.ProductImage;

public interface IProductImageRepository extends CrudRepository<ProductImage, Long> {
	
}
