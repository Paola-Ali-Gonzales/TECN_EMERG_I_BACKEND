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

import com.prpymes.microservicios.app.almacenes.commons.controllers.CommonController;
import com.prpymes.microservicios.app.almacenes.models.entity.Product;
import com.prpymes.microservicios.app.almacenes.models.entity.Rack;
import com.prpymes.microservicios.app.almacenes.services.IRackService;

@RestController
public class RackController extends CommonController<Rack, IRackService> {
	@PutMapping("/rack/{id}")
	public ResponseEntity<?> edit(@RequestBody Rack rack, @PathVariable Long id){
		Optional<Rack> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rack dbRack = o.get();
		dbRack.setDescription(rack.getDescription());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbRack));
	}
	
	@PutMapping("/rack/{id}/asignar-productos")
	public ResponseEntity<?> addProducts(@RequestBody List<Product> products, @PathVariable Long id){
		Optional<Rack> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rack dbRack = o.get();
		
		products.forEach(a -> {
			dbRack.addProducts(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbRack));
	}
	
	@PutMapping("/rack/{id}/eliminar-producto")
	public ResponseEntity<?> deleteProduct(@RequestBody Product product, @PathVariable Long id){
		Optional<Rack> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Rack dbRack = o.get();
		
		dbRack.removeProducts(product);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbRack));
	}
	
	@GetMapping("/rack/producto/{id}")
	public ResponseEntity<?> findByProductId(@PathVariable Long id){
		Rack rack = service.findRackByProductId(id);
		return ResponseEntity.ok(rack);
	}
	
	@GetMapping("/rack/filtrar/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(service.findRacksByDescription(term));
	}
	
	@Override
	@GetMapping("/rack")
	public ResponseEntity<?> listar(){
		return super.listar();
	}
	
	@Override
	@GetMapping("/rack/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		return super.ver(id);
	}
	@Override
	@PostMapping("/rack")
	public ResponseEntity<?> crear(@RequestBody Rack e )
	{
		return super.crear(e);
	}
	
	@Override
	@DeleteMapping("/rack/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		return super.eliminar(id);
	}
}
