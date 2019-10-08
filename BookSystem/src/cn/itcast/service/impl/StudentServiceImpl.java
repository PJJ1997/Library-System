package cn.itcast.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Manager;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;
import cn.itcast.utils.PageBean;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;
	
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = studentDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		List<Student> list = studentDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}


	@Override
	public void save(Student student) {
		studentDao.save(student);
	}


	@Override
	public Student getById(Serializable id) {
		Student student = studentDao.getById(id);
		return student;
	}


	@Override
	public void update(Student student) {
		studentDao.update(student);
	}


	@Override
	public void delete(Serializable id) {
		studentDao.delete(id);
	}


	@Override
	public Student getByStuNum(String stu_num) {
		return studentDao.getByStuNum(stu_num);
	}





}
