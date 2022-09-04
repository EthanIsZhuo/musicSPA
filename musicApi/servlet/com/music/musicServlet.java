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
 * Servlet implementation class musicServlet
 */
@WebServlet("/musicServlet")
public class musicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public musicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String searchKey=request.getParameter("searchKey");
		if(searchKey==null) {
			searchKey="";
		}
		PrintWriter out=response.getWriter();
		dbUtil db=new dbUtil();
		
		PreparedStatement pst;
		ResultSet rs=null;
		System.out.println("关键字"+searchKey);
		try {
		//该sql语句可以实现包含歌手，歌曲名称，类型的模糊查询
			String findMusic="SELECT * FROM musictype INNER JOIN musicinfo ON musictype.`typeId`=musicinfo.`typeId`";
			findMusic+="WHERE typeName LIKE '%' ? '%' OR musicName LIKE '%' ? '%' OR singer LIKE '%' ? '%'";
			pst=db.getConnection().prepareStatement(findMusic);
			pst.setString(1,searchKey);
			pst.setString(2,searchKey);	
			pst.setString(3,searchKey);
			rs=pst.executeQuery();
			List<Music> musicList=new ArrayList<Music>();
			while(rs.next()) {
				Music music=new Music();
				music.musicId=rs.getInt("musicId");
				music.musicName=rs.getString("musicName");
				music.musicType=rs.getString("typeName");
				music.singer=rs.getString("singer");
				music.uploadTime=rs.getString("uploadTime");
				music.musicUrl=rs.getString("musicUrl");
				musicList.add(music);
			}
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(musicList);
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
