package com.ssh.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.bean.Department;
import com.ssh.dao.DepartmentDao;
import com.ssh.service.DepartmentService;
import com.ssh.util.PageBean;

@Transactional
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;

	//分页查询部门方法
	@Override
	public PageBean<Department> findByPage(Integer curPage) {
		// TODO Auto-generated method stub
		
		PageBean<Department> pageBean = new PageBean<Department>();
		
		//封装当前页数
		pageBean.setCurrPage(curPage);
		
		//封装每页显示记录数
		int pageSize =4;
		pageBean.setPageSize(pageSize);
		
		//封装总的记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//封装总的页数
		
		double tc = totalCount;
		Double num = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页显示的数据
		int beagin = (curPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(beagin,pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	public Department findById(Integer did) {
		return departmentDao.findById(did);
		
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}


}
