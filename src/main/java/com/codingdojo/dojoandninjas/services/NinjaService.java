package com.codingdojo.dojoandninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojoandninjas.models.Ninja;
import com.codingdojo.dojoandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepo NinjaRepo;
	
	public List<Ninja> allItems(){
		return NinjaRepo.findAll();
	}
	
	public Ninja createOrUpdate(Ninja Ninja) {
		return NinjaRepo.save(Ninja);
	}
	
	public Ninja findNinjaById(long id) {
		return NinjaRepo.findById(id).orElse(null);
	}
	
	public void deleteItem(Long id) {
		NinjaRepo.deleteById(id);
	}
}