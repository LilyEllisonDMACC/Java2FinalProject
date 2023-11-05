/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 5, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dmacc.beans.Employee;
/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 5, 2023
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

//	@Query("SELECT e FROM Employee e WHERE e.username = ?1")
//	public Employee findByUsername(String username);
}
