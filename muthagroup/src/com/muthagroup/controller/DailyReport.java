package com.muthagroup.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.muthagroup.dao.MuthaGroupDAO;
import com.muthagroup.vo.MuthaGroupVO;

@WebServlet("/DailyReport")
public class DailyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MuthaGroupDAO dao=new MuthaGroupDAO();
	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
    public DailyReport() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd",Locale.ENGLISH);
		try { 
		String date=(String)request.getParameter("date");
		if(date==null){
		    Date tempdate=new Date();
		    date=in.format(tempdate);
			}
		/*System.out.println("Parameter:"+date);*/
	    PrintWriter out = response.getWriter();	
		Date utilDate = (Date) in.parse(date);
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		MuthaGroupVO vo=new MuthaGroupVO();
	    vo.setDate(sqlDate);
	    list=dao.getReport(vo);
	    
	     //System.out.println("List retrieve");
	    if(list.isEmpty())
	    {
	    	 out.println("<div class=\" alert alert-info\" >"+"<strong>Info!</strong> Indicates a neutral informative change or action.</div>");
		     response.sendRedirect("mainpage.jsp");
	    }
	    else
	    {
	    	// System.out.println("List ready to mainpage.jsp");
	    	 vo.setList(list);
	    	 //System.out.println("List set to VO");
	    	 request.setAttribute("date",date);
	    	 request.setAttribute("list",vo.getList());
	    	 request.setAttribute("dislist",vo.getDis_list());
	    	 request.setAttribute("stocklist",vo.getStock_list());
	    	 //System.out.println("List set to request attribute ");
		 	 RequestDispatcher view=getServletContext().getRequestDispatcher("/mainpage.jsp");
		 	//System.out.println("request dispatcher created ");
		 	 view.forward(request, response);
		 	//System.out.println("control forward ");
		 	  //System.out.println("List pass on to mainpage.jsp");
	     }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
