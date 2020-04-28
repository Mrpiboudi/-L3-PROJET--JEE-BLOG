package dao;

import model.Post;

import java.util.List;

import model.Commentaire;

public interface PostDao {
	
	public void ajouterPost(Post post);
	public void supprimerPost(Post post);
	
	public List<Commentaire> getAllComments(int idPost);

}
