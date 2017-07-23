package com.muke.employee.service.impl;
/*
 * Ա�������ҵ����ʵ����
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
	 * ҵ���ĵ�¼����
	 */
	@Override
	public Employee login(Employee employee) {
		// TODO Auto-generated method stub
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
	
	/*
	 * ҵ���ķ�ҳ��ѯԱ���ķ���
	 */
	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Employee> pageBean=new PageBean<Employee>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װ��ʾ�ļ�¼��
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܵļ�¼��
		int totalCount=employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ�ܵ�ҳ��
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin=(currPage-1)*pageSize;
		List<Employee> list=employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	/*
	 * ҵ��㱣��Ա���ķ���:
	 */
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		employeeDao.save(employee);
	}
	
	/*
	 * ҵ������Ա����ID��ѯԱ���ķ���
	 */
	@Override
	public Employee findById(Integer eid) {
		// TODO Auto-generated method stub
		return employeeDao.findByID(eid);
	}
	/*
	 * ҵ����޸�Ա���ķ���
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
