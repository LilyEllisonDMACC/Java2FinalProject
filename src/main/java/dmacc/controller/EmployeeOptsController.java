/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 16, 2023
 */
package dmacc.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.model.Client;
import dmacc.model.Pet;
import dmacc.repository.ClientRepository;
import dmacc.repository.EmployeeRepository;
import dmacc.repository.PetRepository;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 16, 2023
 */
@Controller
public class EmployeeOptsController {
	@Autowired
	ClientRepository clientRepo;
	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	PetRepository petRepo;
	
	@GetMapping("viewEmpDates")
	public String viewEmpShedule(Model model) {
		return "";
	}
	
	@GetMapping("viewEmpInfo")
	public String viewEmpInfo(Model model) {
		return "";
	}
	
	@GetMapping("editEmpInfo")
	public String editEmpInfo(Model model) {
		return "";
	}
	
	@GetMapping("viewAllClient")
	public String showAllClient(Model model) {
		if(clientRepo.findAll().isEmpty()) {
			return addNewClient(model);
		}
		model.addAttribute("clients", clientRepo.findAll());
		return "client_list";
	}
	
	@GetMapping("viewAllPets")
	public String showAllPets(Model model) {
		if(petRepo.findAll().isEmpty()) {
			return addNewPet(model);
		}
		model.addAttribute("pets", petRepo.findAll());
		return "pet_info";
	}
	
	@GetMapping("searchPet")
	public String findPet(Model model) {
		return "";
	}
	
	@GetMapping("searchClient")
	public String findClient(Model model) {
//		if(clientRepo.findAll().isEmpty()) {
//			return addNewClient(model);
//		}
//		model.addAttribute("clients", clientRepo.findAll());
		return "find_client";
	}
	
	@GetMapping("addClient")
	public String addNewClient(Model model) {
		Client c = new Client();
		model.addAttribute("newClient", c);
		return "register_client";
	}
	
	@PostMapping("/addClient")
	public String addNewClient(@ModelAttribute Client c, Model model) {
		clientRepo.save(c);
		return showAllClient(model);
	}
	
	@GetMapping("addPet")
	public String addNewPet(Model model) {
		Pet p = new Pet();
		model.addAttribute("newPet", p);
		return "register_pet";
	}
	
	@PostMapping("/addPet")
	public String addNewPet(@ModelAttribute Pet p, Model model) {
		petRepo.save(p);
		return showAllPets(model);
	}

    
	
}
