package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonService;
import com.prpymes.microservicios.app.almacenes.models.entity.Product;

public interface IProductService extends CommonService<Product> {
	
	public List<Product> findByNameOrDescription(String term);
	
	public List<Product> findByName(String term);
	
	public List<Product> findByBarcode(String term);
}
