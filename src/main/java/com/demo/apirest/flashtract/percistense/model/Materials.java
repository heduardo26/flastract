package com.demo.apirest.flashtract.percistense.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entitie for Materials 
 * @author Carlos
 *
 */
@Data
@Entity(name = "material")
@NoArgsConstructor
public class Materials {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String code;
	
	private String description;
	
}
