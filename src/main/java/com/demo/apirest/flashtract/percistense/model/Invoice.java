package com.demo.apirest.flashtract.percistense.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entitie for Invoices 
 * @author Carlos
 *
 */
@Data
@Entity(name = "invoice")
@NoArgsConstructor
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String number;
	
	@Column(name="invoice_date")
	private Date invoiceDate; 
	
	private Double amount; 
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="update_at")
	private Date updateAt;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	
	@ManyToOne
	@JoinColumn(name="contract_id")
	private Contract contract;
	
	@ManyToOne
	@JoinColumn(name="vendor_id")
	private Contract vendor;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "invoice", cascade=CascadeType.ALL)
	private List<InvoiceDetail> invoiceDetails;
	  
}
