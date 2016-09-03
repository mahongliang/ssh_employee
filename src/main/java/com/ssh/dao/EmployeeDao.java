package com.ssh.dao;

import com.ssh.bean.Employee;

public interface EmployeeDao {

	Employee findByUsernameAndPassword(Employee employee);

}
