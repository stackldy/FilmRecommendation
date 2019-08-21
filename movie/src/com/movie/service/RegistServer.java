package com.movie.service;

import java.sql.SQLException;

import com.movie.dao.UserDao;

public class RegistServer {
	public static boolean register(String username,String password,String email) {
		boolean flag=false;
		try {
			flag=UserDao.registrdao(username, password, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

}
