package com.ssh.action;


import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Department;
import com.ssh.service.DepartmentService;
import com.ssh.util.PageBean;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Department department = new Department();
	
	@Autowired
	private DepartmentService departmentService;
	
	private int curPage=1;
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	
	//提供一个查询方法
	
	public String findAll(){
		
		PageBean<Department> pageBean = departmentService.findByPage(curPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "find";
	}
	
	//跳转到增加部门页面
	public String saveUI(){
		return "saveUI";
	}
	
	//添加部门的执行方法
	
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//编辑部门执行方法
	public String edit(){
		department =  departmentService.findById(department.getDid());
		return "editSuccess";
		
	}

	
	//编写修改部门的方法
	
	public String update(){
		
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门的方法
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
