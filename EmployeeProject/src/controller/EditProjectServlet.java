package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Projects;

/**
 * Servlet implementation class EditProjectServlet
 */
@WebServlet("/editProjectServlet")
public class EditProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProjectServlet() {
        super();
        
    }

	
	/**
	 * update the project list 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ProjectHelper dao = new ProjectHelper();
		
		String projectName = request.getParameter("projectName");
		int score = Integer.parseInt(request.getParameter("score"));
		Integer tempId = Integer.parseInt(request.getParameter("projectID"));
		
		
		Projects itemToUpdate = dao.searchForProjectId(tempId);
		itemToUpdate.setProjectName(projectName);
		itemToUpdate.setScore(score);
		
		dao.updateProject(itemToUpdate);
	
		
		getServletContext().getRequestDispatcher("/viewAllProjectServlet").forward(request, response);
	}

}
