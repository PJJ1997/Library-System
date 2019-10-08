package cn.itcast.service;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Student;
import cn.itcast.utils.PageBean;

public interface StudentService {
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	void save(Student student);
	
	Student getById(Serializable id);
	
	void update(Student student);
	
	void delete(Serializable id);
	
	public Student getByStuNum(String stu_num);
	
}
