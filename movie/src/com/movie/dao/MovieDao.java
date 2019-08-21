package com.movie.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.movie.bean.Movie;
import com.movie.bean.Rectab;
import com.movie.bean.Similartab;
import com.movie.util.JdbcUtil;


public class MovieDao {
	public static List<Movie> getdefaulttop() throws SQLException{
		List<Movie> topList=new ArrayList<Movie>();
		String sql="select movie.movieid,movie.moviename,\n" + 
				"movie.showyear,movie.nation,movie.director,\n" + 
				"movie.leadactors,movie.screenwriter,movie.picture,\n" + 
				"movie.averating,movie.numrating,movie.description,\n" + 
				"movie.typelist,movie.backpost from movie.movie,movie.topdefaultmovies where movie.movie.movieid=movie.topdefaultmovies.movieid;";
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		topList = qr.query(sql, new BeanListHandler<Movie>(Movie.class));
		return topList;	
	}
	public static List<Movie> getmovielist(int page) throws SQLException{
		int ideax=page*36;
		List<Movie> movielist=new ArrayList<Movie>();
		String sql="select *from movie order by averating desc limit ?,36";
	    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());  
	    movielist=qr.query(sql, new BeanListHandler<Movie>(Movie.class),ideax);
	    return movielist;
	}
	public static List<Movie> getmovielist(String type,int page) throws SQLException{
		int ideax=page*36;
		List<Movie> movielist=new ArrayList<Movie>();
		String sql="select movie.movieid,movie.moviename,\n" + 
				"movie.showyear,movie.nation,movie.director,\n" + 
				"movie.leadactors,movie.screenwriter,movie.picture,\n" + 
				"movie.averating,movie.numrating,movie.description,\n" + 
				"movie.typelist,movie.backpost from movie,moviecategory "
				+ "where movie.movieid=moviecategory.movieid and moviecategory.categoryid=? order by averating desc limit ?,36";
	    QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());  
	    movielist=qr.query(sql, new BeanListHandler<Movie>(Movie.class),type,ideax);
	    return movielist;
	}
	
    public static List<Movie> getmovielist(String type,String order,int page) throws SQLException{
    	int ideax=page*36;
    	List<Movie> movielist=new ArrayList<Movie>();
    	String sql;
    	if(type.equals("0")) {
    		if(order.equals("showyear")) {
    		sql="select movie.movieid,movie.moviename,movie.showyear,movie.nation,movie.director,movie.leadactors,movie.screenwriter,movie.picture,movie.averating,movie.numrating,movie.description,movie.typelist,movie.backpost from movie,moviecategory where movie.movieid=moviecategory.movieid  order by showyear desc limit ?,36";
    		}
    		else {
    			sql="select movie.movieid,movie.moviename,movie.showyear,movie.nation,movie.director,movie.leadactors,movie.screenwriter,movie.picture,movie.averating,movie.numrating,movie.description,movie.typelist,movie.backpost from movie,moviecategory where movie.movieid=moviecategory.movieid order by averating desc limit ?,36";	
			}
    		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());  
    	    movielist=qr.query(sql, new BeanListHandler<Movie>(Movie.class),ideax);
    	}
    	else{
    		if(order.equals("showyear")) {
    		sql="select movie.movieid,movie.moviename,movie.showyear,movie.nation,movie.director,movie.leadactors,movie.screenwriter,movie.picture,movie.averating,movie.numrating,movie.description,movie.typelist,movie.backpost from movie,moviecategory where movie.movieid=moviecategory.movieid and moviecategory.categoryid=? order by showyear desc limit ?,36";
    		}
    		else {
    			sql="select movie.movieid,movie.moviename,movie.showyear,movie.nation,movie.director,movie.leadactors,movie.screenwriter,movie.picture,movie.averating,movie.numrating,movie.description,movie.typelist,movie.backpost from movie,moviecategory where movie.movieid=moviecategory.movieid and moviecategory.categoryid=? order by averating desc limit ?,36";
    			
    		}
    		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());  
    	    movielist=qr.query(sql, new BeanListHandler<Movie>(Movie.class),type,ideax);
    	}
	    
	    return movielist;
	}
    
	public static List<Movie> getsimlarmovie(String movieid) throws SQLException{
		List<Movie> simlarmovielist=new ArrayList<Movie>();
        String sql="select *from similartab where itemid1=? order by similar desc limit 8";
        List<Similartab> movieList=new ArrayList<Similartab>();
        QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());  
        movieList=qr.query(sql, new BeanListHandler<Similartab>(Similartab.class),movieid);
        for(Similartab s:movieList) {
        	String qrsql="select * from movie where movieid=?";
        	Movie movie=null;
        	movie=qr.query(qrsql, new BeanHandler<Movie>(Movie.class),s.getItemid2());
        	simlarmovielist.add(movie);            
        }
		return simlarmovielist;		
	}
	
	public static List<Movie> usersimilarmovie(String userid) throws SQLException{
		List<Movie> usersimilarlist=new ArrayList<Movie>();
		String sql="select *from rectab where userid=?";
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		Rectab movielist=qr.query(sql, new BeanHandler<Rectab>(Rectab.class),userid);
		if(movielist!=null) {
		String[] itemlist=movielist.getMovieids().split(",");
		for(String mid:itemlist) {
			String qrsql="select * from movie where movieid=?";
        	Movie movie=null;
        	movie=qr.query(qrsql, new BeanHandler<Movie>(Movie.class),mid);
        	usersimilarlist.add(movie);  	
		}}		
		return usersimilarlist;
	}
	
	public static boolean commentdao(int userid,int movieid,String content,double star,String reviewtime) throws SQLException {
		int commentflag=0;
		String sql="insert into movie.review (userid,movieid,content,star,reviewtime) values(?,?,?,?,?)";
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		commentflag=qr.update(sql,userid,movieid,content,star,reviewtime);
		if(commentflag==0) return false;
        else {
			return true;
		}		
	}
	
	public static boolean browsedao(int userid,int movieid,String browsetime) throws SQLException {
		int commentflag=0;
		String sql="insert into movie.browse (userid,movieid,browsetime) values(?,?,?)";
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		commentflag=qr.update(sql,userid,movieid,browsetime);
		if(commentflag==0) return false;
        else {
			return true;
		}		
	}
}
