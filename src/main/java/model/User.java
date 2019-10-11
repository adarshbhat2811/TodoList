package model;

public class User {

	private String username, password;
	private int user_Id;
	
	
	public User(String username, String password, int user_Id) {
		super();
		this.username = username;
		this.password = password;
		this.user_Id = user_Id;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

}
