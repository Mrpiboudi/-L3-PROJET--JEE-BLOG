package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentaireMySQLDao;
import model.Commentaire;

/**
 * Servlet implementation class CommentaireServlet
 */

public class CommentaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CommentaireServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("IndexServlet");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_post = request.getParameter("id_post");
		String id_user = request.getParameter("id_user");
		String msg = request.getParameter("commentaire");
		
		System.out.println("id user comm : "+id_user);

		Commentaire c = new Commentaire(Integer.parseInt(id_post), Integer.parseInt(id_user), msg,new Timestamp(System.currentTimeMillis()));
		CommentaireMySQLDao cd = new CommentaireMySQLDao();
		cd.ajouterCommentaire(c);

		response.sendRedirect("IndexServlet");
	}

}
