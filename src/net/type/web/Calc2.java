package net.type.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
<<<<<<< HEAD
import javax.servlet.http.Cookie;
=======
>>>>>>> bf5463cd94b52733cc2876cbfa1d1c8542002239
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
<<<<<<< HEAD

		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();

		Cookie[] cookies = req.getCookies();

=======
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();

>>>>>>> bf5463cd94b52733cc2876cbfa1d1c8542002239
		PrintWriter out = resp.getWriter();

		int v = 0;

		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
<<<<<<< HEAD

		if (!v_.equals(""))
			v = Integer.parseInt(v_);

		if (op.equals("=")) {
			int result = 0;
			// int x = (Integer)application.getAttribute("value");
			// int x = (Integer)session.getAttribute("value");
			int x = 0;
			for (Cookie c : cookies)
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}

			int y = v;

			// String operator = (String)application.getAttribute("op");
			String operator = "";
			for (Cookie c : cookies)
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}

			if (operator.contentEquals("+"))
=======
		
		if(!v_.equals("")) v = Integer.parseInt(v_);

		if (op.equals("=")) {
			int result = 0;
			//int x = (Integer)application.getAttribute("value");
			int x = (Integer)session.getAttribute("value");
			int y = v;
			
			//String operator = (String)application.getAttribute("op");
			String operator = (String)session.getAttribute("op");
			
			if(operator.contentEquals("+"))
>>>>>>> bf5463cd94b52733cc2876cbfa1d1c8542002239
				result = x + y;
			else
				result = x - y;
			out.printf("result is : %d", result);
<<<<<<< HEAD

		} else {
			// application.setAttribute("value", v);
			// application.setAttribute("op", op);

			// session.setAttribute("value", v);
			// session.setAttribute("op", op);

			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			valueCookie.setPath("/");
			valueCookie.setMaxAge(24*60*60);
			opCookie.setPath("/");
			
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
		
			resp.sendRedirect("Calc2.html");
=======
			
		} else {
			//application.setAttribute("value", v);
			//application.setAttribute("op", op);
			
			session.setAttribute("value", v);
			session.setAttribute("op", op);
>>>>>>> bf5463cd94b52733cc2876cbfa1d1c8542002239
		}

	}
}
