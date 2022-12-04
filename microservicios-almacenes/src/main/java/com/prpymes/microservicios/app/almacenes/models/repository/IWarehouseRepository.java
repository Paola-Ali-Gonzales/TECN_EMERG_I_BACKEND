package com.prpymes.microservicios.app.almacenes.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.app.almacenes.models.entity.Warehouse;

public interface IWarehouseRepository extends CrudRepository<Warehouse, Long> {
	@Query("SELECT w FROM Warehouse w JOIN FETCH w.sections s WHERE s.idSection=?1")
	public Section findWarehouseBySectionID(Long id);
}
