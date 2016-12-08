package com.muthagroup.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.muthagroup.connection.ConnectionModel;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  Connection con=ConnectionModel.getConnection();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			//System.out.println("name = " + request.getParameter("email"));
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			String sql = "select * from register where user='"+user+"' and pass='"+pass+"'";
			//System.out.println("sql:"+sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				 HttpSession session=request.getSession();  
			     session.setAttribute("user",user);
			 	 response.sendRedirect("DailyReport");
			 	
			}
			else {
				response.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
