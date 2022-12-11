package com.prpymes.microservicios.app.almacenes.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_image_detail")
public class ProductImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProductImage;
	private String pathImage;
	
	
	public Long getIdProductImage() {
		return idProductImage;
	}
	public void setIdProductImage(Long idProductImage) {
		this.idProductImage = idProductImage;
	}
	public String getPathImage() {
		return pathImage;
	}
	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof ProductImage)) {
			return false;
		}
		ProductImage p = (ProductImage)obj;
		return this.idProductImage != null && this.idProductImage.equals(p.getIdProductImage());
	}
	
}
