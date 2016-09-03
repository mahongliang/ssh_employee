package com.ssh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.bean.Employee;
import com.ssh.dao.EmployeeDao;
import com.ssh.service.EmployeeService;

/**
 * 员工管理服务实现接口
 * @author mahl
 *
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existemployee = employeeDao.findByUsernameAndPassword(employee);
		return existemployee;
	}
}
