package ca.sheridancollege.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.beans.Equipment;
import ca.sheridancollege.beans.Store;
import ca.sheridancollege.repositories.EquipmentRepository;
import ca.sheridancollege.repositories.StoreRepository;

@RestController
public class WebServiceController {
	
	@Autowired
	EquipmentRepository equipRepo;
	
	@Autowired
	StoreRepository storeRepo;

	//GET - Retrieve the entire collection
//		@GetMapping("/stores/{id}/equipment")
//		public Equipment addItem(@PathVariable int id) {
//			Equipment s = Equipment.builder().name("Paul").build();
//			return s;
//		}
		@GetMapping(value="/stores/{id}/equipment", headers={"Content-type=application/json"})
		public List<Equipment> getItems(@PathVariable int id) {
			List<Equipment> s = storeRepo.findById(id).get().getEquipment();
			return s;
		}
		
		//GET - Retrieve an individual entry from the collection
		@GetMapping("/equipment/{id}")
		public Equipment getStudent(@PathVariable int id) {
			return equipRepo.findById(id).orElse(null);
		}
}
