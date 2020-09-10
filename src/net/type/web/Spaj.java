package net.type.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/spag")
public class Spaj extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		String model;
		int num = 0;
		String[] names = {"newlec", "dragon"};
		
		Map<String, Object> notice = new HashMap<String, Object>();
		
		String num_ = request.getParameter("n");
		
		
		if(num_ != null && !num_.equals(""))
			num = Integer.parseInt(num_);
		if (num % 2 != 0)
			model = "È¦¼ö";
		else 
			model = "Â¦¼ö";
		
		notice.put("id", 1);
		notice.put("title", "Hello");
		
		request.setAttribute("model", model);
		request.setAttribute("names", names);
		request.setAttribute("notice", notice);
		
		RequestDispatcher dispatcher =  
					request.getRequestDispatcher("spag.jsp");
		
		dispatcher.forward(request, resp);
	}
}
