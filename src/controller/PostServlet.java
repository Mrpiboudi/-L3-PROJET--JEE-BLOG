package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostMySQLDao;
import model.Post;

/**
 * Servlet implementation class PostServlet
 */

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id_user = request.getParameter("id_user");
		String msg = request.getParameter("msg");
		
		Post p = new Post(Integer.parseInt(id_user), msg, new Timestamp(System.currentTimeMillis()));
		
		PostMySQLDao pd = new PostMySQLDao();
		pd.ajouterPost(p);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/IndexServlet");
		dispatcher.forward(request, response);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
