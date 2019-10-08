package cn.itcast.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

//基类
public interface BaseDao<T> {
	void save(T t);//添加一个实体
	void delete(T t);//删除一个实体
	void delete(Serializable id);//根据id删除一个实体
	void update(T t);//更新一个实体
	T	getById(Serializable id);//根据id获取实体
	Integer	getTotalCount(DetachedCriteria dc);//获取离线查询对象的记录总条数
	List<T> getPageList(DetachedCriteria dc,Integer start,Integer pageSize);//获取实体集合
	
}
