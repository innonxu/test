package com.bjsxt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bjsxt.model.Student;

public class StudentTest {
	public static void main(String args []){
		Student s = new Student();
		s.setAge(1);
		s.setName("s1");
		s.setMood("smile");
		Configuration cfd = new Configuration();
		//cfd.configure();默认解析src目录下 的hibernate.cfg.xml文件
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfd.configure().buildSessionFactory();//默认解析src目录下 的hibernate.cfg.xml文件
		Session session = sf.openSession();//理解为数据库的一个连接
		
		session.beginTransaction();//执行事务的概念
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
