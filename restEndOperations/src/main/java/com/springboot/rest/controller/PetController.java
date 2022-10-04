package com.springboot.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.rest.entity.Pet;
import com.springboot.rest.service.PetService;

@RestController
public class PetController {
	
	@Autowired
	private PetService petService;
	
//	http://localhost:8080/Pet
	@PostMapping("/Pet")
	public Pet addPet(@RequestBody Pet pet)
	{
		return petService.savePet(pet);
	}
	
//	http://localhost:8080/Pets
	@PostMapping("/Pets")
	public List<Pet> addPets(@RequestBody List<Pet> pets){
		return petService.savePets(pets);
	}
	
//	http://localhost:8080/getPets
	@GetMapping("/getPets")
	public List<Pet> findAllPets(){
		return petService.getPets();
	}
	
//	http://localhost:8080/getPetById/4
	@GetMapping("/getPetById/{id}")
	public Pet getPetById(@PathVariable int id) {
		return petService.getPetById(id);
	}
	
//	http://localhost:8080/getPetByName/stark
	@GetMapping("/getPetByName/{name}")
	public Pet getPetByName(@PathVariable String name) {
		return petService.getPetByName(name);
	}
	
//	http://localhost:8080/updatePet
	@PutMapping("/updatePet")
	public Pet updatePet(@RequestBody Pet pet) {
		return petService.updatePet(pet);
	}
	
//	http://localhost:8080/deletePet/1
	@DeleteMapping("/deletePet/{id}")
	public String deletePet(@PathVariable int id) {
		return petService.deletePet(id);
	}
	
}
