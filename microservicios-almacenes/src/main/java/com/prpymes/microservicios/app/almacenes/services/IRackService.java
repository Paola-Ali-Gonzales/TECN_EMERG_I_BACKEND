package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import com.prpymes.microservicios.app.almacenes.models.entity.Rack;
import com.prpymes.microservicios.commons.services.CommonService;

public interface IRackService extends CommonService<Rack> {
	public Rack findRackByProductId(Long id);
	public List<Rack> findRacksByDescription(String term);
}
