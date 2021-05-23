package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.entities.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(jobSeekerDao.findAll(), "Job Seekers Listed");
	}

	@Override
	public Result register(JobSeeker jobSeeker) {
		if(jobSeeker.getId() == 0 &&
				jobSeeker.getDateOfBirth() == 0 && 
				jobSeeker.getFirstName().length() == 0 &&
				jobSeeker.getLastName().length() == 0 && 
				jobSeeker.getIdentificationNumber().length() == 0) {		
			return new ErrorResult("There should be not free space");		
		}
		else {
			if(checkUserExists(jobSeekerDao.findAll(), jobSeeker) == false) {
				return new ErrorResult("Same email or identification number");
			}
			else {
				this.jobSeekerDao.save(jobSeeker);
				return new SuccessResult("JobSeeker added");
			}
			
		}
}
	private boolean checkUserExists(List<JobSeeker> jobSeeker , JobSeeker checkJobSeeker) {
		for(JobSeeker jobseeker : jobSeeker) {
			if(jobseeker.getEmail().equals(checkJobSeeker.getEmail())) {
					
				return false;
			}
			if(jobseeker.getIdentificationNumber().equals(checkJobSeeker.getIdentificationNumber())) {
				return false;
			}
		
		}
		return true;
	}
}
