package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.model.Client;
import dmacc.model.Pet;
import dmacc.repository.ClientRepository;
import dmacc.repository.PetRepository;

/*
 * I'm going to update this to grab pet info by client id but will have to add a service/interface/etc
 */
@Controller
public class PetController {
	@Autowired
	PetRepository repo;
	
	@Autowired
	ClientRepository clientRepo;

    @PostMapping("/newPet/")
    public String addPet(Pet p, Model model) {
    	if(clientRepo.findAll().isEmpty()) {
			Client c = new Client();
			model.addAttribute("newClient", c);
			return "register_client";
    	}
    	model.addAttribute("clients", clientRepo.findAll());
    	repo.save(p);
    	model.addAttribute("petAdded", p);
    	return "pet_added";
    }
    
    @GetMapping("addClientToPet/{clientid}/{petid}")
    public String joinClientPet(@PathVariable("clientid") long clientId, @PathVariable("petid") long petId, Model model) {
    	Client c = clientRepo.findById(clientId).orElse(null);
    	Pet p = repo.findById(petId).orElse(null);
    	p.setclient(c);
    	repo.save(p);
    	model.addAttribute("selectPet", p);
    	return "joined_pet_to_client";
    }
    
	@GetMapping("/viewpet/{id}")
	public String viewPetInfo(@PathVariable("id") long id, Model model) {
		String clientName = "None";
		Pet p = repo.findById(id).orElse(null);
		Client c = p.getclient();
		if(c != null) {
			clientName = c.getName();
		}
		model.addAttribute("owner", clientName);
		model.addAttribute("petSelected", p);
		return "view_pet";
	}
	
	@GetMapping("editPet/{id}")
	public String editPetInfo(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		model.addAttribute("editPet", p);
		return "edit_pet";
	}
	
	@PostMapping("/updatePet/{id}")
	public String updatePet(Pet p, Model model) {
		repo.save(p);
		model.addAttribute("petAdded", p);
		return "employee_landing";
	}
	
	@GetMapping("/deletePet/{id}")
	public String deletePetAcct(@PathVariable("id") long id, Model model) {
		Pet p = repo.findById(id).orElse(null);
		repo.delete(p);
		return "pet_list";
	}
	
}