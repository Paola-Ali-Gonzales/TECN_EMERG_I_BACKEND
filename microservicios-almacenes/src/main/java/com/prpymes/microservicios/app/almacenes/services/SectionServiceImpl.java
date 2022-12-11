package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonServiceImpl;
import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.app.almacenes.models.repository.ISectionRepository;

@Service
public class SectionServiceImpl extends CommonServiceImpl<Section, ISectionRepository>  implements ISectionService {
	@Override
	@Transactional(readOnly=true)
	public Section findSectionByRackID(Long id) {
		// TODO Auto-generated method stub
		return repository.findSectionByRackID(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Section> findSectionByDescription(String term) {
		return repository.findSectionByDescription(term);
	}
}
