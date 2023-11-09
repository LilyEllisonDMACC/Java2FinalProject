/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 9, 2023
 */
package dmacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 9, 2023
 */
@Controller
public class PageController {

	@GetMapping("/changepage")
	public String changepage (@RequestParam(name="choice", required=false)String theChoice, Model model) {
		if(theChoice == null) {
			return "index";
		} else if(theChoice.equals("prices")) {
			return "prices_list";
		}else if(theChoice.equals("contact")){
			return "contact_us";
		}else if(theChoice.equals("register")) {
			return "register_client";
		} else {
			return "index";
		}
		
	}
	
	
}
