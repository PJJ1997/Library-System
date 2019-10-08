package cn.itcast.dao.impl;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoImpl extends BaseDaoImpl<Student> implements StudentDao {

	@Override
	public Student getByStuNum(final String stu_num) {
		return getHibernateTemplate().execute(new HibernateCallback<Student>() {
			@Override
			public Student doInHibernate(Session session) throws HibernateException {
				String hql = "from Student where stu_num = ?";
				Query query = session.createQuery(hql);
				query.setParameter(0, stu_num);
				Student stu = (Student) query.uniqueResult();
				return stu;
			}
		});
		 
	}


}
