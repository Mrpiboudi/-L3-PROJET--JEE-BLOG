package controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.String;

/**
 * Servlet implementation class registerController
 */
@WebServlet("/registerController")
public class registerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "register.jsp" ).forward( request, response ); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		// Read the first name given in the form
		String login = request.getParameter("login");
		String sexe = request.getParameter("sexe");
		String age = request.getParameter("age");
		String firstname = request.getParameter("fistname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String confirmeEmail = request.getParameter("confirmeEmail");
		String password = request.getParameter("password");
		String confirmePassword = request.getParameter("confirmePassword");

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
			out.println("</body>");
			out.println("</html>");
		    return;
		}
		if (null == age || age.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un age");
			out.println("</body>");
			out.println("</html>");
		}
		if (null == firstname || firstname.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un prénom");
			out.println("</body>");
			out.println("</html>");
		}
		if (null == lastname || lastname.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un nom");
			out.println("</body>");
			out.println("</html>");
		}
		if(null == password || password.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un mot de passe");
			out.println("</body>");
			out.println("</html>");
			return;
			
		}
		if(null == confirmePassword || confirmePassword.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez confirmez votre mot de passe");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		
		if(!password.equals(confirmePassword)) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("les mot de passes sont différents");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		if(null == email || email.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez entrer un mot de passe");
			out.println("</body>");
			out.println("</html>");
			return;
			
		}
		if(null == confirmeEmail || confirmeEmail.isEmpty()) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("vous devez confirmer votre email");
			out.println("</body>");
			out.println("</html>");
			return;
			
		}
		if(!email.equals(confirmeEmail)) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("les mot de passes sont différents");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		if(db.getUser(login,password) == null) {
			out.println("<html>");
			out.println("<body>");
			out.println("<div class =\"mistake\">");
			out.println("Ce compte existe deja !");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		
		User newUser =new User(login, firstname, lastname, age, sexe, email, password);
			// If everything's OK, stores the first name and go to indexServlet.
		session.setAttribute("userID", db.getUser(login,password).getId());
		response.sendRedirect(contextPath + "/indexController");
		}
	
	

}
