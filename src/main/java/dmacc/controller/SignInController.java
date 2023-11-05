/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 5, 2023
 */
package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import dmacc.repository.EmployeeRepository;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 5, 2023
 */
@Controller
public class SignInController {
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
}
