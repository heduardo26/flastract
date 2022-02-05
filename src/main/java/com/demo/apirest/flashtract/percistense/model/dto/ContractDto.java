package com.demo.apirest.flashtract.percistense.model.dto;

import lombok.Data;

@Data
public class ContractDto {
	
	private String description;
	
	private Double amount;
	
	private Double balance;
	
	private Integer clienteId;
	
	private Integer vendorId;
	
}
