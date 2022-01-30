package com.demo.apirest.flashtract.percistense.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;


import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entitie for Invoices 
 * @author Carlos
 *
 */
@Data
@Entity(name = "invoice_detail")
@NoArgsConstructor
public class InvoiceDetail{
	
	/**
	 * Composite key
	 */
	@EmbeddedId
	InvoiceDetailKey id;
	

	@ManyToOne
	@JoinColumn(name="invoice_id")
	@MapsId("invoice_id") 		
	private Invoice invoice;
	
	@ManyToOne
	@JoinColumn(name="material_id")
	@MapsId("material_id") 		
	private Materials material;
	
	
	private String description;
	
	private Double amount;
	
	

}
