package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.beans.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
