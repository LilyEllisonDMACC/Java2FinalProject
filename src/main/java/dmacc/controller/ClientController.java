package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.model.Client;
import dmacc.repository.ClientRepository;

@Controller
public class ClientController {
	@Autowired
	ClientRepository repo;
	// this can be moved to another controller if anyone sees the need to
	
//	@PostMapping("/searchclientname")
//	public String findClientName(String n, Model model) {
//		
//	}
	
	@PostMapping("/newclient/")
	public String reviseClient(Client c, Model model) {
		repo.save(c);
		model.addAttribute("clientAdded", c);
		return "post_registration";
	}
	
	@GetMapping("/viewclient/{id}")
	public String viewClientInfo(@PathVariable("id") long id, Model model) {
		Client c = repo.findById(id).orElse(null);
		model.addAttribute("clientSelected", c);
		return "view_client";
	}
	
	@GetMapping("editClient/{id}")
	public String editClientInfo(@PathVariable("id") long id, Model model) {
		Client c = repo.findById(id).orElse(null);
		model.addAttribute("editClient", c);
		return "edit_client";
	}
	
	@PostMapping("/updateClient/{id}")
	public String updateClient(Client c, Model model) {
		repo.save(c);
		model.addAttribute("clientAdded", c);
		return "post_registration";
	}
	
	@GetMapping("/deleteClient/{id}")
	public String deleteClientAcct(@PathVariable("id") long id, Model model) {
		Client c = repo.findById(id).orElse(null);
		repo.delete(c);
		return "client_list";
	}
	
    @GetMapping("/searchClientByName")
    public String searchClientByName(@RequestParam("name") String name, Model model) {
        List<Client> clients = repo.findByName(name);
        model.addAttribute("clients", clients);
        return "client_search_results"; 
    }
    
	
}
