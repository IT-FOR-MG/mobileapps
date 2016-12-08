package com.sample;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
 
@WebServlet("/Trigger")
public class Trigger extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Timer timer = new Timer();
			// 09:20
			TimerTask timersave = new OpenTimer();
			timer.schedule(timersave, 1000, 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
