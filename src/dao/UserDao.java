package dao;

import java.util.List;

import model.Post;
import model.User;

public interface UserDao {
	
	public void ajoutUtilisateur(User user);
	
	public void supprimerUtilisateur(User user);
	
	public void updateUtilisateur(User user, String[] parametres);
	
	public List<Post> getAllPosts(int idUser);
	
	public User getUser(String pseudo, String mdp);
	
	public User getUser(int id_user);
}
