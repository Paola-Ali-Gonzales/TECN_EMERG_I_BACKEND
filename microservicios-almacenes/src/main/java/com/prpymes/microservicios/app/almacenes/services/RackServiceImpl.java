package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonServiceImpl;
import com.prpymes.microservicios.app.almacenes.models.entity.Rack;
import com.prpymes.microservicios.app.almacenes.models.repository.IRackRepository;

@Service
public class RackServiceImpl extends CommonServiceImpl<Rack, IRackRepository> implements IRackService  {
	@Override
	@Transactional(readOnly=true)
	public Rack findRackByProductId(Long id) {
		return repository.findRackByProductId(id);
	}

	@Override
	public List<Rack> findRacksByDescription(String term) {
		return repository.findRacksByDescription(term);
	}
}
