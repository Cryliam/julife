package myjulife;

import java.util.ArrayList;


public class User {
	private String id=null;
	private String name=null;
	private String gender=null;
	private String addr=null;
	private String tel=null;
	private ArrayList cmsList=new ArrayList<>();
	
	public User(String id) {
		this.id=id;
		
	}
	
	
	public void setName(String n) {
		this.name=n;
	}
	public void setGender(String g) {
		this.gender=g;
	}
	public void setAddr(String a) {
		this.addr=a;
	}
	public void setTel(String t) {
		this.tel=t;
	}
	public void add(Commission c) {
		this.cmsList.add(c);
	}
	
	
	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getGender() {
		return this.gender;
	}
	public String getAddr() {
		return this.addr;
	}
	public String getTel() {
		return this.tel;
	}
	public ArrayList<Commission> getCmsList(){
		return this.cmsList;
	}
}
