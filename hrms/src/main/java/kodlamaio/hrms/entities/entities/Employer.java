package kodlamaio.hrms.entities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="Employers")
@Data
public class Employer {
	@Id
	@GeneratedValue
	@Column(name="employers_id")
	private int id;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="website_email")
	private String websiteEmail;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	
	public Employer(int id, String companyName, String website, String websiteEmail, String phoneNumber) {
		super();
		this.id = id;
		this.companyName = companyName;
		this.website = website;
		this.websiteEmail = websiteEmail;
		this.phoneNumber = phoneNumber;
	}
	
	public Employer() {
		
	}
}
