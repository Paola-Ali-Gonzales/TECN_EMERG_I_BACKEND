package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import com.prpymes.microservicios.app.almacenes.models.entity.Section;
import com.prpymes.microservicios.commons.services.CommonService;

public interface ISectionService extends CommonService<Section> {
	public Section findSectionByRackID(Long id);
	public List<Section> findSectionByDescription(String term);
}
