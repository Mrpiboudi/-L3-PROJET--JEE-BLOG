package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserMySQLDao;
import model.User;

/**
 * Servlet implementation class ChangeAccountInformation
 */

public class ChangeAccountInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangeAccountInformationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		int id_user = (Integer) session.getAttribute("id_user");

		UserMySQLDao ud = new UserMySQLDao();
		User u = ud.getUser(id_user);

		request.setAttribute("u", u);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("changeAccountInformation.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		int id_user = (Integer) session.getAttribute("id_user");

		UserMySQLDao ud = new UserMySQLDao();
		User u = ud.getUser(id_user);

		String pseudo = request.getParameter("pseudo");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		String mdp = request.getParameter("mdp");
		String mdp_confirm = request.getParameter("mdp_confirm");
		String email = request.getParameter("email");
		String genre = request.getParameter("genre");

		if(mdp.equals(mdp_confirm)) {

			String[] new_parametres = {pseudo,nom,prenom,age,mdp,mdp_confirm,email,genre};

			ud.updateUtilisateur(u, new_parametres);

			out.println("<html>");
			out.println("<body>");
			out.println("Mise à jour effectué ! Redirection ...");
			out.println("</body>");
			out.println("</html>");

		}
		else {
			out.println("<html>");
			out.println("<body>");
			out.println("Mots de passe non similaires ! Redirection ...");
			out.println("</body>");
			out.println("</html>");
		}

		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Redirige vers la même page
		String contextPath = getServletContext().getContextPath();
		String path = request.getServletPath();
		response.sendRedirect(contextPath + path);

	}

}
