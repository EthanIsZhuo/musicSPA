package com.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/**
 * Servlet implementation class UploadMusic
 */
@WebServlet("/uploadMusic")
@MultipartConfig
public class uploadMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadMusic() {
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
		PrintWriter out=response.getWriter();
		String musicName=request.getParameter("musicName");
		String singer=request.getParameter("singer");
		String typeName=request.getParameter("type");
		String userName=request.getParameter("userName");
		
		String fname = "";
		Part part = request.getPart("file");
		String Path = request.getServletContext().getRealPath("/");
		long len = part.getSize(); // 大小，如果为0不需要去读取
		if (len != 0) {
		
			String s=part.getHeader("Content-Disposition");
			int pos=s.lastIndexOf(".");
			String ext="";
			if(pos>0) {
				 ext=s.substring(pos, s.length()-1);
			}
					
			 fname= System.currentTimeMillis()+ext;

			part.write(Path + "\\Music\\" + fname);// 保存文件
		}
		dbUtil db = new dbUtil();
		try {
			//查询音乐类型
			String findId="select * from musictype where typeName=?";
			PreparedStatement pst=db.getConnection().prepareStatement(findId);
			pst.setString(1,typeName);
			ResultSet rs=pst.executeQuery();
			int typeId = 0;
			if(rs.next()) {
				typeId=rs.getInt("typeId");
			}
			pst.close();
			//查询上传歌曲用户的id
			String finduserId="select * from userInfo where userName=?";
			 pst=db.getConnection().prepareStatement(finduserId);
			pst.setString(1,userName);
			 rs=pst.executeQuery();
			int userId = 0;
			if(rs.next()) {
				userId=rs.getInt("userId");
			}
		
			//获得当前上传时间
			Date date=new Date();
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String uploadTime=format.format(date);
		String uploadMusic="insert into musicinfo(musicName,singer,musicUrl,uploadTime,typeId,userId)";
		uploadMusic+=" values(?,?,?,?,?,?)";
		pst=db.getConnection().prepareStatement(uploadMusic);
		pst.setString(1, musicName);
		pst.setString(2, singer);
		pst.setString(3, fname);
		pst.setString(4, uploadTime);
		pst.setInt(5, typeId);
		pst.setInt(6, userId);
		int val=pst.executeUpdate();
		pst.close();
		db.getConnection().close();
		if(val>0) {			
		out.print("上传成功！");
		}
		
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
