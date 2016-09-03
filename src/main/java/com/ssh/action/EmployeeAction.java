package com.ssh.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.bean.Employee;
import com.ssh.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{

	private Employee employee = new Employee();
	
	@Autowired
	private EmployeeService employeeService;
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

}
