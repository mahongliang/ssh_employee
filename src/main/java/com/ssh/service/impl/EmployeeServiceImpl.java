package com.ssh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.bean.Department;
import com.ssh.bean.Employee;
import com.ssh.dao.EmployeeDao;
import com.ssh.service.EmployeeService;
import com.ssh.util.PageBean;

/**
 * 员工管理服务实现接口
 * 
 * @author mahl
 *
 */
@Transactional
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

	@Override
	public PageBean<Employee> findByPage(int curPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean = new PageBean<Employee>();

		// 封装当前页数
		pageBean.setCurrPage(curPage);

		// 封装每页显示记录数
		int pageSize = 4;
		pageBean.setPageSize(pageSize);

		// 封装总的记录数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);

		// 封装总的页数

		double tc = totalCount;
		Double num = Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());

		// 封装每页显示的数据
		int beagin = (curPage - 1) * pageSize;
		List<Employee> list = employeeDao.findByPage(beagin, pageSize);
		pageBean.setList(list);

		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}

	@Override
	public Employee getById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.getById(eid);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
	}
}
