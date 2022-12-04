package com.prpymes.microservicios.app.almacenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.almacenes.models.entity.Product;

public interface IProductRepository extends CrudRepository<Product, Long> {
	@Query("select p from Product p where p.name like %?1% or p.description like %?1%")
	public List<Product> findByNameOrDescription(String term);
	
	@Query("select p from Product p where p.name like %?1%")
	public List<Product> findByName(String term);
	
	@Query("select p from Product p where p.barcode = ?1")
	public List<Product> findByBarcode(String term);
}
