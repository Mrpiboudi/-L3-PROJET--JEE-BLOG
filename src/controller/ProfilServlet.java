package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RelationMySQLDao;
import dao.UserMySQLDao;
import model.User;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class ProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfilServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		int id_user = (Integer) session.getAttribute("id_user");

		boolean isFriend = false;
		boolean itsMe = false;

		String id = request.getParameter("user");
		if(id.equals(null)) {
			id = (String) request.getAttribute("user_2");
		}
		int id_c_user = Integer.parseInt(id);
		User u = new User();
		UserMySQLDao ud = new UserMySQLDao();
		u = ud.getUser(id_c_user);

		if(id_user == id_c_user) {
			itsMe = true;
		} 
		RelationMySQLDao rd = new RelationMySQLDao();
		isFriend = rd.relationExist(id_user, id_c_user);

		request.setAttribute("c_user",u);
		request.setAttribute("is_friend", isFriend);
		request.setAttribute("its_me", itsMe);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("profil.jsp");

		dispatcher.forward(request, response);


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
