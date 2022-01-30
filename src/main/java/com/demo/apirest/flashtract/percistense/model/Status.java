package com.demo.apirest.flashtract.percistense.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entitie for Status
 * @author Carlos
 *
 */
@Data
@Entity(name = "status")
@NoArgsConstructor
public class Status {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String description;
	
	private String type;
}
