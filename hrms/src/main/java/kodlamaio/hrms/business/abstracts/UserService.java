package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.entities.User;

public interface UserService {
	DataResult<List<User>> getAll();
	Result register(User user);
}
