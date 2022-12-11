package com.prpymes.microservicios.app.almacenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.almacenes.models.entity.Rack;

public interface IRackRepository extends CrudRepository<Rack, Long> {
	@Query("SELECT r FROM Rack r JOIN FETCH r.products p WHERE p.productID=?1")
	public Rack findRackByProductId(Long id);
	
	@Query("select r from Rack r where r.description like %?1%")
	public List<Rack> findRacksByDescription(String term);
}
