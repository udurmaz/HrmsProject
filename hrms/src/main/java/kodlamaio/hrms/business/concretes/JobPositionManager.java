package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.entities.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(),"Job Position listed");
		
	}

	@Override
	public Result add(JobPosition jobposition) {
		this.jobPositionDao.save(jobposition);
		return new SuccessResult("Job position added");
	}
	
	private Result checkJobPositionExist(JobPosition checkedJobPosition) {
		for(JobPosition jobPosition  : jobPositionDao.findAll()) {
			if(jobPosition.getJobName().equals(checkedJobPosition.getJobName())) {
				return new ErrorResult("Job position is already exist");
			}
			
		}
		return new SuccessResult();
	}

}
