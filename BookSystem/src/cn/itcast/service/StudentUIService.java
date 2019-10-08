package cn.itcast.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.utils.PageBean;

public interface StudentUIService {
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
}
