package com.movie.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.movie.bean.Category;
import com.movie.util.JdbcUtil;


public class Categoryaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		String page=request.getParameter("page");
		String sql="select * from category";
		List<Category> catelist=new ArrayList<Category>();
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		try {
			catelist=qr.query(sql, new BeanListHandler<Category>(Category.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session=request.getSession();
		session.setAttribute("catelist", catelist);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		if(page==null) {
		response.sendRedirect("Querymovieaction?type=0&page=0");
		}else {
			response.sendRedirect("Querymovieaction?type=0&page=0"+page);	
		}
	}

}
