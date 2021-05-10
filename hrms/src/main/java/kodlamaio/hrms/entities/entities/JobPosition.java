package kodlamaio.hrms.entities.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name ="job_positions")
@Data
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "job_name")
	private String jobName;

	public JobPosition(int id, String jobName) {
		super();
		this.id = id;
		this.jobName = jobName;
	}

	public JobPosition() {

	}

	/*public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}*/
}
