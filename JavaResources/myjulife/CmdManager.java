package myjulife;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CmdManager {
	//存储列表的列表，存储对象为不同分类的商品列表
			private static ArrayList<ArrayList<Commodity>> list=new ArrayList<>();
			
			
			//构造，查询。
			public static void start() {
				createList();
				search();
			}
			
			private static void createList() {
				list.add(null);
				for(int i=1;i<=6;i++) {
					ArrayList<Commodity> temp=new ArrayList<Commodity>();
					list.add(temp);
				}
			}
			
			//根据分类（tag）查询数据库，将不同分类的商品放到对应列表
			private static void search() {
				String dbDriver="com.mysql.jdbc.Driver";
				String url="jdbc:mysql://localhost:3306/JURunner";
				try {
					Class.forName(dbDriver);
					Connection con=DriverManager.getConnection(url,"root","63005730");
					String sql="select id,name from shops where tag=?";
					PreparedStatement state=con.prepareStatement(sql);
					
					for(int i=1;i<=6;i++) {
						state.setInt(1, i);
						ResultSet res=state.executeQuery();
						while(res.next()) {
							String id=res.getString(1);
							String name=res.getString(2);
							Commodity cmd=new Commodity(id,name);
							list.get(i).add(cmd);	
						}
					}
					con.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			//tag既是商品的分类，也是对应列表在总list中的位置。
			public static ArrayList<Commodity> getCmdList(int tag){
				return list.get(tag);
			}
			

			public static Commodity getCmd(String id,int tag) {
				Commodity cmd=null;
				for(int i=0;i<list.get(tag).size();i++) {
					if(list.get(tag).get(i).getId().equals(id)) {
						cmd=list.get(tag).get(i);
					}
				}
				return cmd;
			}
			
			public static Commodity getCmd(String id) {
				Commodity cmd=null;
				int tag=Integer.parseInt(id.charAt(0)+"");
				for(int i=0;i<list.get(tag).size();i++) {
					if(list.get(tag).get(i).getId().equals(id)) {
						cmd=list.get(tag).get(i);
					}
				}
				return cmd;
			}
			
			public static String getCmdName(String id) {
				Commodity cmd=null;
				int tag=Integer.parseInt(id.charAt(0)+"");
				for(int i=0;i<list.get(tag).size();i++) {
					if(list.get(tag).get(i).getId().equals(id)) {
						cmd=list.get(tag).get(i);
					}
				}
				return cmd.getName();
			}
			
			
			
}
