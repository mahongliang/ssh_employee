package com.ssh.dao;

import java.util.List;

import com.ssh.bean.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

	List<Employee> findByPage(int beagin, int pageSize);

	int findCount();

	void save(Employee employee);

	Employee getById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
