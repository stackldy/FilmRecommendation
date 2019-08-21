package com.movie.service;

import java.sql.SQLException;

import com.movie.bean.User;
import com.movie.dao.UserDao;;


public class LoginService {
	
	public static User LoginService(String username,String password) {
		User user=null;
        try {
		 user=UserDao.logindao(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       return user;
	}

}
