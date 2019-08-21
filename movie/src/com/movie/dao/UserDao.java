package com.movie.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.movie.bean.User;
import com.movie.util.JdbcUtil;

public class UserDao {
	
	public static User logindao(String username,String password) throws SQLException{
		User user=null;
		String sql="select *from user where username=?";
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		user = qr.query(sql, new BeanHandler<User>(User.class),username);		
        return user;		
	}
	
	public static boolean registrdao(String username,String password,String email) throws SQLException {
		int registflag=0;
		String sql="insert into movie.user (username,password,email) values(?,?,?)";
		QueryRunner qr = new QueryRunner(JdbcUtil.getDataSource());
		registflag=qr.update(sql,username,password,email);
		if(registflag==0) return false;
        else {
			return true;
		}		
	}

}
