package cn.itcast.dao.impl;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import cn.itcast.dao.ManagerDao;
import cn.itcast.domain.Manager;

public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {

	@Override
	public Manager getByManagerNum(final String Manager_num) {
		return getHibernateTemplate().execute(new HibernateCallback<Manager>() {
			@Override
			public Manager doInHibernate(Session session) throws HibernateException {
				String hql = "from Manager where manager_num = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, Manager_num);
				Manager manager = (Manager) query.uniqueResult();
				return manager;
			}
		});
	}
	

}
