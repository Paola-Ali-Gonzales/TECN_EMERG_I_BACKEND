package com.prpymes.microservicios.app.almacenes.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.almacenes.models.entity.Rack;
import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.app.almacenes.services.ISectionService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class SectionController extends CommonController<Section, ISectionService>  {
	@PutMapping("/section/{id}")
	public ResponseEntity<?> edit(@RequestBody Section section, @PathVariable Long id){
		Optional<Section> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Section dbSection = o.get();
		dbSection.setDescription(section.getDescription());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSection));
	}
	
	@PutMapping("/section/{id}/asignar-rack")
	public ResponseEntity<?> addRacks(@RequestBody List<Rack> racks, @PathVariable Long id){
		Optional<Section> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Section dbSection = o.get();
		
		racks.forEach(a -> {
			dbSection.addRacks(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSection));
	}
	
	@PutMapping("/section/{id}/eliminar-rack")
	public ResponseEntity<?> deleteRack(@RequestBody Rack rack, @PathVariable Long id){
		Optional<Section> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Section dbSection = o.get();
		
		dbSection.removeRack(rack);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbSection));
	}
	
	@GetMapping("/section/rack/{id}")
	public ResponseEntity<?> findByRackId(@PathVariable Long id){
		Section section = service.findSectionByRackID(id);
		return ResponseEntity.ok(section);
	}
	
	@GetMapping("/section/filtrar/{term}")
	public ResponseEntity<?> filtrar(@PathVariable String term){
		return ResponseEntity.ok(service.findSectionByDescription(term));
	}
	
	@Override
	@GetMapping("/section")
	public ResponseEntity<?> listar(){
		return super.listar();
	}
	
	@Override
	@GetMapping("/section/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		return super.ver(id);
	}
	@Override
	@PostMapping("/section")
	public ResponseEntity<?> crear(@RequestBody Section e )
	{
		return super.crear(e);
	}
	
	@Override
	@DeleteMapping("/section/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		return super.eliminar(id);
	}
}
