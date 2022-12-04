package com.prpymes.microservicios.app.almacenes.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.app.almacenes.models.entity.Warehouse;
import com.prpymes.microservicios.app.almacenes.services.IWarehouseService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class WarehouseController  extends CommonController<Warehouse, IWarehouseService>{
	/*@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest()  {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("balanceador", balanceadorTest);
		response.put("warehouse", service.findAll());
		return ResponseEntity.ok(response);
	}*/

	@PutMapping("/warehouse/{id}")
	public ResponseEntity<?> edit(@RequestBody Warehouse warehouse, @PathVariable Long id){
		Optional<Warehouse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Warehouse dbWarehouse = o.get();
		dbWarehouse.setName(warehouse.getName());
		dbWarehouse.setDescription(warehouse.getDescription());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbWarehouse));
	}
	
	@PutMapping("/warehouse/{id}/asignar-section")
	public ResponseEntity<?> addSections(@RequestBody List<Section> sections, @PathVariable Long id){
		Optional<Warehouse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Warehouse dbWarehouse = o.get();
		
		sections.forEach(a -> {
			dbWarehouse.addSection(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbWarehouse));
	}
	
	@PutMapping("/warehouse/{id}/eliminar-section")
	public ResponseEntity<?> deleteSection(@RequestBody Section section, @PathVariable Long id){
		Optional<Warehouse> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Warehouse dbWarehouse = o.get();
		
		dbWarehouse.removeSection(section);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbWarehouse));
	}
	
	@GetMapping("/warehouse/Section/{id}")
	public ResponseEntity<?> findBySectionId(@PathVariable Long id){
		Section section = service.findWarehouseBySectionID(id);
		return ResponseEntity.ok(section);
	}
	
	@Override
	@GetMapping("/warehouse")
	public ResponseEntity<?> listar(){
		return super.listar();
	}
	
	@Override
	@GetMapping("/warehouse/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		return super.ver(id);
	}
	@Override
	@PostMapping("/warehouse")
	public ResponseEntity<?> crear(@RequestBody Warehouse e )
	{
		return super.crear(e);
	}
	
	@Override
	@DeleteMapping("/warehouse/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		return super.eliminar(id);
	}
}
