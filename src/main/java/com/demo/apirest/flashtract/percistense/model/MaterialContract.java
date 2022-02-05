package com.demo.apirest.flashtract.percistense.model;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entitie for MaterialContract 
 * @author Carlos
 *
 */
@Data
@Entity(name = "material_contract")
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MaterialContract {
	
	/**
	 * Composite key
	 */
	@EmbeddedId
	MaterialContractKey id;
	
	@ManyToOne
	@MapsId("material_id")
	@JoinColumn(name="material_id", nullable = false, insertable = false, updatable = false)
	private Material material;
	
	@ManyToOne
	@MapsId("contract_id")
	@JoinColumn(name="contract_id", nullable = false, insertable = false, updatable = false)
	private Contract contract;

	public MaterialContract(Material material, Contract contract) {
		super();
		this.id = new MaterialContractKey(material.getId(), contract.getId());
		this.material = material;
		this.contract = contract;
	}
	
	
	
}


