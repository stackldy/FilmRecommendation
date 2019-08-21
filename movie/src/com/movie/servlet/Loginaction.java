package com.movie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movie.bean.User;
import com.movie.service.LoginService;


public class Loginaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
		String username=request.getParameter("login");
		String password=request.getParameter("pwd");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		User user=LoginService.LoginService(username, password);
		HttpSession session=request.getSession();
		
		PrintWriter pw = response.getWriter();
		if(user != null) {
			session.setAttribute("user", user);
			String SuccessJson = "{\"url\": \"Ajax/Login\",\"status\": \"200\",\"responseTime\": 50,"
					+"\"responseText\": {\"Status\":\"ok\",\"Text\":\"登陆成功<br /><br />欢迎您   "+username+"\"}}";

			pw.println(SuccessJson);
		
		}else{
			String ErrorJson = "{\"Erro\": \"账号名或密码有误\",\"status\": \"200\",\"responseTime\": 50,"+"\"Status\":\"Erro\""
					+",\"responseText\": {\"Status\":\"Erro\",\"Erro\":\"账号名或密码有误\"}}";
			pw.println(ErrorJson);
		
		}
		pw.close();
	
		
	};
}
