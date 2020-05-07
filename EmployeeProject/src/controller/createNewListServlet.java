package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.EmployeeList;
import model.Projects;



/**
 * Servlet implementation class createNewListServlet
 */
@WebServlet("/createNewListServlet")
public class createNewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createNewListServlet() {
        super();
       
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectHelper lih = new ProjectHelper();
		String name = request.getParameter("name");
		System.out.println("Employee: "+ name);
		String position = request.getParameter("position");
		System.out.println("Position: "+ position);
		
		
		String[] selectedItems =request.getParameterValues("allItemsToAdd");
		List<Projects> selectedProjectsOnList = new ArrayList<Projects>();
		//make sure something was selected – otherwise we get a null pointer exception
		if (selectedItems != null && selectedItems.length > 0)
		{
		for(int i = 0; i<selectedItems.length; i++) {
		System.out.println(selectedItems[i]);
		Projects c =lih.searchForProjectId(Integer.parseInt(selectedItems[i]));
		selectedProjectsOnList.add(c);
		}
		}
		
		// add the selected project and score to the employee list 
		EmployeeList sld = new EmployeeList(name, position);
		sld.setListofProjects(selectedProjectsOnList);
		EmployeeListHelper slh = new EmployeeListHelper();
		slh.insertEmployeeList(sld);
		System.out.println("Success!");
		System.out.println(sld.toString());
		getServletContext().getRequestDispatcher("/viewAllEmployeeListServlet").forward(request, response);
	
}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doGet(request, response);
}


}
