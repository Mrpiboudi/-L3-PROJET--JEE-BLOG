package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import model.Post;
import model.User;

public class UserMySQLDao implements UserDao{

	@Override
	public void ajoutUtilisateur(User user) {
		// TODO Auto-generated method stub
		
		//Requete pour inserer un nouvel utilisateur
		String requete = "INSERT INTO user (pseudo,nom,prenom,age,mdp,email,genre) VALUES (?,?,?,?,?,?,?)";

		//Connexion à la base de données
		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement;

		try {
			//Preparation de la requete
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, user.getPseudo());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getFirstname());
			preparedStatement.setInt(4, user.getAge());
			preparedStatement.setString(5, user.getMdp());
			preparedStatement.setString(6, user.getMail());
			preparedStatement.setString(7, user.getGenre());

			//Execution de la requete
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();

		} catch(SQLException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void supprimerUtilisateur(User user) {
		// TODO Auto-generated method stub
		//requete pour supprimer un utilisateur
		String requete = "DELETE FROM user WHERE id_user = ?";

		//Connexion à la base de données
		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {
			//Preparation de la requete
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setInt(1, user.getId());

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

	@Override
	public void updateUtilisateur(User user, String[] parametres) {
		// TODO Auto-generated method stub

		//requete pour modifier un utilisateur 
		String requete = "UPDATE user Set "
				+ "pseudo = ?, nom = ?, prenom = ?, age = ?, mdp = ?, email = ?, genre = ? "
				+ "WHERE id = ?";

		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {

			//Preparation de la requete
			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, parametres[0]);
			preparedStatement.setString(2, parametres[1]);
			preparedStatement.setString(3, parametres[2]);
			preparedStatement.setInt(4, Integer.parseInt((parametres[3])));
			preparedStatement.setString(5, parametres[4]);
			preparedStatement.setString(6, parametres[5]);
			preparedStatement.setString(7, parametres[6]);
			preparedStatement.setInt(8, user.getId());

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

	@Override
	public List<Post> getAllPosts(int idUser) {
		// TODO Auto-generated method stub

		//Liste des posts de l'utilisateur
		List<Post> postsUser = new ArrayList<Post>();

		//Requete
		String requete = "SELECT * FROM post WHERE id_user = '"+idUser+"'";

		//Recuperation de la connexion à la base de données
		Connection connection = DBConnection.getInstance();
		Statement statement = null;

		try {

			//Execution de la requete et recuperation du resultat
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(requete);

			//Pour chaque tuple creation d'un nouveau post inseré dans la liste
			while(rs.next()) {
				Post p = new Post();
				p.setId(rs.getInt("id_post"));
				p.setIdUser(rs.getInt("id_user"));
				p.setMsg(rs.getString("message"));
				p.setDate(rs.getTimestamp("date"));

				postsUser.add(p);
			}

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {

			if (statement != null) {
				try {
					statement.close();
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

		return postsUser;
	}

	public User getUser(String pseudo, String mdp) {

		User user = new User();

		//Requete pour recuperer un utilisateur
		String requete = "SELECT * from user WHERE pseudo = ? AND mdp = ?";

		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, pseudo);
			preparedStatement.setString(2, mdp);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				user.setId(rs.getInt("id_user"));
				user.setPseudo(rs.getString("pseudo"));
				user.setLastname(rs.getString("prenom"));
				user.setFirstname(rs.getString("nom"));
				user.setAge(rs.getInt("age"));
				user.setMdp(rs.getString("mdp"));
				user.setMail(rs.getString("email"));
				user.setGenre(rs.getString("genre"));
			}

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

		return user;
	}

	public User getUser(int id_user) {

		User user = new User();

		//Requete pour recuperer un utilisateur
		String requete = "SELECT * from user WHERE id_user = ?";

		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setInt(1, id_user);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				user.setId(rs.getInt("id_user"));
				user.setPseudo(rs.getString("pseudo"));
				user.setLastname(rs.getString("prenom"));
				user.setFirstname(rs.getString("nom"));
				user.setAge(rs.getInt("age"));
				user.setMdp(rs.getString("mdp"));
				user.setMail(rs.getString("email"));
				user.setGenre(rs.getString("genre"));
			}

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

		return user;
	}

	public boolean exist(String pseudo, String mdp) {
		boolean res = false; 

		String requete = "SELECT * FROM user WHERE pseudo = ? AND mdp = ?";

		Connection connection = DBConnection.getInstance();
		PreparedStatement preparedStatement = null;

		try {

			preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, pseudo);
			preparedStatement.setString(2, mdp);

			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				if(rs.getString("pseudo").equals(pseudo) && rs.getString("mdp").equals(mdp)) {
					res = true;
				}
			}

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
		
		return res;
	}
}


