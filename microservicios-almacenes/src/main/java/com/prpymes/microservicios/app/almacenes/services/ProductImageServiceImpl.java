package com.prpymes.microservicios.app.almacenes.services;

import org.springframework.stereotype.Service;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonServiceImpl;
import com.prpymes.microservicios.app.almacenes.models.entity.ProductImage;
import com.prpymes.microservicios.app.almacenes.models.repository.IProductImageRepository;

@Service
public class ProductImageServiceImpl extends  CommonServiceImpl<ProductImage, IProductImageRepository> implements IProductImageService{

}
