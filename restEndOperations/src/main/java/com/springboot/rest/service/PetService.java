package com.springboot.rest.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.rest.entity.Pet;
import com.springboot.rest.repository.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public Pet savePet(Pet pet){
		return petRepository.save(pet);
	}
	
	public List<Pet> savePets(List<Pet> pets){
		return petRepository.saveAll(pets);
	}
	
	public List<Pet> getPets(){
		return petRepository.findAll();
	}
	
	public Pet getPetById(int id){
		return petRepository.findById(id).orElse(null);
	}
	
	public Pet getPetByName(String name){
		return petRepository.findByName(name);
	}
	
	public String deletePet(int id) {
		petRepository.deleteById(id);
		return "Pet Removed !"+id;
	}
	
	public Pet updatePet(Pet pet) {
		Pet existingPet=petRepository.findById(pet.getId()).orElse(null);
		existingPet.setName(pet.getName());
		existingPet.setAge(pet.getAge());
		existingPet.setCategory(pet.getCategory());
		existingPet.setBreed(pet.getBreed());
		return petRepository.save(existingPet);
	}
}
