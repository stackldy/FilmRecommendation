package com.movie.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.bean.Movie;
import com.movie.service.MovieService;


public class Movieaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
    	List<Movie> topList=MovieService.getdefaulttop();
    	HttpSession session=request.getSession();
    	session.setAttribute("toplist", topList);
    	response.sendRedirect("index.jsp");
    	
    }
}
