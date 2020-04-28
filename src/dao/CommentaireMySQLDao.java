package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import db.DBConnection;
import model.Commentaire;

public class CommentaireMySQLDao implements CommentaireDao{

	@Override
	public void ajouterCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		//Requete d'ajout de commentaire
		String requete = "INSERT INTO commentaire (id_post, id_user, message, date) VALUES (?,?,?,?)";

		//Connexion base de donnees
		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {

			//Preparation de la requete
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setInt(1, commentaire.getIdPost());
			preparedStatement.setInt(2, commentaire.getIdUser());
			preparedStatement.setString(3, commentaire.getMsg());
			preparedStatement.setTimestamp(4, (Timestamp) commentaire.getDate());

			//Execution
			preparedStatement.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}


	}

	@Override
	public void supprimerCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub

		//requete pour supprimer un post
		String requete = "DELETE FROM commentaire WHERE id_comm = ?";

		//Connexion à la base de données
		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {
			//Preparation de la requete
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setInt(1, commentaire.getId());

			//Execution de la requete
			preparedStatement.executeUpdate();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}


	}

}
