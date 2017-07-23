package com.muke.employee.action;
/*
 * 部门管理Action类
 */
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//模型驱动使用方法
	private Department department=new Department();

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	//分页
	private Integer currPage=1;//当前页数
	
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//注入部门管理的service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//提供一个查询方法
	public String findAll() throws Exception{
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//将pageBean存入到值栈中。
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI() throws Exception{
		return "saveUI";
	}
	
	//添加部门执行方法
	public String save() throws Exception{
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//编辑部门执行方法：
	public String edit() throws Exception{
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//修改部门执行方法:
	public String update() throws Exception{
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门的执行方法:
	public String delete() throws Exception{
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
