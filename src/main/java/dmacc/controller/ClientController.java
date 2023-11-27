package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.model.Client;
import dmacc.repository.ClientRepository;

@Controller
public class ClientController {
	@Autowired
	ClientRepository repo;
	// this can be moved to another controller if anyone sees the need to
	
	@PostMapping("/searchclientname")
	public String findClientName(String n, Model model) {
		
	}
	
	@PostMapping("/newclient/")
	public String reviseClient(Client c, Model model) {
		repo.save(c);
		model.addAttribute("clientAdded", c);
		return "post_registration";
	}
}
