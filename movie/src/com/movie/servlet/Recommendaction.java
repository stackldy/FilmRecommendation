package com.movie.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.bean.Movie;
import com.movie.bean.User;
import com.movie.service.MovieService;


public class Recommendaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		List<Movie> usersimilarlist=new ArrayList<Movie>();
		List<Movie> similarList=new ArrayList<Movie>();
		usersimilarlist=MovieService.usersimilarmovie(String.valueOf(user.getUserid()));
        for (Movie movie : usersimilarlist) {
        	if(movie!=null) similarList.add(movie);  
			
		}		
		usersimilarlist=null;
        session.setAttribute("usersimilarlist", similarList);
		response.sendRedirect("recommendlist.jsp");
		
	}
   
}
