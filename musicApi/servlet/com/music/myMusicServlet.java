package com.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class myMusicServlet
 */
@WebServlet("/myMusicServlet")
public class myMusicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myMusicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//SELECT * FROM musicinfo INNER JOIN mymusic ON mymusic.`musicId`=musicinfo.`musicId` INNER JOIN musictype ON musictype.`typeId`=musicinfo.`typeId` WHERE accountid='1'
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		if(userName==null) {
			return;
		}
		PrintWriter out=response.getWriter();
		dbUtil db=new dbUtil();
		PreparedStatement pst;
		ResultSet rs=null;
		int accountId=0;
	
		try {
		//该sql语句可以实现吗包含歌手，歌曲名称，类型的模糊查询
			String findId="select * from userinfo where userName=?";
			pst=db.getConnection().prepareStatement(findId);
			pst.setString(1,userName);
			rs=pst.executeQuery();
			if(rs.next()) {
				accountId=rs.getInt("userId");
			}
			
			String findmyMusic="SELECT * FROM musicinfo INNER JOIN mymusic ON mymusic.`musicId`=musicinfo.`musicId` INNER JOIN musictype ON musictype.`typeId`=musicinfo.`typeId` WHERE accountid=?";
			
			pst=db.getConnection().prepareStatement(findmyMusic);
			pst.setInt(1,accountId);
			rs=pst.executeQuery();
			List<Music> myMusic=new ArrayList<Music>();
			while(rs.next()) {
				Music music=new Music();
				music.musicId=rs.getInt("musicId");
				music.musicName=rs.getString("musicName");
				music.musicType=rs.getString("typeName");
				music.singer=rs.getString("singer");
				music.uploadTime=rs.getString("uploadTime");
				music.musicUrl=rs.getString("musicUrl");
				myMusic.add(music);
			}
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(myMusic);
			out.print(json); 
 		} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
