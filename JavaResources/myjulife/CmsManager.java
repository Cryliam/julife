package myjulife;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CmsManager {
private static ArrayList<Commission> cmsList=new ArrayList<>();
	
	
	
	public CmsManager() {
		
	}
	
	public static void addCms(Commission c) {
		cmsList.add(c);
	}
	
	public static void removeCms(String id) {
		for(int i=0;i<cmsList.size();i++) {
			if(cmsList.get(i).getId().equals(id)) {
				cmsList.remove(i);
			}
		}
	}
	
	public static Commission getCms(String id) {
		Commission cms=null;
		for(int i=0;i<cmsList.size();i++) {
			if(cmsList.get(i).getId().equals(id)) {
				cms=cmsList.get(i);
			}
		}
		
		return cms;
	}
	
	public static ArrayList<Commission> getList(){
		return cmsList;
	}
	
	public static int getNumberOfCms() {
		return cmsList.size();
	}
	
	
	public static String getCode() {
		Date date=new Date();
		int y=date.getYear()+1900;
		int m=date.getMonth()+1;
		int d=date.getDate();
		int random=(int)(1000+Math.random()*9999);
		
		
		String timecode=""+y+"0"+m+d;
		String cmsId=timecode+random;
		return cmsId;
	}
	
	public static String getCreateTime() {
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String createTime=sdf.format(date);
		return createTime;
	}

}
