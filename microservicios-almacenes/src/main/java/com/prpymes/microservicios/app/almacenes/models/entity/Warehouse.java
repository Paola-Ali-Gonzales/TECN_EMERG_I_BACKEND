package com.prpymes.microservicios.app.almacenes.models.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idWarehouse;
	
	@NotEmpty
	@Size(min=6)
	private String name;
	
	@NotEmpty
	@Size(min=6)
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY)
	private List<Section> sections;

	public Long getIdWarehouse() {
		return idWarehouse;
	}

	public void setIdWarehouse(Long idWarehouse) {
		this.idWarehouse = idWarehouse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public void addSection(Section section) {
		this.sections.add(section);
	}
	public void removeSection(Section section) {
		this.sections.remove(section);
	}
}
