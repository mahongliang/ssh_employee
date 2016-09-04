package com.ssh.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Department;
import com.ssh.bean.Employee;
import com.ssh.service.DepartmentService;
import com.ssh.service.EmployeeService;
import com.ssh.util.PageBean;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Employee employee = new Employee();
	private int curPage = 1;
	
	
	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	public String login(){
		
		Employee existEmployee = employeeService.login(employee);
		if (existEmployee == null) {
			this.addActionError("用户名或密码错误!");
			return INPUT;
		}else {
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
	}
	
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(curPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI(){
		List<Department> list =  departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	public String save(){
		employeeService.save(employee);
		return "saveSuccess";
	}
	
	public String edit(){
		employee = employeeService.getById(employee.getEid());
		List<Department> list =  departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editUI";
	}
	
	public String update(){
		
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	public String delete(){
		
		employee = employeeService.getById(employee.getEid());
		
		employeeService.delete(employee);
		return "deleteSuccess";
	}

}
