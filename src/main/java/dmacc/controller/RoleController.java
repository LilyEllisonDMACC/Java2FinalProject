/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Oct 27, 2023
 */
package dmacc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Oct 27, 2023
 */
@Controller
public class RoleController {
	@GetMapping("/pickarole")
	public String pickRole (@RequestParam(name="choice", required=false)String theChoice, Model model) {
		if(theChoice == null) {
			return "index";
		} else if(theChoice.equals("employee")) {
			return "employee_landing";
		}else {
			return "client_landing";
		}
		
	}

}
