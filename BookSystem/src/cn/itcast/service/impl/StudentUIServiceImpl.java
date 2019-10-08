package cn.itcast.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.StudentUIDao;
import cn.itcast.domain.Book;
import cn.itcast.service.StudentUIService;
import cn.itcast.utils.PageBean;

public class StudentUIServiceImpl implements StudentUIService {
	private StudentUIDao studentUIDao;
	
	public void setStudentUIDao(StudentUIDao studentUIDao) {
		this.studentUIDao = studentUIDao;
	}

	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = studentUIDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		List<Book> list = studentUIDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}

}
