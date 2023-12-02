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

    @GetMapping("/viewPets/")
    public String viewPets(Model model) {

        List<Pet> pets = new ArrayList<>(); 
        model.addAttribute("pets", pets);

        return "view_pets";
    }
    
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
    	model.addAttribute("selectPet", p);
    	return "joined_pet_to_client";
    }
}