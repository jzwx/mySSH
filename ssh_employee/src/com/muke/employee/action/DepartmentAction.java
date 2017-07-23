package com.muke.employee.action;
/*
 * ���Ź���Action��
 */
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//ģ������ʹ�÷���
	private Department department=new Department();

	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	//��ҳ
	private Integer currPage=1;//��ǰҳ��
	
	
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//ע�벿�Ź����service
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	//�ṩһ����ѯ����
	public String findAll() throws Exception{
		PageBean<Department> pageBean=departmentService.findByPage(currPage);
		//��pageBean���뵽ֵջ�С�
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	public String saveUI() throws Exception{
		return "saveUI";
	}
	
	//��Ӳ���ִ�з���
	public String save() throws Exception{
		departmentService.save(department);
		return "saveSuccess";
	}
	
	//�༭����ִ�з�����
	public String edit() throws Exception{
		department=departmentService.findById(department.getDid());
		return "editSuccess";
	}
	
	//�޸Ĳ���ִ�з���:
	public String update() throws Exception{
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//ɾ�����ŵ�ִ�з���:
	public String delete() throws Exception{
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
}
