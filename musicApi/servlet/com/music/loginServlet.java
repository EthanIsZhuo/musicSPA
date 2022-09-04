package com.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.music.dbUtil;



/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
		PrintWriter out=response.getWriter();
		// 获得vue传过来的数据
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		dbUtil db = new dbUtil();
		try {
			
			Statement st = db.getConnection().createStatement();
			String findUser = "select * from userinfo where userName=?";
			PreparedStatement pst = db.getConnection().prepareStatement(findUser);
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
		
			if (rs.next()) { // 存在此用户名
				
				if (userName.equals(rs.getString("userName")) && userPwd.equals(rs.getString("userPwd"))) {// 找到用户名和密码对应上的用户即密码正确
					int userId = rs.getInt("userId");
					rs.close();
					pst.close();
					db.closeConn(db.getConnection());
					HttpSession session = request.getSession();
					session.setAttribute("userName", userName);
					session.setAttribute("userId", userId);
					out.print("Yes");
					
					
					 
					return;
					
				} else {
					rs.close();
					pst.close();
					db.closeConn(db.getConnection());
					out.print("用户名或者密码错误");
					return;
				}

			} else { // 不存在此用户名
				rs.close();
				pst.close();
				db.closeConn(db.getConnection());
	
				out.print("用户名错误或不存在！");
				return;
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
