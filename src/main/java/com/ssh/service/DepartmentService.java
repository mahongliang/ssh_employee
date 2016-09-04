package com.ssh.service;

import com.ssh.bean.Department;
import com.ssh.util.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer curPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	

	void delete(Department department);

}
