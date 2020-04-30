package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserMySQLDao;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "login.jsp" ).forward( request, response ); 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// Read the first name given in the form
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		UserMySQLDao db = new UserMySQLDao();
		HttpSession session = request.getSession(true);
		// The project name
		String contextPath = getServletContext().getContextPath();
		/*
		 * Ensure the first name was given.
		 *
		 * If it was sent empty, send a redirect
		 * to the user (HTTP code 302) so it will
		 * request "GET /{projectName}/SetSessionServlet" again.
		 */
		if (null == login || login.isEmpty()) {
		    // The servlet path
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un identifiants");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		    return;
		}
		if(null == password || password.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un mot de passe");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			return;
			
		}
		if(db.getUser(login,password) == null) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("ce compte n'existe pas ou les informations entré sont fausses ");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		
			// If everything's OK, stores the first name and go to indexServlet.
			session.setAttribute("userID", db.getUser(login,password).getId());
			response.sendRedirect(contextPath + "/IndexServlet");
		
	}

}
