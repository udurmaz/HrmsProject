package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.entities.Employer;

@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "Employer listed");
	}

	@Override
	public Result register(Employer employer) {
		if(employer.getCompanyName().length() == 0 &&
				employer.getWebsite().length() == 0 &&
				employer.getWebsiteEmail().length() == 0 &&
				employer.getPhoneNumber().length() == 0 &&
				employer.getPassword().length() == 0 &&
				employer.getPassword_repeat().length() ==0) {
			return new ErrorResult("There should be not free space");
		}
		else {
			if(checkUserExist(employerDao.findAll(), employer) == false) {
				return new ErrorResult("Email already exist");
			}
			else {
				this.employerDao.save(employer);
				return new SuccessResult("Employer registered");
			}
			
		}
	}
	
	private boolean checkUserExist(List<Employer> employer , Employer checkEmployer) {
		for(Employer employers : employer) {
			if(employers.getWebsiteEmail().equals(checkEmployer)) {
				return false;
			}
			
		}
		return true;
	}
}
