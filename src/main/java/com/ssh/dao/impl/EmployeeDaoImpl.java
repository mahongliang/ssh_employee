package com.ssh.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import com.ssh.bean.Department;
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

	@Override
	public List<Employee> findByPage(int beagin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = (List<Employee>) this.getHibernateTemplate().findByCriteria(criteria,beagin,pageSize);
		return list;
	}

	@Override
	public int findCount() {
		String hql = "select count(*) from Employee";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql);
		if (list.size() >0) {
			return list.get(0).intValue();
		}
		return 0;
	}

}
