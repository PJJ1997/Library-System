package cn.itcast.dao;

import cn.itcast.domain.Book;

public interface BookDao extends BaseDao<Book>{
	public void updateGive(Long book_id);//设置书本不可借
	
	public Long getBook_id(String book_num);//根据书本编号返回书本id
	
	public void updateBack(Long book_id);//设置书本可借
}
