package com.demo.apirest.flashtract.percistense.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entitie for Contract 
 * @author Carlos
 *
 */
@Data
@Entity(name = "contract")
@NoArgsConstructor
public class Contract {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	
	private Double amount;
	
	private Double balance;
	
	@Column(name="create_at")
	private Date createAt;
	
	@Column(name="modified_at")
	private Date modifiedAt;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	@JsonBackReference
	private Client cliente;
	
	@ManyToOne
	@JoinColumn(name="vendor_id")
	@JsonBackReference
	private Vendor vendor;
	
	@ManyToOne
	@JoinColumn(name="status_id")
	@JsonBackReference
	private Status status;
	
	@OneToMany(mappedBy = "contract")
	private List<Invoice> invoices;
	
	@OneToMany(mappedBy = "contract")
	//@JsonManagedReference
	private List<MaterialContract> materialContracts;
	
	
}
