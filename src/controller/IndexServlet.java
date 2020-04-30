package controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentaireMySQLDao;
import dao.RelationMySQLDao;
import dao.UserMySQLDao;
import model.Commentaire;
import model.Post;
import model.User;

/**
 * Servlet implementation class IndexServlet
 */

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int id_user = (Integer) session.getAttribute("id_user");
		
		
		RelationMySQLDao rd = new RelationMySQLDao();
		UserMySQLDao ud = new UserMySQLDao();
		
		List<User> friends = new ArrayList();
		List<Post> allPosts = new ArrayList();
		
		//Ajout de nos propres posts 
		List<Post> myPosts = new ArrayList();
		myPosts = ud.getAllPosts(id_user);
		if(!myPosts.isEmpty()) {
			for(Post p : myPosts) {
				System.out.println(p.getMsg());
				//p.setCommentsList();
				allPosts.add(p);
			}
		}
		
		//Recuperation de la liste d'ami de l'utilisateur
		friends = rd.getAllFriends(id_user);
		
		//On parcourt tout les amis de l'utilisateur
		for(User u : friends) {
			List<Post> postsFriend = new ArrayList();
			postsFriend = ud.getAllPosts(u.getId());
			//Nous ajoutons chaque poste de l'ami 
			for(Post p : postsFriend) {
				//p.setCommentsList();
				allPosts.add(p);
			}
			
		}
		
		request.setAttribute("friends_list", friends);
		request.setAttribute("all_posts", allPosts);
		request.setAttribute("id_user", id_user);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
