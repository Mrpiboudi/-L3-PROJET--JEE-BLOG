package model;

import java.util.Date;

public class Commentaire {
	
	private int id;
	private int idPost;
	private int idUser;
	private String msg;
	private Date date;
	
	public Commentaire(int idPost, int idUser, String msg, Date date) {
		this.idPost = idPost;
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
	public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int idPost) {
		this.idPost = idPost;
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
