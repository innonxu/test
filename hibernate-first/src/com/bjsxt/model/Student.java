    package com.bjsxt.model;  
      
    public class Student {  
//        private String id;//��ӳ��Ϊuuidʱ
    	private int id;//�����ݿ��ֶ�ӳ��ΪMySQL��identityʱ
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
          
