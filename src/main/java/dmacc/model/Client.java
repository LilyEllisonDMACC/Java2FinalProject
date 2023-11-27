package dmacc.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "client", schema = "doggiedaycare")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long client_id;

    private String name;
    private String contactInfo;
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;
    
    public Client() {
    	super();
    }
    
    public Client(String name, String contactInfo, String password) {
    	this.name = name;
    	this.contactInfo = contactInfo;
    	this.password = password;
    }
    
    public Client(Long id, String name, String contactInfo, String password, List<Pet> pets) {
    	this.client_id = id;
    	this.name = name;
    	this.contactInfo = contactInfo;
    	this.password = password;
    	this.pets = pets;
    }

	public Long getId() {
		return client_id;
	}

	public void setId(Long id) {
		this.client_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
