package com.prpymes.microservicios.app.almacenes.services;


import com.prpymes.microservicios.app.almacenes.commons.services.CommonService;
import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.app.almacenes.models.entity.Warehouse;

public interface IWarehouseService extends CommonService<Warehouse> {
	public Section findWarehouseBySectionID(Long id);
	
}
