package cn.itcast.service;

import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Book;
import cn.itcast.utils.PageBean;

public interface BookService{
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	
	void save(Book book);
	
	Book getById(Serializable id);
	
	void update(Book book);
	
	void delete(Serializable id);
}
