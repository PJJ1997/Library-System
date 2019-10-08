package cn.itcast.dao;



import cn.itcast.domain.Manager;

public interface ManagerDao extends BaseDao<Manager> {
	public Manager getByManagerNum(String Manager_num);//根据管理员编号返回管理员实体

}
