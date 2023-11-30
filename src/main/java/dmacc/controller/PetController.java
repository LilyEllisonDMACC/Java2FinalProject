package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.model.Pet;
import dmacc.repository.PetRepository;

/*
 * I'm going to update this to grab pet info by client id but will have to add a service/interface/etc
 */
@Controller
public class PetController {
	@Autowired
	PetRepository repo;

    @GetMapping("/viewPets")
    public String viewPets(Model model) {

        List<Pet> pets = new ArrayList<>(); 
        model.addAttribute("pets", pets);

        return "view_pets";
    }
    
    @PostMapping("/newPet")
    public String addPet(Pet p, Model model) {
    	repo.save(p);
    	model.addAttribute("petAdded", p);
    	return "pet_added";
    }
}