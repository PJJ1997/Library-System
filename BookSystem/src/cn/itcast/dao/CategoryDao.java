package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Category;

public interface CategoryDao extends BaseDao<Category>{
	public List<Category> list();//返回目录集合
}
