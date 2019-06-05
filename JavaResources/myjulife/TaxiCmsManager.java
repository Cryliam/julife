package myjulife;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class TaxiCmsManager {
	private static ArrayList<TaxiCms> list0=new ArrayList<>();//未被接受的请求列表
	private static ArrayList<TaxiCms> list1=new ArrayList<>();//被接受的请求列表
	
	public TaxiCmsManager() {
		
	}
	
	public static void add(TaxiCms tc) {
		list0.add(tc);
	}
	public static void remove(String id) {
		for(int i=0;i<list0.size();i++) {
			if(list0.get(i).getId().equals(id)) {
				list0.remove(i);
				break;
			}
		}
	}
	
	public static ArrayList<TaxiCms> getList0(){
		return list0;
	}
	
	public static ArrayList<TaxiCms> getList1(){
		return list1;
	}
	
	public static void receive(String id) {
		TaxiCms tc=getTaxiCms(id);
		remove(id);
		list1.add(tc);
	}
	public static void done(String id) {
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getId().equals(id)) {
				list1.remove(i);
				break;
			}
		}
	}
	
	public static TaxiCms getTaxiCms(String id) {
		TaxiCms tc=null;
		for(int i=0;i<list0.size();i++) {
			if(list0.get(i).getId().equals(id)) {
				tc=list0.get(i);
				break;
			}
		}
		return tc;
	}
	
	public static TaxiCms getReceivedTaxiCms(String id) {
		TaxiCms tc=null;
		for(int i=0;i<list1.size();i++) {
			if(list1.get(i).getId().equals(id)) {
				tc=list1.get(i);
				break;
			}
		}
		return tc;
	}
	
	public static String getCode() {
		Date date=new Date();
		int y=date.getYear()+1900;
		int m=date.getMonth()+1;
		int d=date.getDate();
		int random=(int)(1000+Math.random()*9999);
		
		
		String timecode="t"+y+"0"+m+d;
		String cmsId=timecode+random;
		return cmsId;
	}
	
	public static String getCreateTime() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String createTime=sdf.format(date);
		return createTime;
	}
	public static String getCreateDay() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");  
		String createDay=sdf.format(date);
		return createDay;
		
	}
	
	public static void test() {
	    TaxiCms test1=new TaxiCms(TaxiCmsManager.getCode());
	    test1.setRequesterId("123321");
	    test1.setRequesterName("DEMON");
	    test1.setRequesterAvatar("http://localhost:7070/myjulife/images/avatar1.jpeg");
	    test1.setRequesterGender("1");
	    test1.setAim("八佰伴");
	    test1.setTemp("梁林校区东门");
	    test1.setRequesterLongitude(120.72499568982698);
	    test1.setRequesterLatitude(30.739481778562464);
	    test1.setCreateTime(TaxiCmsManager.getCreateTime());
	    test1.setCreateDay(TaxiCmsManager.getCreateDay());
	    test1.setId(TaxiCmsManager.getCode());
	    test1.setNumber(2);
	    TaxiCmsManager.add(test1);
	    
	    TaxiCms test2=new TaxiCms(TaxiCmsManager.getCode());
	    test2.setRequesterId("123321");
	    test2.setRequesterName("DEMON");
	    test2.setRequesterAvatar("http://localhost:7070/myjulife/images/avatar2.jpeg");
	    test2.setRequesterGender("2");
	    test2.setAim("博物馆影城");
	    test2.setTemp("梁林校区东门");
	    test2.setCreateTime(TaxiCmsManager.getCreateTime());
	    test2.setCreateDay(TaxiCmsManager.getCreateDay());
	    test2.setId(TaxiCmsManager.getCode());
	    test2.setNumber(3);
	    TaxiCmsManager.add(test2);
	    
	    TaxiCms test3=new TaxiCms(TaxiCmsManager.getCode());
	    test3.setRequesterId("123321");
	    test3.setRequesterName("DEMON");
	    test3.setRequesterAvatar("http://localhost:7070/myjulife/images/avatar3.jpeg");
	    test3.setRequesterGender("1");
	    test3.setAim("嘉兴学院医学院");
	    test3.setTemp("八佰伴");
	    test3.setCreateTime(TaxiCmsManager.getCreateTime());
	    test3.setCreateDay(TaxiCmsManager.getCreateDay());
	    test3.setId(TaxiCmsManager.getCode());
	    test3.setNumber(1);
	    TaxiCmsManager.add(test3);
	}
	
	
	
}
