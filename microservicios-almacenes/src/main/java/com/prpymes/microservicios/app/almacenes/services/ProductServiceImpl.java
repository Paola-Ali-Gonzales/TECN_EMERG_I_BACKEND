package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonServiceImpl;
import com.prpymes.microservicios.app.almacenes.models.entity.Product;
import com.prpymes.microservicios.app.almacenes.models.repository.IProductRepository;

@Service
public class ProductServiceImpl extends CommonServiceImpl<Product, IProductRepository> implements IProductService  {
	@Override
	@Transactional(readOnly = true)
	public List<Product> findByNameOrDescription(String term) {
		return repository.findByNameOrDescription(term);
	}

	@Override
	public List<Product> findByName(String term) {
		return repository.findByName(term);
	}

	@Override
	public List<Product> findByBarcode(String term) {
		return repository.findByBarcode(term);
	}
}
