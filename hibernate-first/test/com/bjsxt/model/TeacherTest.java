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
	//�ڶ����ʼ��֮ǰ����class���ص��ڴ�֮������ִ�и÷���
	public static void beforeClass(){
		
		try {
			sf = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	//��ʾ����ķ��������������Եġ�
	public void test() {
		Teacher t = new Teacher();
		t.setName("t1");
		t.setTitle("�߼�");
//		t.setTt(JobTitle.A);
		
		
		//cfd.configure();Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//���Ϊ���ݿ��һ������
		session.beginTransaction();//ִ������ĸ���
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	//�����ݿ��л�ü�¼
	public void testLoad() {
		//cfd.configure();Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//���Ϊ���ݿ��һ������
		Teacher t = (Teacher) session.load(Teacher.class,1);//��idΪ1��������¼���ص�������
		System.out.println(t.getName());
	}
	
	@Test
	//��ʾ����ķ��������������Եġ�
	public void testGet() {
		//cfd.configure();Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//���Ϊ���ݿ��һ������
		Teacher t = (Teacher) session.get(Teacher.class,1);//��idΪ1��������¼���ص�������
		System.out.println(t.getName());
	}

	@Test
	//�����ݿ��л�ü�¼
	public void testSchemaExport() {
		new SchemaExport(new AnnotationConfiguration().configure()).create(true, true);//: ���������䣬�Ƿ������ݿ�ִ�У��ڳ����н��н��� ��
		//��Ҫע�͵������е�<property name="hbm2ddl.auto">update</property> 
	}
	@Test
	//��ʾ����ķ��������������Եġ�
	public void testUpdate1() {
		
		//cfd.configure();Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//���Ϊ���ݿ��һ������
		Teacher t = (Teacher) session.load(Teacher.class,1);//��idΪ1��������¼���ص�������
		t.setTitle("�߼��߼��߼�");
		session.beginTransaction();//ִ������ĸ���
		session.update(t);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	//��ʾ����ķ��������������Եġ�
	public void testdelete() {
		
		//cfd.configure();Ĭ�Ͻ���srcĿ¼�� ��hibernate.cfg.xml�ļ�
		@SuppressWarnings("deprecation")
		Session session = sf.openSession();//���Ϊ���ݿ��һ������
		Teacher t = (Teacher) session.load(Teacher.class,1);//��idΪ1��������¼���ص�������
		session.beginTransaction();//ִ������ĸ���
		session.delete(t);
		session.getTransaction().commit();
		session.close();
	}
	
	
	@AfterClass
	public static void afterClass(){
		sf.close();
	}
}
