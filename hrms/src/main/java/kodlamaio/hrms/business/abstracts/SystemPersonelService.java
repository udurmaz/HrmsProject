package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.entities.SystemPersonel;

public interface SystemPersonelService {
	DataResult<List<SystemPersonel>> getAll();
	Result add(SystemPersonel systempersonel);
	
}
