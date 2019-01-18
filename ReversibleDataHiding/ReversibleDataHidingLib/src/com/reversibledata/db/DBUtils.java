package com.reversibledata.db;

import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;
import com.reversibledata.model.*;


public class DBUtils {
	public static final String url="jdbc:mysql://localhost:3306/reversibledata?user=root&password=mysql";
	public static Connection con=null;

	public static boolean connect() throws Exception {
		if(con==null || con.isClosed()){
			Class.forName(com.mysql.jdbc.Driver.class.getCanonicalName());
			con = DriverManager.getConnection(url);
			if(con!=null && !con.isClosed()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public static List<Image> getImages() throws Exception {
		final List<Image> images = new ArrayList<Image>();
		final String sql = "select * from images";

		final Statement stmt = con.createStatement();
		final ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()){
			Image image = new Image();
			image.setimageid(rs.getLong("imageid"));
			image.setloginid(rs.getLong("loginid"));
			image.setimagefile(rs.getString("imagefile"));
			image.setimagetype(rs.getString("imagetype"));
			images.add(image);
		}
		return images;
	}

	public static boolean addImage(Image image) throws Exception {
		final String sql = "INSERT INTO images (loginid,imagefile,imagetype) VALUES("+image.getloginid()+",'"+image.getimagefile()+"','"+image.getimagetype()+"')";
		final Statement stmt = con.createStatement();
		if(stmt.executeUpdate(sql)>0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean removeImage(Image image) throws Exception {
		final String sql = "DELETE FROM images WHERE imageid="+image.getimageid();
		final Statement stmt = con.createStatement();
		if(stmt.executeUpdate(sql)>0) {
			return true;
		} else { 
			return false;
		}
	}

	public static List<Login> getLogins() throws Exception {
		final List<Login> logins = new ArrayList<Login>();
		final String sql = "select * from login";

		final Statement stmt = con.createStatement();
		final ResultSet rs = stmt.executeQuery(sql);

		while(rs.next()){
			Login login = new Login();
			login.setloginid(rs.getLong("loginid"));
			login.setusername(rs.getString("username"));
			login.setpassword(rs.getString("password"));
			login.setemailid(rs.getString("emailid"));
			logins.add(login);
		}
		return logins;
	}

	public static boolean addLogin(Login login) throws Exception {
		final String sql = "INSERT INTO login (username,password,emailid) VALUES('"+login.getusername()+"','"+login.getpassword()+"','"+login.getemailid()+"')";
		final Statement stmt = con.createStatement();
		if(stmt.executeUpdate(sql)>0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean removeLogin(Login login) throws Exception {
		final String sql = "DELETE FROM login WHERE loginid="+login.getloginid();
		final Statement stmt = con.createStatement();
		if(stmt.executeUpdate(sql)>0) {
			return true;
		} else { 
			return false;
		}
	}

}

