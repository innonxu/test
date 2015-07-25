    package com.bjsxt.model;  
      
    public class Student {  
//        private String id;//当映射为uuid时
    	private int id;//当数据库字段映射为MySQL的identity时
        private String name;  
        private int age;
        private String mood;
        
		public String getMood() {
			return mood;
		}
		public void setMood(String mood) {
			this.mood = mood;
		}
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
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}  
        
        }
          
