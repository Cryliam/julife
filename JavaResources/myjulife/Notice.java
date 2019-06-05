package myjulife;

import java.util.ArrayList;

public class Notice {
	private String id=null;
	private String title=null;
	private String addr=null;
	private String content=null;
	private String date=null;
	private String createrId=null;
	private String createrName=null;
	private String createrAvatar=null;
	private  ArrayList<String> pics=new ArrayList<>();
	int type=0;//0代表寻物，1代表发表寻的的物
	
	public Notice(String id) {
		this.id=id;
	}
	public Notice() {
		
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	public void setAddr(String addr) {
		this.addr=addr;
	}
	public void setContent(String content) {
		this.content=content;
	}
	public void setDate(String date) {
		this.date=date;
	}
	public void setCreaterId(String openid) {
		this.createrId=openid;
	}
	public void setCreaterName(String name) {
		this.createrName=name;
	}
	public void setCreaterAvatar(String avatar) {
		this.createrAvatar=avatar;
	}
	public void setType(int type) {
		this.type=type;
	}
	public  boolean addPic(String picUrl) {
		if(this.pics.size()<3) {
			this.pics.add(picUrl);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getAddr() {
		return this.addr;
	}
	public String getContent() {
		return this.content;
	}
	public String getDate() {
		return this.date;
	}
	public String getCreaterId() {
		return this.createrId;
	}
	public String getCreaterName() {
		return this.createrName;
	}
	public String getCreaterAvatar() {
		return this.createrAvatar;
	}
	public int getType() {
		return this.type;
	}
}
