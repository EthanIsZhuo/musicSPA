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

/**
 * Servlet implementation class ILoveMusic
 */
@WebServlet("/ILoveMusic")
public class ILoveMusic extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ILoveMusic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/plain;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		// ���vue������������
		String musicId = request.getParameter("musicId");
		String userName=request.getParameter("userName");
		PreparedStatement pst=null;
		ResultSet rs=null;
		int accountId=0;
		dbUtil db = new dbUtil();
		try {
			String findId="select * from userinfo where userName=?";
			pst=db.getConnection().prepareStatement(findId);
			pst.setString(1,userName);
			rs=pst.executeQuery();
			if(rs.next()) {
				accountId=rs.getInt("userId");
			}
			
			String findMusic = "SELECT * FROM mymusic WHERE musicId=? AND accountId=?";
			 pst = db.getConnection().prepareStatement(findMusic);
			pst.setInt(1, Integer.parseInt(musicId));
			pst.setInt(2, accountId);
			 rs = pst.executeQuery();
			if (rs.next()) { //������ڣ������Ѿ��ղؼ�����ȡ���ղأ������ݿ���ɾ��������¼
				String delMyLove="delete from mymusic where musicId=? AND accountId=?";
				pst = db.getConnection().prepareStatement(delMyLove);
				pst.setInt(1, Integer.parseInt(musicId));
				pst.setInt(2, accountId);
				int val = pst.executeUpdate();
				rs.close();pst.close();db.getConnection().close();
				if(val>0) {
					out.print("�Ѿ�Ϊ��ȡ���ղ�");
				}
			} else {//��������ڣ������Ѿ�δ�ղأ������ղأ������ݿ��в���������¼
				String addMyLove="insert into mymusic(musicId,accountId)";
				addMyLove+="values(?,?)";
				pst = db.getConnection().prepareStatement(addMyLove);
				pst.setInt(1, Integer.parseInt(musicId));
				pst.setInt(2, accountId);
				int val = pst.executeUpdate();
				rs.close();pst.close();db.getConnection().close();
				if(val>0) {
				out.print("�ղ�");
				}
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
