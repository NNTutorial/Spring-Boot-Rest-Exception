package com.nntutorial.SpringBootRestExample;

public class User {
	private int id;
	private String username;
	private String usercompanyname;
	
	
	public User() {
	}
	
	public User(int id, String username, String usercompanyname) {
		this.id = id;
		this.username = username;
		this.usercompanyname = usercompanyname;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsercompanyname() {
		return usercompanyname;
	}
	public void setUsercompanyname(String usercompanyname) {
		this.usercompanyname = usercompanyname;
	}


}
