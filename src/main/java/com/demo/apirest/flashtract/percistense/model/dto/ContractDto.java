package com.demo.apirest.flashtract.percistense.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ContractDto {
	
	private String description;
	
	private Double amount;
	
	private Double balance;
	
	private Date createAt;
	
	private Date modifiedAt;
	
	private Integer clienteId;
	
	private Integer vendorId;
	
}
