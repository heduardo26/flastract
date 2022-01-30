package com.demo.apirest.flashtract.percistense.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;


/**
 * This class is a composite key of the table InvoiceDetail
 * @author Carlos
 *
 */
public class InvoiceDetailKey implements Serializable {
	
	  private static final long serialVersionUID = 1L;
	  

	  @Column(name = "invoice_id")
	  private Integer invoiceId;

	  @Column(name = "material_id")
	  private Integer materialId;

	  public InvoiceDetailKey() {}

	  public InvoiceDetailKey(Integer invoiceId, int materialId) {
	    this.invoiceId  = invoiceId;
	    this.materialId = materialId;
	  }
	  
	  @Override
	  public boolean equals(Object o) {
	    if (this == o)
	      return true;
	    if (o == null || getClass() != o.getClass())
	      return false;
	    InvoiceDetailKey ctlKey = (InvoiceDetailKey) o;
	    if (invoiceId != ctlKey.materialId)
	      return false;
	    return materialId == ctlKey.invoiceId;
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(invoiceId, materialId);
	  }
}
