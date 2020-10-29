package com.nine.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBHelper {
	//封装jdbc
	static{
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取连接
	public Connection getConnection(){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl" , "scott" , "a");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public  int doUpdate(String sql , Object... params){
		//返回值
		int result = -1;
		
		try {
			//获取连接
			Connection conn = getConnection();
			//创建预处理
			PreparedStatement ps = conn.prepareStatement(sql);
			//注入参数
			doParams(ps , params);
			//执行
			result = ps.executeUpdate();
			//关闭
			closeAll(conn , ps , null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//查询另外封装
	public List< Map<String,Object> >  findAll(String sql , Object... params){
		
		List< Map< String , Object >> list = new ArrayList< Map< String , Object >>();
		
		
		try {
			//获取连接
			Connection conn = getConnection();
			//创建预处理
			PreparedStatement ps = conn.prepareStatement(sql);
			//注入参数
			doParams(ps,params);
			//执行
			ResultSet rs = ps.executeQuery();
			//得到列名作为键值
			ResultSetMetaData rsmd = rs.getMetaData();
			String[] columnName = new String[rsmd.getColumnCount()];
			for(int i = 0; i < columnName.length; i++){
				columnName[i] = rsmd.getColumnName(i+1);
				
			}
			while( rs.next() ){
				Map<String , Object> map = new HashMap<String , Object>();
				//循环数组，根据列名取值
				for(int i = 0; i < columnName.length; i++){
					if( rs.getString(columnName[i]) == null ){
						map.put(columnName[i].toLowerCase() , rs.getBytes( columnName[i] ));
					}else{
						map.put(columnName[i].toLowerCase() , rs.getObject( columnName[i] ));
				}
				}
				//一列数据添加完成
				list.add(map);
			}
		    //关闭连接
			closeAll(conn , ps , null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	//注入参数的方法
	private void doParams(PreparedStatement ps, Object... params) {
		//容错处理
		if(ps != null && params != null && params.length > 0){
			//开始循环
			for(int i = 0; i < params.length; i++){
				try {
					ps.setObject(i+1,params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//关闭连接的方法
	public void closeAll(Connection conn , PreparedStatement ps , ResultSet rs){
		
		
			try {
				if( rs != null){
					rs.close();
				}
				if( ps != null){
					ps.close();
				}
				if( conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}
