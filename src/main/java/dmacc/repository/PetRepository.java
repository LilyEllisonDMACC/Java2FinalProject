/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 16, 2023
 */
package dmacc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dmacc.model.Pet;



/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 16, 2023
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long>{

}


