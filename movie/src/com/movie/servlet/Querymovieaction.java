package com.movie.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.bean.Movie;
import com.movie.service.MovieService;

public class Querymovieaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String[] categorys= {"全部","动作", "冒险", "动漫", "儿童", "喜剧", "犯罪", "记录", "戏剧", "幻想", "黑色", "恐怖", "音乐", "神秘", "浪漫", "科幻", "惊悚 ","战争", "西方", "家庭", "其他"};
		String order = request.getParameter("order");
		String type  = request.getParameter("type");
		String page = request.getParameter("page");		
		List<Integer> pagelist=new ArrayList<Integer>();
		Integer pageint=Integer.valueOf(page);
		List<Movie> movielist=MovieService.getmovielist(type, order,pageint);
		HttpSession session=request.getSession();
		session.setAttribute("sortOrder", order);
		session.setAttribute("sortType", type);
		session.setAttribute("category", categorys[Integer.valueOf(type)]);
		session.setAttribute("movielist", movielist);
		if(pageint==100) {
			for(int i=100-5;i<100;i++) {
				pagelist.add(i);
			}
		}else {
	    for(int i=1;i<5;i++) {
	    	pagelist.add(pageint+i);
	    }
	    }
		if(pageint==0) {
		session.setAttribute("prepage", 0);}
		else {
			session.setAttribute("prepage",pageint-1);
		}
		if(pageint!=100) {
			session.setAttribute("lastpage",pageint+1);
			}else {
			session.setAttribute("lastpage",100 );
		}
			
		session.setAttribute("page", pageint);
		session.setAttribute("pagelist", pagelist);		
    	response.sendRedirect("movielist.jsp");
    	
    }
}
