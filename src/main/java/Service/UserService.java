package Service;

import org.springframework.beans.factory.annotation.Autowired;

import DAO.UserDAO;
import model.User;

public class UserService {
	@Autowired
	private UserDAO userDAO;

	public User authenticateUser(String username, String password) {
		return userDAO.authenticateUser(username, password);
	}
}
