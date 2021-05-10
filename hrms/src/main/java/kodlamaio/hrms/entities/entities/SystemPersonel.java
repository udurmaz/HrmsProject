package kodlamaio.hrms.entities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="system_personels")
@Data
public class SystemPersonel {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int id;
	
	@Column(name="department_id")
	private int departmentId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public SystemPersonel() {
		
	}
	
	public SystemPersonel(int id, int departmentId, String firstName, String lastName) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
}
