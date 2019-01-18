package com.reversibledata.model;

public class Image {
	private long imageid;
	private long loginid;
	private String imagefile;
	private String imagetype;

	public long getimageid() {
		return this.imageid;
	}

	public void setimageid(long imageid) {
		this.imageid=imageid;
	}

	public long getloginid() {
		return this.loginid;
	}

	public void setloginid(long loginid) {
		this.loginid=loginid;
	}

	public String getimagefile() {
		return this.imagefile;
	}

	public void setimagefile(String imagefile) {
		this.imagefile=imagefile;
	}

	public String getimagetype() {
		return this.imagetype;
	}

	public void setimagetype(String imagetype) {
		this.imagetype=imagetype;
	}

}

