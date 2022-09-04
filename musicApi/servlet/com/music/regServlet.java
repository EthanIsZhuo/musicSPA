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

import com.music.dbUtil;



/**
 * Servlet implementation class userServlet
 */
@WebServlet("/regServlet")
public class regServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public regServlet() {
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
		String registerName=request.getParameter("regName");
		String registerPwd=request.getParameter("regPwd");
	
		dbUtil db=new dbUtil();
		
		PreparedStatement pst;
		try {
			//查询数据库中是否存在用户
			
			
			String findUser="select userName from userinfo where userName=?" ;
			 pst=db.getConnection().prepareStatement(findUser);
			pst.setString(1,registerName );
			ResultSet rsUser=pst.executeQuery();
			if(rsUser.next()){
				out.print("该用户已存在");
				return;
			}
			String sql="insert into userinfo(userName,userPwd) ";
			sql+="values(?,?)";
			pst=db.getConnection().prepareStatement(sql);
			pst.setString(1,registerName );
			pst.setString(2,registerPwd );
		
			int val=pst.executeUpdate();
			if(val>0){
				out.print("注册成功");
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
