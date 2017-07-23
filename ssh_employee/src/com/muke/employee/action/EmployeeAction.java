package com.muke.employee.action;
/*
 * 员工管理Action类
 */
import java.util.List;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动使用对象
	private Employee employee=new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//注入业务层的类
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//接收当前的页数
	private Integer currPage=1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String login() throws Exception{
		System.out.println("login执行了....");
		//调用业务层类
		Employee existEmployee=employeeService.login(employee);
		if(existEmployee==null){
			//登录失败
			this.addActionError("用户名或密码错误!");
			return "input";
		}else{
			//登录成功
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);//经用户名密码存中
			return "success";
		}
	}
	
	/*
	 * 分页查询员工的执行的方法:
	 */
	public String findAll() throws Exception{
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/*
	 * 跳转到添加员工页面执行的方法
	 */
	public String saveUI() throws Exception{
		//查询所有的部门
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	/*
	 * 员工保存的方法
	 */
	public String save() throws Exception{
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*
	 * 编辑员工执行方法
	 */
	public String edit() throws Exception{
		//根据员工ID查询员工
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/*
	 * 修改员工执行方法
	 */
	public String update() throws Exception{
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/*
	 * 删除员工执行方法
	 */
	public String delete() throws Exception{
		employee=employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	/*
	 * 退出登录执行方法
	 */
	public String logout() throws Exception{
		ActionContext.getContext().getSession().remove("existEmployee");
		return "input";
	}
}
