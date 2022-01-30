package com.demo.apirest.flashtract.percistense.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Entitie for Clients 
 * @author Carlos
 *
 */
@Data
@Entity(name = "cliente")
@NoArgsConstructor
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	private String status;
	
	  @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente", cascade=CascadeType.ALL)
	  private List<Contract> contracts;
	
}
