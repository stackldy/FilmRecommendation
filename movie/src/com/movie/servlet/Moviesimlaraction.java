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
import com.movie.service.MovieService;


public class Moviesimlaraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String movieid=request.getParameter("movieid");
        List<Movie> simlarmovielist=new ArrayList<Movie>();
        List<Movie> similarList=new ArrayList<Movie>();
        simlarmovielist=MovieService.getsimlarmovielist(movieid);
        for (Movie movie : simlarmovielist ) {
			if(movie!=null) similarList.add(movie);
		}
        simlarmovielist=null;
        HttpSession session=request.getSession();
        session.setAttribute("simlarmovielist", similarList);
        response.sendRedirect("moviedetail.jsp");
    } 
    
}
