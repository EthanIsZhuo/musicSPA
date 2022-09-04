package com.music;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil {
	String url="jdbc:mysql://localhost:3306/music"
			+"?user=root&password=123456"
			+"&characterEncoding=utf-8"
			+"&serverTimezone=Asia/Shanghai";

			public Connection getConnection() throws SQLException{
				Connection conn=DriverManager.getConnection(url);	
				return conn;
				
			}
			public void closeConn(Connection conn) throws SQLException{
				if(conn!=null){
					conn.close();
				}
			}
}
