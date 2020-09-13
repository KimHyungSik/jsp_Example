package net.type.web.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.type.web.entity.Notice;

@WebServlet("/notice/detail")
public class NoticeDetialController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String url = "jdbc:mysql://localhost/learnjsp?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String sql = "SELECT * FROM NOTICE WHERE ID=?";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "learnjsp", "1234");

			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			rs.next();

			String title = rs.getString("TITLE");
			Date reg_date = rs.getDate("reg_data");
			String writer_id = rs.getString("writer_id");
			int hit = rs.getInt("hit");
			String content = rs.getString("content");

			/*
			 * request.setAttribute("title", title); request.setAttribute("reg_date",
			 * reg_date); request.setAttribute("writer_id", writer_id);
			 * request.setAttribute("hit", hit); request.setAttribute("content", content);
			 */
			
			Notice notice = new Notice(
					id,
					title,
					reg_date,
					writer_id,
					hit,
					content);

			request.setAttribute("notice", notice);
			
			rs.close();	
			st.close();
			con.close();
		}catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
		
		request.getRequestDispatcher("/WEB-INF/View/notice/detail2.jsp")
		.forward(request, response);
		
	}
}
