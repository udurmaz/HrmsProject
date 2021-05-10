package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.entities.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer> {

}
