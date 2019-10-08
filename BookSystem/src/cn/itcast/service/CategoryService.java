package cn.itcast.service;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Category;
import cn.itcast.utils.PageBean;

public interface CategoryService {
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	void save(Category category);
	
	Category getById(Serializable id);
	
	void update(Category category);
	
	void delete(Serializable id);
	
	List<Category> list();
}
