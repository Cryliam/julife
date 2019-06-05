package myjulife;

import java.util.ArrayList;


public class Runner {
	private String id=null;
	private String name=null;
	private String tel=null;
	private ArrayList<Commission> cmsList=new ArrayList<>();
	
	
	
	public Runner(String id) {
		this.id=id;
	}
	
	
	public void setName(String n) {
		this.name=n;
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
	public String getTel() {
		return this.tel;
	}
	
	public ArrayList<Commission> getCmsList(){
		return this.cmsList;
	}
	
	
	
}
