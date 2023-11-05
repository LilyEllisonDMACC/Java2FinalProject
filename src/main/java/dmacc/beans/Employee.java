/**
 * @author tehli - lbellison
 * CIS175 - Fall 2023
 * Nov 5, 2023
 */
package dmacc.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author LILY ELLISON - LBELLISON
 * CIS175 - FALL 2023
 * Nov 5, 2023
 */
@Data
@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String availability;
	@Column
	private String firstName;
	@Column
	private String lastName;
	
	

}


