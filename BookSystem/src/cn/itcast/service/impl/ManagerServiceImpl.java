package cn.itcast.service.impl;


import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.dao.ManagerDao;
import cn.itcast.domain.Manager;
import cn.itcast.service.ManagerService;
import cn.itcast.utils.PageBean;

public class ManagerServiceImpl implements ManagerService {
	private ManagerDao managerDao;
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		Integer totalCount = managerDao.getTotalCount(dc);
		PageBean pb = new PageBean(currentPage, totalCount, pageSize);
		
		List<Manager> list = managerDao.getPageList(dc,pb.getStart(),pb.getPageSize());
		pb.setList(list);
		return pb;
	}
	
	@Override
	public void save(Manager manager) {
		managerDao.save(manager);
	}
	
	@Override
	public Manager getById(Serializable id) {
		return managerDao.getById(id);
	}
	
	
	@Override
	public void update(Manager manager) {
		managerDao.update(manager);
	}
	@Override
	public void delete(Serializable id) {
		managerDao.delete(id);
	}
	@Override
	public Manager getByManagerNum(String Manager_num) {
		return managerDao.getByManagerNum(Manager_num);
	}
	

}
