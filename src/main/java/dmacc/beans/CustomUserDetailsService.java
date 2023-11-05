/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 5, 2023
 */
package dmacc.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import dmacc.repository.EmployeeRepository;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 5, 2023
 */
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private EmployeeRepository employeeRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepo.findByUsername(username);
		if(employee == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(employee);
	}

}
