package com.ssh.dao;

import java.util.List;

import com.ssh.bean.Department;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int beagin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();


}
