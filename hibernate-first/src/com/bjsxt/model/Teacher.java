    package com.bjsxt.model;  

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
      
    @Entity
    //@Table(name="_teacher") //�����ݿ��б�������������ͬʱ��ʹ�ø�ע�⡣��ָ�������Ӧ�����ݿ�����Ϊ_teacher�ı����ñ����ڣ����½��� �����ǰ汾�����⣬��ʵ�飬�ñ��ᱻ������
    public class Teacher {  
        private int id;  
        private String name;  
        private String title;
//        private JobTitle tt;
        
//        @Enumerated(EnumType.STRING)
//        public JobTitle getTt() {
//			return tt;
//		}
//		public void setTt(JobTitle tt) {
//			this.tt = tt;
//		}
		
		@Id
		@GeneratedValue //�Զ��������ݿ��е�
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		 
        
        }
          
