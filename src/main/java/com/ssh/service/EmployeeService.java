package com.ssh.service;

import com.ssh.bean.Employee;
import com.ssh.util.PageBean;

/**
 * 员工管理接口
 * @author mahl
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(int curPage);

	void save(Employee employee);

	Employee getById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);
	
}
