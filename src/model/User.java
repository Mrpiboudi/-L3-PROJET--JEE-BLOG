package model;

public class User {
	
	private int id;
	private int age;
	private String firstname;
	private String lastname;
	private String genre;
	private String mail;
	private String mdp;
	
	
	public User(String firstname, String lastname, int age, String genre, String mail, String mdp) {
		
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.genre = genre;
		this.mail = mail;
		this.mdp = mdp;
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	

}
