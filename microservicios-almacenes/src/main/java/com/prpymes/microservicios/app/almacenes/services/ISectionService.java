package com.prpymes.microservicios.app.almacenes.services;

import java.util.List;

import com.prpymes.microservicios.app.almacenes.commons.services.CommonService;
import com.prpymes.microservicios.app.almacenes.models.entity.Section;

public interface ISectionService extends CommonService<Section> {
	public Section findSectionByRackID(Long id);
	public List<Section> findSectionByDescription(String term);
}
