package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Caretaker;

/**
 * Servlet implementation class ViewCaretakerNavServlet
 */
@WebServlet("/viewCaretakerNavServlet")
public class ViewCaretakerNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCaretakerNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String marqMess = "";
		String whatDo = request.getParameter("whatDo");
		String path = "";
		if (whatDo.equals("Add New Caretaker"))
		{ 
			request.setAttribute("zoo_id", request.getParameter("zoo_id"));
			path = "/add-caretaker.jsp";
		}
		else if(whatDo.equals("Assign New Animal"))
		{
			request.setAttribute("care_id", request.getParameter("caretaker_id"));
			path = "/add-animal.jsp";
		}
		else if (whatDo.equals("Remove"))
		{
			CaretakerHelper help = new CaretakerHelper();
			try {
				int careID = Integer.parseInt(request.getParameter("caretaker_id"));
				Caretaker care = help.searchId(careID);
				help.deleteCaretaker(careID);
				path = "/viewZoosServlet";
			}
			catch (NumberFormatException e)
			{
				marqMess = "A Caretaker Needs To Be Selected";
			}
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
