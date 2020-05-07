package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addEmployerListServlet
 */
@WebServlet("/addEmployeeListServlet")
public class addEmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addEmployeeListServlet() {
        super();
        
    }

    /**
     * to send a list of employee to be displayed and if list is empty send back to create a new list 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectHelper dao = new ProjectHelper();
		request.setAttribute("allProject", dao.showAllProjects());
		if(dao.showAllProjects().isEmpty()){
		request.setAttribute("allProject", " ");
		}
		getServletContext().getRequestDispatcher("/new-list.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
