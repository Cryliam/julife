package myjulife;

import java.util.ArrayList;

public class NoticeManager {
	public static ArrayList<Notice> list=new ArrayList<>();
	
	public NoticeManager() {
		
	}
	
	public static void add(Notice notice) {
		list.add(notice);
	}
	public static void remove(String id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
				break;
			}
		}
	}
	public static Notice get(String id) {
		Notice notice=null;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId().equals(id)) {
				notice=list.get(i);
				break;
			}
		}
		return notice;
	}
	
	
	public static void test() {
		Notice n1=new Notice();
		n1.setTitle("饭卡");
		n1.setAddr("老食堂2楼");
		n1.setCreaterId("123");
		n1.setCreaterName("DEMON");
		n1.setCreaterAvatar("http://localhost:7070/myjulife/images/avatar1.jpeg");
		n1.setType(0);
		
		Notice n2=new Notice();
		n2.setTitle("索尼耳机");
		n2.setAddr("14号楼5楼教室");
		n2.setCreaterId("123");
		n2.setCreaterName("阿尔萨斯");
		n2.setCreaterAvatar("http://localhost:7070/myjulife/images/avatar2.jpeg");
		n2.setType(1);
		list.add(n1);
		list.add(n2);
	}
}
