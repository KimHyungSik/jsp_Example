package net.type.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Nana extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException 
	{
		int cnt = 5;
		String cnt_ = null;
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		cnt_ = req.getParameter("cnt");
		if(cnt_ != null && !cnt_.equals(""))
			 cnt = Integer.parseInt(req.getParameter("cnt"));
		
		for(int i = 0; i < cnt; i++)
			out.println((i+1) + ":¾È³ç servlet!! <br />");
	}
}


