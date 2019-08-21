package com.movie.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.movie.service.RegistServer;


public class Registeraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
   @Override
protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	    request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		
		
		String username = request.getParameter("login");
		String password = request.getParameter("pwd");
		String email = request.getParameter("code");
		
		boolean registerflag=RegistServer.register(username, password, email);
		PrintWriter pw = response.getWriter();
		if(registerflag==true) {
			
			String SuccessJson = "{\"url\": \"Ajax/Login\",\"status\": \"200\",\"responseTime\": 50,"
					+"\"responseText\": {\"Status\":\"ok\",\"Text\":\"注册成功<br /><br />恭喜您您   "+username+"\"}}";

			pw.println(SuccessJson);
		
		}else{
			String ErrorJson = "{\"Erro\": \"注册失败\",\"status\": \"200\",\"responseTime\": 50,"+"\"Status\":\"Erro\""
					+",\"responseText\": {\"Status\":\"Erro\",\"Erro\":\"注册失败\"}}";
			pw.println(ErrorJson);
		
		}
		pw.close();
		
		
}
	
	
    
}
