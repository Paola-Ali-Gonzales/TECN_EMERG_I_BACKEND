package com.prpymes.microservicios.app.almacenes.services;

import org.springframework.stereotype.Service;

import com.prpymes.microservicios.app.almacenes.models.entity.ProductImage;
import com.prpymes.microservicios.app.almacenes.models.repository.IProductImageRepository;
import com.prpymes.microservicios.commons.services.CommonServiceImpl;

@Service
public class ProductImageServiceImpl extends  CommonServiceImpl<ProductImage, IProductImageRepository> implements IProductImageService{

}
