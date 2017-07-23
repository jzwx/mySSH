package com.muke.employee.service.impl;
/*
 * 员工管理的业务层的实现类
 */
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.EmployeeDao;
import com.muke.employee.domain.Employee;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	/*
	 * 业务层的登录方法
	 */
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	
	/*
	 * 业务层的分页查询员工的方法
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean=new PageBean<Employee>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装显示的记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总的记录数
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总的页数
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/*
	 * 业务层保存员工的方法:
	 */
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}
	
	/*
	 * 业务层根据员工的ID查询员工的方法
	 */
	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findByID(eid);
	}
	/*
	 * 业务层修改员工的方法
	 */
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.update(employee);
	}
	@Override
	public void delete(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.delete(employee);
	}
	
}
