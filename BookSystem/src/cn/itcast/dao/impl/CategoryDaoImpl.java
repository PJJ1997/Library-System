package cn.itcast.dao.impl;



import java.util.List;

import cn.itcast.dao.CategoryDao;
import cn.itcast.domain.Category;

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao {

	@Override
	public List<Category> list() {
		List<Category> list = (List<Category>) getHibernateTemplate().find("from Category");
		return list;
	}

	

}
