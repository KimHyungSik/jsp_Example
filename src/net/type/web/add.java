package net.type.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")
public class add extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		int x = 0;
		int y = 0;
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
	
		if(!x_.contentEquals("")) x = Integer.parseInt(x_);
		if(!y_.contentEquals("")) y = Integer.parseInt(y_);
	
		int result = x + y;
		
		out.printf("result is : %d", result);
	}
}
