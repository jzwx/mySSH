package com.muke.employee.dao;

import java.util.List;

import com.muke.employee.domain.Employee;

/*
 * 员工管理Dao层接口
 */
public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findByID(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);


}
