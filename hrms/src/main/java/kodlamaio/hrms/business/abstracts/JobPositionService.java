package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.entities.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
