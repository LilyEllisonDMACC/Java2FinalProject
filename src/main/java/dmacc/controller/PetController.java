package dmacc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dmacc.model.Pet;

/*
 * I'm going to update this to grab pet info by client id but will have to add a service/interface/etc
 */
@Controller
public class PetController {

    @GetMapping("/viewPets")
    public String viewPets(Model model) {

        List<Pet> pets = new ArrayList<>(); 
        model.addAttribute("pets", pets);

        return "view_pets";
    }
}