package com.prpymes.microservicios.app.almacenes.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prpymes.microservicios.app.almacenes.models.entity.Section;

public interface ISectionRepository extends CrudRepository<Section, Long> {
	@Query("SELECT s FROM Section s JOIN FETCH s.racks r WHERE r.idRack=?1")
	public Section findSectionByRackID(Long id);
	
	@Query("select s from Section s where s.description like %?1%")
	public List<Section> findSectionByDescription(String term);
}
