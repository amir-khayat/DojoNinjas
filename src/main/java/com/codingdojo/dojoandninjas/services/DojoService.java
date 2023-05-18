package com.codingdojo.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoandninjas.models.Dojo;
import com.codingdojo.dojoandninjas.repositories.DojoRepo;

@Service
public class DojoService {
	@Autowired
	private DojoRepo DojoRepo;
	
	public List<Dojo> allItems(){
		return DojoRepo.findAll();
	}
	
	public Dojo createOrUpdate(Dojo Dojo) {
		return DojoRepo.save(Dojo);
	}
	
	public Dojo findDojoById(long id) {
		return DojoRepo.findById(id).orElse(null);
	}
	
	public void deleteItem(Long id) {
		DojoRepo.deleteById(id);
	}
}
