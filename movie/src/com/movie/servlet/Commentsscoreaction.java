package com.movie.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.bean.Movie;
import com.movie.bean.User;
import com.movie.dao.MovieDao;

/**
 * Servlet implementation class Commentsscoreaction
 */
public class Commentsscoreaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		double star=Double.valueOf(request.getParameter("starLevel"));
		String content=request.getParameter("customerEvaluationComment");
		HttpSession session=request.getSession();
		Movie movie=(Movie)session.getAttribute("moviedetail");
		User user=(User)session.getAttribute("user");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String reviewtime=df.format(new Date());
		try {
			boolean commentflag=MovieDao.commentdao(user.getUserid(), movie.getMovieid(), content, star,reviewtime);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("Moviedetailaction?movieid="+movie.getMovieid());
		
	}

}
