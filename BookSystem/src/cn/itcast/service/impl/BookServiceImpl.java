package cn.itcast.service.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Category;
import cn.itcast.service.BookService;
import cn.itcast.utils.PageBean;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}


	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = bookDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		List<Book> list = bookDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}


	@Override
	public void save(Book book) {
		bookDao.save(book);
	}


	@Override
	public Book getById(Serializable id) {
		return bookDao.getById(id);
	}


	@Override
	public void update(Book book) {
		bookDao.update(book);
	}


	@Override
	public void delete(Serializable id) {
		bookDao.delete(id);
	}

}
