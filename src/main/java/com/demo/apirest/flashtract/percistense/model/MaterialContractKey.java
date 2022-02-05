package com.demo.apirest.flashtract.percistense.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * This class is a composite key of the table MaterialContract
 * @author Carlos
 *
 */
@Embeddable
public class MaterialContractKey implements Serializable {

	private static final long serialVersionUID = 1L;
	  
	  
	  @Column(name = "material_id")
	  private Integer materialId;
	  
	  

	  @Column(name = "contract_id")
	  private Integer contractId;

	  public MaterialContractKey() {}

	  public MaterialContractKey(Integer materialId, int contractId) {
	    this.materialId  = materialId;
	    this.contractId = contractId;
	  }
	  
	  
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    MaterialContractKey ctlKey = (MaterialContractKey) o;
	    if (materialId != ctlKey.contractId)
	      return false;
	    return materialId == ctlKey.contractId;
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(materialId, contractId);
	  }
	  
	  public Integer getMaterialId() {
		return materialId;
	  }

	  public void setMaterialId(Integer materialId) {
		 this.materialId = materialId;
	  }

	  public Integer getContractId() {
		return contractId;
	  }

	  public void setContractId(Integer contractId) {
		this.contractId = contractId;
	  }

	  public static long getSerialversionuid() {
		return serialVersionUID;
	  }
}
