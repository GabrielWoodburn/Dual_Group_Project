package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ListItem;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ListItemHelper dao = new ListItemHelper();
		String act = request.getParameter("doThisToItem");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);

		} else if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListItem itemToDelete = dao.searchForItemById(tempId);
				dao.deleteItem(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("You didn't choose an option");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				ListItem itemToEdit = dao.searchForItemById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				getServletContext().getRequestDispatcher("/edit-item.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
			} 

		} else if (act.equals("add")) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}

	}

}