package com.muke.employee.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.muke.employee.dao.DepartmentDao;
import com.muke.employee.domain.Department;
/*
 * ���Ź���Dao��ʵ����
 */
public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		String hql="select count(*) from Department";
		List<Long> list=this.getHibernateTemplate().find(hql);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list=this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	//DAO�б��沿�ŵķ���
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

	@Override
	//DAO�и��ݲ��ŵ�ID��ѯ���ŵķ���
	public Department findById(Integer did) {
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	//DAO���޸Ĳ��ŵķ���;
	public void update(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(department);
	}

	@Override
	public void delete(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}

	/*
	 * DAO�в�ѯ���в��ŵķ���
	 */
	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Department");
	}



}
