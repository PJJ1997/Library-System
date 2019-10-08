package cn.itcast.service.impl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.BorrowDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Borrow;
import cn.itcast.service.BorrowService;
import cn.itcast.utils.PageBean;

public class BorrowServiceImpl implements BorrowService {
	private BorrowDao borrowDao;
	private BookDao bookDao;
	
	
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}


	public void setBorrowDao(BorrowDao borrowDao) {
		this.borrowDao = borrowDao;
	}


	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = borrowDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		List<Borrow> list = borrowDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		for(Borrow borrow : list){
			try {
				Date return_date = sdf.parse(borrow.getReturn_time());
				String format = sdf.format(new Date());
				Date now_date = sdf.parse(format);
				long days = (return_date.getTime()-now_date.getTime())/(24*60*60*1000);
				if(days>=0){
					borrow.setExprie(days);
				}
				else{
					borrow.setExprie(0L);
					borrow.setTicket(days*(-0.2));
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		pb.setList(list);
		return pb;
	}


	@Override
	public void save(Borrow borrow) {
		borrowDao.save(borrow);
		bookDao.updateGive(bookDao.getBook_id(borrow.getBook().getBook_num()));
	}


	@Override
	public void delete(Serializable id) {
		bookDao.updateBack(bookDao.getBook_id(borrowDao.getById(id).getBook().getBook_num()));
		borrowDao.delete(id);
	}


	@Override
	public void update(Borrow borrow) {
		borrowDao.update(borrow);
	}


	@Override
	public Borrow getById(Serializable id) {
		return borrowDao.getById(id);
	}

}
