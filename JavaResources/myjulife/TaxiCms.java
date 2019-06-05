package myjulife;

public class TaxiCms {

	private String id=null;
	private String aim=null;
	private String temp=null; //	上车地点
	private String requesterId=null;
	private String requesterName=null;
	private String requesterAvatar=null;
	private String requesterGender=null;
	private String requesterTel=null;
	private double requesterLatitude=0;//纬度
	private double requesterLongitude=0;//经度
	private int number=0; //剩余可载人数
	private String accepterId=null;
	private String accepterName=null;
	private String accepterAvatar=null;
	private String accepterGender=null;
	private double accepterLatitude=0;//纬度
	private double accepterLongitude=0;//经度
	private String createTime=null;
	private String createDay=null;
	private String status=null;
	
	
	public TaxiCms(String id) {
		this.id=id;
	}
	
	public void setId(String id) {
		this.id=id;
	}
	
	public void setAim(String aim) {
		this.aim=aim;
	}
	
	public void setTemp(String temp) {
		this.temp=temp;
	}
	
	public void setRequesterId(String id) {
		this.requesterId=id;
	}
	public void setRequesterName(String name) {
		this.requesterName=name;
	}
	public void setRequesterAvatar(String avatar) {
		this.requesterAvatar=avatar;
	}
	public void setRequesterGender(String gender) {
		this.requesterGender=gender;
	}
	public void setRequesterTel(String tel) {
		this.requesterTel=tel;
	}
	public void setRequesterLatitude(double latitude) {
		this.requesterLatitude=latitude;
	}
	public void setRequesterLongitude(double longitude) {
		this.requesterLongitude=longitude;
	}
	public void setNumber(int num) {
		this.number=num;
	}
	public void setAccepterId(String id) {
		this.accepterId=id;
	}
	public void setAccepterName(String name) {
		this.accepterName=name;
	}
	public void setAccepterAvatar(String avatar) {
		this.accepterAvatar=avatar;
	}
	public void setAccepterGender(String gender) {
		this.accepterGender=gender;
	}
	public void setAccepterLatitude(double latitude) {
		this.accepterLatitude=latitude;
	}
	public void setAccepterLongitude(double longitude) {
		this.accepterLongitude=longitude;
	}
	public void setCreateTime(String time) {
		this.createTime=time;
	}
	public void setCreateDay(String day) {
		this.createDay=day;
	}
	public void setStatus(String status) {
		this.status=status;
	}
	
	
	public String getId() {
		return this.id;
	}
	public String getAim() {
		return this.aim;
	}
	public String getTemp() {
		return this.temp;
	}
	
	public String getRequesterId() {
		return this.requesterId;
	}
	public String getRequesterName() {
		return this.requesterName;
	}
	public String getRequesterAvatar() {
		return this.requesterAvatar;
	}
	public String getRequesterGender() {
		return this.requesterGender;
	}
	public String getRequesterTel() {
		return this.requesterTel;
	}
	public double getRequesterLatitude() {
		return this.requesterLatitude;
	}
	public double getRequesterLongitude() {
		return this.requesterLongitude;
	}
	public int getNumber() {
		return this.number;
	}
	public String getAccepterId() {
		return this.accepterId;
	}
	public String getAccepterName() {
		return this.accepterName;
	}
	public String getAccepterAvatar() {
		return this.accepterAvatar;
	}
	public String getAccepterGender() {
		return this.accepterGender;
	}
	public double getAccepterLatitude() {
		return this.accepterLatitude;
	}
	public double getAccepterLongitude() {
		return this.accepterLongitude;
	}
	public String getCreateTime() {
		return this.createTime;
	}
	public String getCreateDay() {
		return this.createDay;
	}
	public String getStatus() {
		return this.status;
	}
	
	
	
}
