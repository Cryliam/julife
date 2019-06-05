package myjulife;



public class Commission {
	private User user;
	private Runner runner;
	private String title=null;
	private String text=null;
	private String createTime=null;
	private String finishTime=null;
	private String userName=null;
	private String userTel=null;
	private String userId=null;
	private String runnerName=null;
	private String runnerTel=null;
	private String runnerId=null;
	private String id=null;
	private String addr=null;
	private int status=0;     //0：未接受  -1：已接受未完成 1:已完成未付款 2:完成并付款
	private int type=0;//1:超市购物，2:食堂带饭，3:打印资料
	private int price=0;
	private int addrType=0;;
	private String aimAddr=null;
	
	public Commission() {
		
	}
	
	public void setRunner(Runner r) {
		this.runner=r;
	}
	
	public void setTitle(String t) {
		this.title=t;
	}
	public void setText(String t) {
		this.text=t;
	}
	public void setCreateTime(String t) {
		this.createTime=t;
	}
	public void setFinishTime(String t) {
		this.finishTime=t;
	}
	public void setId(String id) {
		this.id=id;
	}
	public void setStatus(int st) {
		this.status=st;
	}
	public void setType(int t) {
		this.type=t;
	}
	public void setPrice(int p) {
		this.price=p;
	}
	public void setAddr(String addr) {
		this.addr=addr;
	}
	public void setUserInfo(String id,String name,String tel) {
		this.userId=id;
		this.userName=name;
		this.userTel=tel;
	}
	public void setUserInfo(String id,String name) {
		this.userId=id;
		this.userName=name;
	}
	public void setRunnerInfo(String id,String name,String tel) {
		this.runnerId=id;
		this.runnerName=name;
		this.runnerTel=tel;
	}
	public void setAimAddr(String aimaddr) {
		this.aimAddr=aimaddr;
	}
	
	
	
	public Runner getRunner() {
		return this.runner;
	}
	public User getUser() {
		return this.user;
	}
	public String getTitle() {
		return this.title;
	}
	public String getText() {
		return this.text;
	}
	public String getCreateTime() {
		return this.createTime;
	}
	public String getFinishTime() {
		return this.finishTime;
	}
	public String getId() {
		return this.id;
	}
	public int getStatus() {
		return this.status;
	}
	public int getType() {
		return this.type;
	}
	public int getPrice() {
		return this.price;
	}
	public String getAddr() {
		return this.addr;
	}
	
	public String getUserName() {
		return this.userName;
	}
	public String getUserTel() {
		return this.userTel;
	}
	public String getuserId() {
		return this.userId;
	}
	public String getRunnerName() {
		return this.runnerName;
	}
	public String getRunnerTel() {
		return this.runnerTel;
	}
	public String getRunnerId() {
		return this.runnerId;
	}
	public String getAimAddr() {
		return this.aimAddr;
	}
	

}
