package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Zoo;

/**
 * Servlet implementation class ViewZoosNavServlet
 */
@WebServlet("/viewZoosNavServlet")
public class ViewZoosNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewZoosNavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ZooHelper help = new ZooHelper();
		String marqMessage = "";
		String whatDo = request.getParameter("whatDo");
		String path = "/viewZoosServlet";
		if (whatDo.equals("Remove"))
		{
			try
			{
				int zoo_id = Integer.parseInt(request.getParameter("zoo_id"));
				help.deleteZoo(zoo_id);	
			}
			catch (NumberFormatException e)
			{
				marqMessage = "No Zoo was chosen.";
			}
		}
		else if(whatDo.equals("Add Zoo"))
		{
			path = "/add-zoo.jsp";
			
		}
		//Enters into the Caretakers
		else if (whatDo.equals("Enter"))
		{
			try
			{
				int zoo_id = Integer.parseInt(request.getParameter("zoo_id"));
				Zoo zoo = help.searchId(zoo_id);
				if (!zoo.getCaretakerList().isEmpty())
				{
					request.setAttribute("zoo", zoo);
					path = "/view-caretakers.jsp";
				}
				else
				{
					marqMessage = zoo.getZoo_name() + " appears to have no caretakers hopefully there are no animals.";
				}
				
			}
			catch (NumberFormatException e)
			{
				marqMessage = "No Zoo was chosen";
			}
		}
		else if(whatDo.equals("Add Caretaker"))
		{
			try
			{
				int zoo_id = Integer.parseInt(request.getParameter("zoo_id"));
				request.setAttribute("zoo_id", zoo_id);
				path = "/add-caretaker.jsp";
			}
			catch (NumberFormatException e)
			{
				marqMessage = "No Zoo was chosen.";
			}
			
		}
		request.setAttribute("marqueeMessage", marqMessage);
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}