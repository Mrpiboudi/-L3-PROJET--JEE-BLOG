package model;

import java.util.Date;

public class Post {
	
	private int id;
	private int idUser;
	private String msg;
	private Date date;
	
	
	public Post(int idUser, String msg, Date date) {
		
		this.idUser = idUser;
		this.msg = msg;
		this.date = date;
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
