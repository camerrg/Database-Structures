package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.EmployeeList;

/**
 * Servlet implementation class viewAllEmployeeListServlet
 */
@WebServlet("/viewAllEmployeeListServlet")
public class viewAllEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllEmployeeListServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeListHelper slh = new EmployeeListHelper();
		List<EmployeeList> abc = slh.getLists();
		request.setAttribute("allLists", abc);
		
		
		if (abc.isEmpty()) {
						request.setAttribute("allLists", " ");

		}
		getServletContext().getRequestDispatcher("/employeeList-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
