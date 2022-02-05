package com.demo.apirest.flashtract.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.apirest.flashtract.percistense.model.Client;
import com.demo.apirest.flashtract.percistense.model.Contract;
import com.demo.apirest.flashtract.percistense.model.Material;
import com.demo.apirest.flashtract.percistense.model.MaterialContract;
import com.demo.apirest.flashtract.percistense.model.Status;
import com.demo.apirest.flashtract.percistense.model.Vendor;
import com.demo.apirest.flashtract.percistense.model.dto.ContractDetailDto;
import com.demo.apirest.flashtract.percistense.model.dto.ContractDto;
import com.demo.apirest.flashtract.percistense.model.dto.MaterialDto;
import com.demo.apirest.flashtract.persistence.service.ClientService;
import com.demo.apirest.flashtract.persistence.service.ContractService;
import com.demo.apirest.flashtract.persistence.service.MaterialContractService;
import com.demo.apirest.flashtract.persistence.service.MaterialService;
import com.demo.apirest.flashtract.persistence.service.StatusService;
import com.demo.apirest.flashtract.persistence.service.VendorService;
import com.demo.apirest.flastract.utils.Constant;


@RestController
@RequestMapping("/api")
public class ClientController {
	
	@Autowired 
	ClientService clientService;
	
	@Autowired
	VendorService vendorService;
	
	@Autowired
	ContractService contractService;
	
	@Autowired
	StatusService statusService;
	
	@Autowired 
	MaterialService materialService; 
	
	@Autowired
	MaterialContractService materialContractService; 
	
	@GetMapping("/getUsuarios")
	public String getUsuarios() {
		return "acaaaaaaaaaa!!!!!!!!!";
	}
	
	@GetMapping(path = "/getAllUsuarios")
	public ResponseEntity<Map<String, Object>> index(){
		
		Map<String, Object> response = new HashMap<>();
		System.out.println("Inside***************");
		response.put("usuarios", "users");
		//Devolvemos el listado de usuarios
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	/**
	 * Endpoint to generate a new contract with the basic data (no details)
	 * @return 
	 */
	@PostMapping("/createContract")
	public ResponseEntity<Map<String, Object>> createContract(@RequestBody ContractDto contract, BindingResult result){

		Map<String, Object> response = new HashMap<>();
		
		//Validate that the client exists
		Optional<Client> client  = clientService.getClient(contract.getClienteId());
		if (!client .isPresent()) {
			response.put(Constant.ERROR, "Client doesn't exists!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		//Validate that the vendor exits 
		Optional<Vendor> vendor = vendorService.getVendor(contract.getVendorId());
		if(!vendor.isPresent()) {
			response.put(Constant.ERROR, "Vendor doesn't exist!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		//Validate that the amount be greater than 0
		if(contract.getAmount() <= 0) {
			response.put(Constant.ERROR, "Amount must be greater than 0");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		//We suppose the constant statusId represents the Id of the initial status of the contract  
		final Integer statusId = 4;
		//Create the Status Object,
		Optional<Status> status = statusService.getStatusById(statusId);
		if(!status.isPresent()) {
			response.put(Constant.ERROR, "The Initial Status for the contract doesn´t exist!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		
		//Instance a Contract Object to save it
		Date currentDate = new Date();
		
		Contract newContract = new Contract();
		newContract.setDescription(contract.getDescription());
		newContract.setAmount(contract.getAmount());
		newContract.setBalance(contract.getBalance());
		newContract.setCliente(client.get());
		newContract.setVendor(vendor.get());
		newContract.setCreateAt(currentDate);
		newContract.setModifiedAt(currentDate);
		newContract.setStatus(status.get());
		contractService.save(newContract);
		
		//if everything is ok return the httpSatus Created
		response.put(Constant.MESAGE, "Contract created.");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	
	/**
	 * Endpoint to add materials to a contract
	 * @return 
	 */
	@PostMapping("/addMaterialsToContract")
	public ResponseEntity<Map<String, Object>> addMaterialsToContract(@RequestBody ContractDetailDto contractDetail, BindingResult result){
		System.out.println("heeeeeeeeeeeeeeeeeeeeeere");
		Map<String, Object> response = new HashMap<>();
		
		//Validate that the contract exist
		Optional<Contract> contract = contractService.getContractById(contractDetail.getIdContract());
		if(!contract.isPresent()) {
			response.put(Constant.ERROR, "The Contract doesn´t exist!");
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
		//We must validate the Status of the contract but as this is a test we skip that part. 
		
		
		//Add materials to the contract 
		List<MaterialDto> materials =  contractDetail.getMaterialsDto();
		//This list is to save the invalids materials
		List<MaterialDto> materialsInvalids = new ArrayList<>();
		
		for (MaterialDto materialDto : materials) {
			 Optional<Material> material = materialService.getMaterialById(materialDto.getId());
			 
			 //Validate that the material exist
			 if(material.isPresent()) {
				 
				 MaterialContract materialContract = new MaterialContract(material.get(),contract.get());
				 materialContractService.save(materialContract);
			 }
			 
			 materialsInvalids.add(materialDto);
		}
		
		 
	
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}	
	
}