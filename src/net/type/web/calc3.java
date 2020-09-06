package net.type.web;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc3")
public class calc3 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");

		Cookie[] cookies = req.getCookies();

		String v_ = req.getParameter("value");
		String op = req.getParameter("operator");
		String dot = req.getParameter("dot");

		String exp = "";
		if (cookies != null) {
			for (Cookie c : cookies)
				if (c.getName().equals("exp")) {
					exp = c.getValue();
					break;
				}
		}

		if (op != null && op.equals("=")) {
			ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
			try {
				exp = String.valueOf(engine.eval(exp));
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		} else if (op != null && op.equals("C")) {
			exp = "";
		} else {
			exp += (v_ == null) ? "" : v_;
			exp += (op == null) ? "" : op;
			exp += (dot == null) ? "" : dot;
		}

		Cookie expCookie = new Cookie("exp", exp);
		if (op != null && op.equals("C")) {
			expCookie.setMaxAge(0);
		}

		resp.addCookie(expCookie);
		resp.sendRedirect("calcpage");
	}
}
