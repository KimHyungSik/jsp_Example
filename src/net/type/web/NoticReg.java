package net.type.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/notice-reg")
public class NoticReg extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
//		req.setCharacterEncoding("UTF-8");
		
		String title = null;
		String content = null;

		PrintWriter out = resp.getWriter();

		title = req.getParameter("title") + "\n";
		content = req.getParameter("content");
		
		if(title != null && content != null) {
			out.print(title);
			out.print(content);
		}
	}
}
