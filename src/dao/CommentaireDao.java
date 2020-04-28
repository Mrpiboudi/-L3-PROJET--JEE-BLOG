package dao;

import model.Commentaire;

public interface CommentaireDao {
	
	public void ajouterCommentaire(Commentaire commentaire);
	public void supprimerCommentaire(Commentaire commentaire);

}
