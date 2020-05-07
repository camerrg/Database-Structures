package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.persistence.sessions.Project;


import model.Projects;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/addProjectServlet")
public class addProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addProjectServlet() {
        super();
        
    }
    	/**
    	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	}

    	/**
    	 * display the project name and score as the "home page" 
    	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    	 */
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String projectName = request.getParameter("projectName");
    		int score = Integer.parseInt(request.getParameter("score"));
    		
    		Projects li = new Projects(projectName,score);
    		ProjectHelper dao = new ProjectHelper();
    		dao.insertProject(li);
    		
    		getServletContext().getRequestDispatcher("/index.html").forward(request,  response);
    	}
	

}
