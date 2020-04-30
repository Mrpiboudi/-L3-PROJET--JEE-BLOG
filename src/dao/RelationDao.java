package dao;

import java.util.List;

import model.Relation;
import model.User;

public interface RelationDao {
	
	public void ajouterRelation(Relation r);
	public void supprimerRelation(Relation r);
	
	public List<User> getAllFriends(int idUser);
	
	public boolean relationExist(int idUser, int idUser2);

}
