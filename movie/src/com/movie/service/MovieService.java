package com.movie.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.movie.bean.Movie;
import com.movie.dao.MovieDao;

public class MovieService {
	public static List<Movie> getdefaulttop(){
		
		List<Movie> topList=new ArrayList<Movie>();
		try {
			topList = MovieDao.getdefaulttop();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return topList;
	}
	public static List<Movie> getmovielist(String type,String order,int page) {
		  List<Movie> movielist=new ArrayList<Movie>();
		  try {
		  if(type.equals("0")&&order==null) {
				movielist=MovieDao.getmovielist(page);
		  }else {
          if(order==null) {
        	  movielist=MovieDao.getmovielist(type,page);
			
		  }else {
             movielist=MovieDao.getmovielist(type, order,page);			
		  }
          }
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return movielist;
	}
	public static List<Movie> getsimlarmovielist(String movieid) {
		List<Movie> simlarmovielist=new ArrayList<Movie>();
		try {
			simlarmovielist=MovieDao.getsimlarmovie(movieid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return simlarmovielist;
	}
	public static List<Movie> usersimilarmovie(String userid) {
		List<Movie> simlarmovielist=new ArrayList<Movie>();
		try {
			simlarmovielist=MovieDao.usersimilarmovie(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return simlarmovielist;
	}
	

}
