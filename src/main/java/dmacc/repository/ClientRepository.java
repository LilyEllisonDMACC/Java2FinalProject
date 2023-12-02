/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 16, 2023
 */
package dmacc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Client;



/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 16, 2023
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
	List<Client> findByName(String name);
}


