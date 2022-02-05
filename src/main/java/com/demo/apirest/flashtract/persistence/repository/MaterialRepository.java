package com.demo.apirest.flashtract.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.apirest.flashtract.percistense.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Integer> {

}
