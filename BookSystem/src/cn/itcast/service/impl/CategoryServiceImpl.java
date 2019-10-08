package cn.itcast.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;
import cn.itcast.domain.Manager;
import cn.itcast.service.CategoryService;
import cn.itcast.utils.PageBean;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDao categoryDao; 

	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}


	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = categoryDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		List<Category> list = categoryDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}


	@Override
	public void save(Category category) {
		categoryDao.save(category);
	}


	@Override
	public Category getById(Serializable id) {
		return categoryDao.getById(id);
	}


	@Override
	public void update(Category category) {
		categoryDao.update(category);
	}


	@Override
	public void delete(Serializable id) {
		categoryDao.delete(id);
	}


	@Override
	public List<Category> list() {
		return categoryDao.list();
	}

}
