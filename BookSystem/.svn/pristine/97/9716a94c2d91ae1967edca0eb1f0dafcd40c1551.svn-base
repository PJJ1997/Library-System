package cn.itcast.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

//测试hibernate框架
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HibernateTest {
			@Resource(name="sessionFactory")
	private SessionFactory sf ;
	
		@Test
		//单独测试hibernate
		public void fun1(){
			Configuration conf = new Configuration().configure();
			
			SessionFactory sf = conf.buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			//-------------------------------------------------
			User u = new User();
			
			u.setUser_code("rose");
			u.setUser_name("肉丝");
			u.setUser_password("1234");
			
			session.save(u);
			
			//-------------------------------------------------
			tx.commit();
			
			session.close();
			
			sf.close();
			
		}
		
		@Test
		//测试spring管理sessionFactory
		public void fun2(){
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			//-------------------------------------------------
			User u = new User();
			
			u.setUser_code("jack");
			u.setUser_name("杰克");
			u.setUser_password("1234");
			
			session.save(u);
			
			//-------------------------------------------------
			tx.commit();
			
			session.close();
			
		}
		@Resource(name="userDao")
		private UserDao ud;
		@Test
		//测试Dao Hibernate模板
		public void fun3(){
			
			User u = ud.getByUserCode("tom");
			
			System.out.println(u);
		}
		@Resource(name="userService")
		private UserService us;
		@Test
		//测试aop事务
		public void fun4(){
			User u = new User();
			
			u.setUser_code("hqy");
			u.setUser_name("郝强勇");
			u.setUser_password("1234");
			
			
			us.saveUser(u);
		}
		
}
