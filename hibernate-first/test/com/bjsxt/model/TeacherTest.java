package com.bjsxt.model;

import static org.junit.Assert.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeacherTest {
	private static SessionFactory sf = null;
	
	@SuppressWarnings("deprecation")
	@BeforeClass
	//在对象初始化之前，在class加载到内存之后，立刻执行该方法
	public static void beforeClass(){
		
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//表示下面的方法是用来做测试的。
	public void test() {
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("高级");
//		t.setTt(JobTitle.A);
		
		
		//cfd.configure();默认解析src目录下 的hibernate.cfg.xml文件
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//理解为数据库的一个连接
		session.beginTransaction();//执行事务的概念
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	//从数据库中获得记录
	public void testLoad() {
		//cfd.configure();默认解析src目录下 的hibernate.cfg.xml文件
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//理解为数据库的一个连接
		Teacher t = (Teacher) session.load(Teacher.class,1);//将id为1的那条记录加载到缓存区
		System.out.println(t.getName());
	}
	
	@Test
	//表示下面的方法是用来做测试的。
	public void testGet() {
		//cfd.configure();默认解析src目录下 的hibernate.cfg.xml文件
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//理解为数据库的一个连接
		Teacher t = (Teacher) session.get(Teacher.class,1);//将id为1的那条记录加载到缓存区
		System.out.println(t.getName());
	}

	@Test
	//从数据库中获得记录
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);//: 输出建表语句，是否让数据库执行；在程序中进行建表 ；
		//需要注释掉配置中的<property name="hbm2ddl.auto">update</property> 
	}
	@Test
	//表示下面的方法是用来做测试的。
	public void testUpdate1() {
		
		//cfd.configure();默认解析src目录下 的hibernate.cfg.xml文件
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//理解为数据库的一个连接
		Teacher t = (Teacher) session.load(Teacher.class,1);//将id为1的那条记录加载到缓存区
		t.setTitle("高级高级高级");
		session.beginTransaction();//执行事务的概念
		session.update(t);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	//表示下面的方法是用来做测试的。
	public void testdelete() {
		
		//cfd.configure();默认解析src目录下 的hibernate.cfg.xml文件
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//理解为数据库的一个连接
		Teacher t = (Teacher) session.load(Teacher.class,1);//将id为1的那条记录加载到缓存区
		session.beginTransaction();//执行事务的概念
		session.delete(t);
		session.getTransaction().commit();
		session.close();
	}
	
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}
