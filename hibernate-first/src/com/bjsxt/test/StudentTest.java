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
		//cfd.configure();Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		@SuppressWarnings("deprecation")
		SessionFactory sf = cfd.configure().buildSessionFactory();//Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		Session session = sf.openSession();//���Ϊ���ݿ��һ������
		
		session.beginTransaction();//ִ������ĸ���
		session.save(s);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}
}
