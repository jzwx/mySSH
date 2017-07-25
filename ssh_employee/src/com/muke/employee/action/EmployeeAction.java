package com.muke.employee.action;
/*
 * Ա������Action��
 */
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.omg.CORBA.Request;

import com.muke.employee.domain.Department;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
import com.muke.employee.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//ģ������ʹ�ö���
	private Employee employee=new Employee();
	private String checkcode;
	

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//ע��ҵ������
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	//���յ�ǰ��ҳ��
	private Integer currPage=1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public String login() throws Exception{
		System.out.println("loginִ����....");
		//��֤��У��
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		System.out.println("checkcode:"+checkcode1+" this.checkcode:"+this.getCheckcode());
		//����ҵ�����
		Employee existEmployee=employeeService.login(employee);
		if(existEmployee==null){
			//��¼ʧ��
			this.addActionError("�û������������!");
			return "input";
		}else{
			if(!this.getCheckcode().equalsIgnoreCase(checkcode1)){
				this.addActionError("��֤�����,����������!");
				return "input";
			}
			//��¼�ɹ�
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);//���û����������
			return "success";
		}
	}
	
	/*
	 * ��ҳ��ѯԱ����ִ�еķ���:
	 */
	public String findAll() throws Exception{
		PageBean<Employee> pageBean=employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	
	/*
	 * ��ת�����Ա��ҳ��ִ�еķ���
	 */
	public String saveUI() throws Exception{
		//��ѯ���еĲ���
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	
	/*
	 * Ա������ķ���
	 */
	public String save() throws Exception{
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*
	 * �༭Ա��ִ�з���
	 */
	public String edit() throws Exception{
		//����Ա��ID��ѯԱ��
		employee=employeeService.findById(employee.getEid());
		List<Department> list=departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/*
	 * �޸�Ա��ִ�з���
	 */
	public String update() throws Exception{
		employeeService.update(employee);
		return "updateSuccess";
	}
	
	/*
	 * ɾ��Ա��ִ�з���
	 */
	public String delete() throws Exception{
		employee=employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}
	/*
	 * �˳���¼ִ�з���
	 */
	public String logout() throws Exception{
		ActionContext.getContext().getSession().remove("existEmployee");
		return "input";
	}
}
