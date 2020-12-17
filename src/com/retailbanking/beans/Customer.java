package com.retailbanking.beans;

public class Customer {	
		private int ssnid;
		private int id;
		private String name;
		private int age;
		private String address;
		private String city;
		private String state;
		private String status;
		private String message;
		public Customer(int ssnid, String name, int age, String address, String city, String state) {
			super();
			this.ssnid = ssnid;
			this.name = name;
			this.age = age;
			this.address = address;
			this.city = city;
			this.state = state;
		}
		public int getSsnid() {
			return ssnid;
		}
		public void setSsnid(int ssnid) {
			this.ssnid = ssnid;
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
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
		
		

	}


