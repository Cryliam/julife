package myjulife;

public class Commodity {
	private String id="";
	private String name="";
	private int tag;
	
	public Commodity() {
		
	}
	
	public Commodity(String id,String name) {
		this.id=id;
		this.name=name;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setTag(int tag) {
		this.tag=tag;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	public int getTag() {
		return this.tag;
	}
	
}
