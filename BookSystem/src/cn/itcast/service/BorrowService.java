package cn.itcast.service;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Borrow;
import cn.itcast.domain.Category;
import cn.itcast.utils.PageBean;

public interface BorrowService{
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	void save(Borrow borrow);
	
	void delete(Serializable id);
	
	void update(Borrow borrow);
	
	Borrow getById(Serializable id);
}
