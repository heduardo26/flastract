package com.demo.apirest.flashtract.percistense.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entitie for MaterialContract 
 * @author Carlos
 *
 */
@Data
@Entity(name = "material_contract")
@NoArgsConstructor
public class MaterialContract {
	
	/**
	 * Composite key
	 */
	@EmbeddedId
	MaterialContractKey id;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	@MapsId("material_id") 
	private Materials material;
	
	@ManyToOne
	@JoinColumn(name="contract_id")
	@MapsId("contract_id") 
	private Contract contract;
}
