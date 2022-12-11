package com.prpymes.microservicios.app.almacenes.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonServiceImpl;
import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.app.almacenes.models.entity.Warehouse;
import com.prpymes.microservicios.app.almacenes.models.repository.IWarehouseRepository;

@Service
public class WarehouseServiceImpl extends CommonServiceImpl<Warehouse, IWarehouseRepository> implements IWarehouseService {
	@Override
	@Transactional(readOnly=true)
	public Section findWarehouseBySectionID(Long id) {
		// TODO Auto-generated method stub
		return repository.findWarehouseBySectionID(id);
	}
}
