/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 5, 2023
 */
package dmacc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import dmacc.beans.Employee;
import dmacc.repository.EmployeeRepository;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 5, 2023
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class EmployeeRepositoryTests {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private EmployeeRepository repo;

	@Test
	public void testCreateEmployee() {
		Employee employee = new Employee();
		employee.setUserName("User");
		employee.setPassword("password");
		employee.setRole("Guest");
		employee.setLastName("Guest");
		employee.setFirstName("Guest");
		
		Employee savedEmployee = repo.save(employee);
		
		Employee existEmployee = entityManager.find(Employee.class, savedEmployee.getId());
		
		assertThat(employee.getRole()).isEqualTo(existEmployee.getRole());
	}
}
