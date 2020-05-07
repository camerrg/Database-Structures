package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Projects;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectHelper dao = new ProjectHelper();
		String act = request.getParameter("doThisToItem");
		
		
		String path = "/viewAllProjectServlet";
// ensures that a selection is made if delete was selected to remove a project 
		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("projectID"));
				Projects itemToDelete = dao.searchForProjectId(tempId);
				dao.deleteProject(itemToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a project");
			}
// searches for the a specific id to edit the project 
		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("projectID"));
				Projects itemToEdit = dao.searchForProjectId(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				path = "/edit-project.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a project");
			}
		} else if (act.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
