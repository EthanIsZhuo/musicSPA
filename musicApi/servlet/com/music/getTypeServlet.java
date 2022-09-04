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
 * Servlet implementation class getTypeServlet
 */
@WebServlet("/getTypeServlet")
public class getTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTypeServlet() {
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
		dbUtil db=new dbUtil();
		
		PreparedStatement pst;

		 try {
				String findType="select * from musictype";
				pst=db.getConnection().prepareStatement(findType);
				pst.executeQuery();
				ResultSet rsType=pst.executeQuery();
				List<MusicType> types=new ArrayList();
				while(rsType.next()) {
					MusicType musictype=new MusicType();
					musictype.typeId=rsType.getInt("typeId");
					musictype.typeName=rsType.getString("typeName");
					types.add(musictype);
				}
				ObjectMapper om=new ObjectMapper();

				
				String json=om.writeValueAsString(types);
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
