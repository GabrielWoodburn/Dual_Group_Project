package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Caretaker;
import model.Zoo;

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
			ZooHelper zooHelp = new ZooHelper();
			try {
				int careID = Integer.parseInt(request.getParameter("caretaker_id"));
				int zoo_id = Integer.parseInt(request.getParameter("zoo_id"));
				help.deleteCaretaker(careID);
				path = "/viewZoosServlet";
			}
			catch (NumberFormatException e)
			{
				marqMess = "A Caretaker Needs To Be Selected";
			}
		}
		else if (whatDo.equals("Edit Caretaker"))
		{
			CaretakerHelper help = new CaretakerHelper();
			try {
				int careID = Integer.parseInt(request.getParameter("caretaker_id"));
				Caretaker care = help.searchId(careID);
				request.setAttribute("caretaker", care);
				path = "/edit-caretaker.jsp";
				
			}
			catch (NumberFormatException e)
			{
				marqMess = "A Caretaker Needs To Be Selected";
			}
		}
		else if (whatDo.equals("Update Caretaker"))
		{
			CaretakerHelper help = new CaretakerHelper();
			int month = Integer.parseInt(request.getParameter("month"));
			int year = Integer.parseInt(request.getParameter("year"));
			int day = Integer.parseInt(request.getParameter("day"));
			LocalDate hireDate = LocalDate.of(year, month, day);
			String first = request.getParameter("first_name");
			String last = request.getParameter("last_name");
			int id = Integer.parseInt(request.getParameter("caretaker_id"));
			Caretaker care = help.searchId(id);
			care.setCaretaker_First(first);
			care.setCaretaker_Last(last);
			care.setHireDate(hireDate);
			help.updateCaretaker(care);
			path = "/viewZoosServlet";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
