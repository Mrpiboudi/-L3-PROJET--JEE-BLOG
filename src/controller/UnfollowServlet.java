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
import model.Relation;

/**
 * Servlet implementation class UnfollowServlet
 */
@WebServlet("/UnfollowServlet")
public class UnfollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnfollowServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		int id_user = (Integer) session.getAttribute("id_user");
		
		String idUser2Tmp = (String) request.getParameter("userU");
		int id_user_2 = Integer.parseInt(idUser2Tmp);
		
		RelationMySQLDao rd = new RelationMySQLDao();
		Relation newRelation = new Relation(id_user, id_user_2);
		rd.supprimerRelation(newRelation);
		
		request.setAttribute("user_2", idUser2Tmp);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProfilServlet");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
