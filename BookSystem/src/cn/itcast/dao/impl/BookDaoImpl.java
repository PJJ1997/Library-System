package cn.itcast.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateCallback;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;

public class BookDaoImpl extends BaseDaoImpl<Book> implements BookDao {

	@Override
	public void updateGive(Long book_id) {
		Book book = getHibernateTemplate().get(Book.class, book_id);
		book.setGiveback("²»¿É½è");
	}

	@Override
	public Long getBook_id(final String book_num) {
		Book book2 = getHibernateTemplate().execute(new HibernateCallback<Book>() {

			@Override
			public Book doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Book where book_num = ?");
				query.setParameter(0, book_num);
				Book book = (Book) query.uniqueResult();
				return book;
			}
		});
		return book2.getBook_id();
	}

	@Override
	public void updateBack(Long book_id) {
		Book book = getHibernateTemplate().get(Book.class, book_id);
		book.setGiveback("¿É½è");
	}
	

}
