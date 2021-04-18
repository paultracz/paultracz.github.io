package ca.sheridancollege.controllers;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Store;
import ca.sheridancollege.beans.Equipment;
import ca.sheridancollege.repositories.StoreRepository;
import ca.sheridancollege.repositories.EquipmentRepository;

@Controller
public class CourseController {

	@Autowired
	EquipmentRepository equipRepo;
	
	@Autowired
	StoreRepository storeRepo;
	
	
	@GetMapping("/")
	public String rootPage() {
		return "home.html";
	}
	
	@GetMapping("/register")

	public String goRegistration () {

	return "register.html";

	}


	@PostMapping("/register")

	public String doRegistration(@RequestParam String username,

	@RequestParam String password) {


	return "redirect:/";

	}
	
	@GetMapping("/login")
	public String goLoginPage() {
		return "login.html";
	}
	
	@GetMapping("/access-denied")
	public String goAccessDenied() {
		return "/error/access-denied.html";
	}
	
	@GetMapping("/addEquipment")
	public String loadAddEquipment() {
		return "addEquipment.html";
	}
	
	@PostMapping("/addEquipment")
	public String saveEquipment(@RequestParam String name, Double price, Integer quantity) {
		Equipment equ = Equipment.builder().name(name).price(price).quantity(quantity).build();
		equipRepo.save(equ);
		return "addEquipment.html";
	}
	
	
	@GetMapping("/addStore")
	public String loadAddStore() {
		return "addStore.html";
	}
	
	@PostMapping("/addStore")
	public String saveStore(@RequestParam String name) {
		Store sto = Store.builder().name(name).build();
		storeRepo.save(sto);
		return "addStore.html";
	}
	
	@GetMapping("/assignEquipmentToStore")
	public String laodAssignEquipmentToStore(Model model) {
		model.addAttribute("equipment", equipRepo.findAll());
		model.addAttribute("stores", storeRepo.findAll());
		
		return "assignEquipmentToStore.html";
	}
	
	@PostMapping("/assignEquipmentToStore")
	public String assignEquipment(@RequestParam String equipment, @RequestParam Integer store) {

		Equipment equ = equipRepo.findByName(equipment).get();
		Store sto = storeRepo.findById(store).get();
		
		equ.getStores().add(sto);
		sto.getEquipment().add(equ);
		
		storeRepo.save(sto);
		
		return "redirect:/assignEquipmentToStore";
	}
	
	
	@GetMapping("/viewStore")
	public String loadViewStore(Model model) {
		model.addAttribute("stores", storeRepo.findAll());
		return "viewStore.html";
	}
	
	@PostMapping("/viewStore")
	public String viewStore(Model model, @RequestParam Integer store) {
		Store sto = storeRepo.findById(store).get();
		model.addAttribute("store", sto);
		model.addAttribute("stores", storeRepo.findAll());
		return "viewStore.html";
	}	
	
	@GetMapping("/delete/{id}")
	public String deleteEquipment(@PathVariable int id) {
		equipRepo.deleteById(id);
		return "redirect:/viewStore";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("equipment", new ArrayList<Equipment>());
		return "search.html";
	}
	
	@GetMapping("/searchName")
	public String searchName(@RequestParam String name, Model model) {
		model.addAttribute("equipment", equipRepo.findByName(name).stream().collect(Collectors.toList()));	
		return "search.html";
	}
	
	@GetMapping("/searchPrice")
	public String searchName(@RequestParam Double pricemin, @RequestParam Double pricemax, Model model) {
		model.addAttribute("equipment", equipRepo.findByPriceGreaterThanEqualAndPriceLessThanEqual(pricemin, pricemax));
		return "search.html";
	}
	@GetMapping("/searchQuantity")
	public String searchName(@RequestParam Integer quantitymin, @RequestParam Integer quantitymax, Model model) {
		model.addAttribute("equipment", equipRepo.findByQuantityGreaterThanEqualAndQuantityLessThanEqual(quantitymin, quantitymax));
		return "search.html";
	}
	
//	private void dropCourse(int studentid, int courseid) {
//		if(corRepo.findById(courseid).isPresent() && stuRepo.findById(studentid).isPresent()) {
//			Course cor = corRepo.findById(courseid).get();
//			Student stu = stuRepo.findById(studentid).get();
//			
//			for (Course c : stu.getCourses()) { //For every course in the student's courses
//				if (c.getId().equals(cor.getId())) { //If the course id matches the course
//					stu.getCourses().remove(c); //Remove the course from the student's courses
//					break;
//				}
//			}
//			for (Student s : cor.getStudents()) { 
//				if (s.getId().equals(stu.getId())) {
//					cor.getStudents().remove(s); 
//					break;
//				}			
//			}
//			stuRepo.save(stu);
//			corRepo.save(cor);
//		}
//	}
}
