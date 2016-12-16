package com.muthagroup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.muthagroup.connection.ConnectionModel;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con=ConnectionModel.getConnection();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// TODO Auto-generated method stub
			//System.out.println("name = " + request.getParameter("email"));
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			PrintWriter out = response.getWriter();	
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			String sql = "insert into register(user,pass) values(?,?)";
			System.out.println("sql:"+sql);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,user);
			ps.setString(2, pass);
			int val = ps.executeUpdate();
			if(val>0)
			{
				HttpSession session=request.getSession();  
			     session.setAttribute("user",user);
			     response.sendRedirect("DailyReport");
				 out.println("<div class=\" alert alert-info\" >"+"<strong>Info!</strong> Signup successfully</div>");
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
