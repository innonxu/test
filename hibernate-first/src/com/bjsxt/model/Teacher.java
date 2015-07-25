    package com.bjsxt.model;  

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
      
    @Entity
    //@Table(name="_teacher") //当数据库中表名与类名不相同时，使用该注解。其指：该类对应于数据库中名为_teacher的表，若该表不存在，则新建。 可能是版本的问题，经实验，该表不会被创建。
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
		@GeneratedValue //自动生成数据库中的
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
          
