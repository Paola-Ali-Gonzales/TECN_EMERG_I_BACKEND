package com.prpymes.microservicios.app.almacenes.controllers;

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

import com.prpymes.microservicios.app.almacenes.models.entity.ProductImage;
import com.prpymes.microservicios.app.almacenes.services.IProductImageService;
import com.prpymes.microservicios.commons.controllers.CommonController;

@RestController
public class ProductImageController extends CommonController<ProductImage, IProductImageService>  {
	@PutMapping("/product-image/{id}")
	public ResponseEntity<?> edit(@RequestBody ProductImage productImage, @PathVariable Long id){
		Optional<ProductImage> p = service.findById(id);
		if(p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		ProductImage productImageDb = p.get();
		productImageDb.setPathImage(productImage.getPathImage());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productImageDb));
	}
	
	@Override
	@GetMapping("/product-image")
	public ResponseEntity<?> listar(){
		return super.listar();
	}
	
	@Override
	@GetMapping("/product-image/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		return super.ver(id);
	}
	@Override
	@PostMapping("/product-image")
	public ResponseEntity<?> crear(@RequestBody ProductImage e )
	{
		return super.crear(e);
	}
	
	@Override
	@DeleteMapping("/product-image/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		return super.eliminar(id);
	}

}
