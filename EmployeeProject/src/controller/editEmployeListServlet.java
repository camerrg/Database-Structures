package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EmployeeList;
import model.Projects;



/**
 * Servlet implementation class editEmployeListServlet
 */
@WebServlet("/editEmployeListServlet")
public class editEmployeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editEmployeListServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeListHelper slh = new EmployeeListHelper();
		ProjectHelper lih = new ProjectHelper();
		

		// search for object to make changes to
		int idToEdit = Integer.parseInt(request.getParameter("id"));
		EmployeeList toEdit = slh.searchForId(idToEdit);

		// update name first
		String name= request.getParameter("name");
		System.out.println("Name: " + name);
		toEdit.setName(name);

		// update the position
		String position= request.getParameter("position");
		System.out.println("Position: " + position);
		toEdit.setPosition(position);
		
			// update the list of projects
		List<Projects> previousListOfProject = toEdit.getListofProjects();
           // use an array to add new project and score -- hashing 
		String[] selectedItems = request.getParameterValues("itemsToAdd");
		List<Projects> selectedProjectOnList = new ArrayList<Projects>();

		if (selectedItems != null && selectedItems.length > 0 ) {
			for (int i = 0; i < selectedItems.length; i++) {
				System.out.println(selectedItems[i]);
				Projects c = lih.searchForProjectId(Integer.parseInt(selectedItems[i]));
				selectedProjectOnList.add(c);

			}

			previousListOfProject.addAll(selectedProjectOnList);
		}

		toEdit.setListofProjects(previousListOfProject);

		slh.updateEmployeeList(toEdit);

		System.out.println("Success!");
		System.out.println(toEdit.toString());

		getServletContext().getRequestDispatcher("/viewAllEmployeeListServlet").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
