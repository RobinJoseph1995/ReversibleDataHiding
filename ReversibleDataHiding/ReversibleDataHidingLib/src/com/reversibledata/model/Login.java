package com.reversibledata.model;

public class Login {
	private long loginid;
	private String username;
	private String password;
	private String emailid;

	public long getloginid() {
		return this.loginid;
	}

	public void setloginid(long loginid) {
		this.loginid=loginid;
	}

	public String getusername() {
		return this.username;
	}

	public void setusername(String username) {
		this.username=username;
	}

	public String getpassword() {
		return this.password;
	}

	public void setpassword(String password) {
		this.password=password;
	}

	public String getemailid() {
		return this.emailid;
	}

	public void setemailid(String emailid) {
		this.emailid=emailid;
	}

}

