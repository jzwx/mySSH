package com.muke.employee.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
import com.muke.employee.domain.PageBean;
import com.muke.employee.service.DepartmentService;
/*
 * ���Ź����ҵ����ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//ע�벿�Ź����Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	//��ҳ��ѯ���ŵķ���
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean=new PageBean<Department>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc=totalCount;
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	//ҵ��㱣�沿�ŵķ���
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}

	@Override
	//���ݱ���ID��ѯ���ŷ���
	public Department findById(Integer did) {
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
		// TODO Auto-generated method stub
		departmentDao.update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		departmentDao.delete(department);
	}

	/*
	 * ��ѯ���в��ŵķ���
	 */
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentDao.findAll();
	}
	
}
