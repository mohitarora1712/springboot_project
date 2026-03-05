package com.assignment.task1.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.assignment.task1.entity.Employee;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("select s from Employee s where s.name=:name")
	List<Employee> getEmpByName(String name);
	
	@Query("select d from Employee d where d.dept=:dept")
	List<Employee> getEmpByDept(String dept);
	
	@Query("select p from Employee p where p.phone=:phone")
	List<Employee> getEmpByPhone(long phone);
	
	@Query("select e from Employee e where e.email=:email")
	List<Employee> getEmpByEmail(String email);
	
	@Query("select e from Employee e where sal=(select max(e2.sal) from Employee e2)")
	List<Employee> getEmpBySal(int sal);
}
