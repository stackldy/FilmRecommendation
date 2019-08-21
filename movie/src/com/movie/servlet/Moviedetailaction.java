package com.movie.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.movie.bean.Movie;
import com.movie.util.JdbcUtil;


public class Moviedetailaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String movieid=request.getParameter("movieid");
		Movie moviedetail=new Movie();
		String sql="select * from movie where movieid=?";
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	    try {
			moviedetail=qr.query(sql,new BeanHandler<Movie>(Movie.class),movieid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    HttpSession session=request.getSession();
	    session.setAttribute("moviedetail", moviedetail);
	    response.sendRedirect("Moviesimlaraction?movieid="+movieid);
	}
   
}
