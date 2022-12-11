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
import com.prpymes.microservicios.app.almacenes.commons.services.ServiceBarcode;
import com.prpymes.microservicios.app.almacenes.models.entity.Product;
import com.prpymes.microservicios.app.almacenes.models.entity.ProductImage;
import com.prpymes.microservicios.app.almacenes.services.IProductService;

@RestController
public class ProductController extends CommonController<Product, IProductService> {
	@Override
	@PostMapping("/product")
	public ResponseEntity<?> crear(@RequestBody Product entity) {
		ServiceBarcode sb = new ServiceBarcode();		
		entity.setBarcode(sb.GenerateBarcode());
		return super.crear(entity);
	}
	@PutMapping("/product/{id}")
	public ResponseEntity<?> edit(@RequestBody Product product, @PathVariable Long id){
		Optional<Product> p = service.findById(id);
		if(p.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Product productDb = p.get();
		productDb.setName(product.getName());
		productDb.setQuantity(product.getQuantity());
		productDb.setDescription(product.getDescription());
		productDb.setExpireDate(product.getExpireDate());
		productDb.setBrand(product.getBrand());
		productDb.setPrice(product.getPrice());
		productDb.setDiscount(product.getDiscount());
		productDb.setIva(product.getIva());
		productDb.setCategory(product.getCategory());
		productDb.setBatch(product.getBatch());
		productDb.setDutyManager(product.getDutyManager());
		productDb.setIdSupplier(product.getIdSupplier());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
	}
	
	@GetMapping("/product/filtrar/{term}")
	public ResponseEntity<?> filter(@PathVariable String term){
		return ResponseEntity.ok(service.findByNameOrDescription(term));
	}
	
	@GetMapping("/product/filtrarByname/{term}")
	public ResponseEntity<?> filterByName(@PathVariable String term){
		return ResponseEntity.ok(service.findByName(term));
	}
	
	@GetMapping("/product/filtrarByBarcode/{term}")
	public ResponseEntity<?> filterByBarcode(@PathVariable String term){
		return ResponseEntity.ok(service.findByBarcode(term));
	}
	
	@PutMapping("/product/{id}/asignar-imagenes-productos")
	public ResponseEntity<?> addProductImages(@RequestBody List<ProductImage> productImages, @PathVariable Long id){
		Optional<Product> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Product dbProduct = o.get();
		
		productImages.forEach(a -> {
			dbProduct.addProductImages(a);
		});
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbProduct));
	}
	
	@PutMapping("/product/{id}/eliminar-imagen-producto")
	public ResponseEntity<?> deleteImageProduct(@RequestBody ProductImage productImage, @PathVariable Long id){
		Optional<Product> o = this.service.findById(id);
		if(!o.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		Product dbProduct = o.get();
		
		dbProduct.removeProductImage(productImage);
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbProduct));
	}
	
	@Override
	@GetMapping("/product")
	public ResponseEntity<?> listar(){
		return super.listar();
	}

	@Override
	@GetMapping("/product/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id)
	{
		return super.ver(id);
	}
	
	@Override
	@DeleteMapping("/product/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id)
	{
		return super.eliminar(id);
	}
	
	
}
