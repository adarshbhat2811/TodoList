package DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.User;
import model.UserMapper;

public class UserDAO {

	 @Autowired
	    private JdbcTemplate jdbcTemplate;

	
	    public User authenticateUser(String username, String password) {
	        List<User> users =  jdbcTemplate.query(
	                "SELECT * FROM User WHERE username = ? AND password = ?", new UserMapper(),
				new Object[] { username, password });
	        if(users.size() == 0)
	        	return null;
	        return users.get(0);
	    }

	  

	}
