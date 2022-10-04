package com.springboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.rest.entity.Pet;

public interface PetRepository extends JpaRepository<Pet,Integer>{

	Pet findByName(String name);

}
