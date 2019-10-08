package cn.itcast.service;


import java.io.Serializable;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.domain.Manager;
import cn.itcast.utils.PageBean;

public interface ManagerService {
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	void save(Manager manager);
	
	Manager	getById(Serializable id);
	
	void update(Manager manager);
	
	void delete(Serializable id);
	
	public Manager getByManagerNum(String Manager_num);
}
