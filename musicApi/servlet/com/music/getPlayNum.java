package com.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getPlayNum
 */
@WebServlet("/getPlayNum")
public class getPlayNum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getPlayNum() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		String userName=request.getParameter("userName");
		PrintWriter out=response.getWriter();
		if(userName==null) {return;}
		//UPDATE userinfo SET playNum=playNum+1 WHERE userId=1
		dbUtil db=new dbUtil();
		int playNum=0;
		try {
			
			
			String findPlayNum="select * from userinfo where userName=?";
			PreparedStatement pst=db.getConnection().prepareStatement(findPlayNum);
			pst.setString(1, userName);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				playNum=rs.getInt("playNum");
				out.print(playNum);
			}
				
			pst.close();db.getConnection().close();
				
		
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
