package com.ssh.dao.impl;

import java.util.List;


import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ssh.bean.Employee;
import com.ssh.dao.EmployeeDao;

public class EmployeeDaoImpl extends  HibernateDaoSupport implements EmployeeDao{

	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql = "from Employee where username = ? and password = ?";
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().find(hql, employee.getUsername(),employee.getPassword());
		if (list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
