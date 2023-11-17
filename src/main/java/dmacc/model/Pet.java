/**
 * @author Jacey Espinosa - JLESPINOSA
 * CIS175 - FALL 2023
 * Nov 11, 2023
 */

package dmacc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "pet", schema = "doggiedaycare")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
    private int age;
    
	@ManyToOne
    @JoinColumn(name = "client_id")
    private Client owner;
	
    public Pet() {
    	super();
    }
    
    public Pet(Long id, String name, String breed, int age) {
    	this.id = id;
    	this.name = name;
    	this.breed = breed;
    	this.age = age;
    }
    
    public Pet(Long id, String name, String breed, int age, Client owner) {
    	this.id = id;
    	this.name = name;
    	this.breed = breed;
    	this.age = age;
    	this.owner = owner;
    }
    
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Client getOwner() {
		return owner;
	}

	public void setOwner(Client owner) {
		this.owner = owner;
	}


}