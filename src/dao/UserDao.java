package dao;

import model.User;

public interface UserDao {
	
	public void ajoutUtilisateur(User user);
	public void supprimerUtilisateur(User user);
	public void updateUtilisateur(User user, String[] parametres);

}
