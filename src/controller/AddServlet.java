package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Animal;
import model.Caretaker;
import model.Zoo;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
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
		String whatDo = request.getParameter("whatDo");
		String path = "/viewZoosServlet";
		if (whatDo.equals("Add Zoo"))
		{
			String name = request.getParameter("zoo_name");
			ZooHelper help = new ZooHelper();
			Zoo newZoo = new Zoo(name);
			help.insertZoo(newZoo);
		}
		else if (whatDo.equals("Add New Caretaker"))
		{
			int zoo_id = Integer.parseInt(request.getParameter("zoo_id"));
			ZooHelper zooHelp = new ZooHelper();
			Zoo zoo = zooHelp.searchId(zoo_id);
			List <Caretaker> list = zoo.getCaretakerList();
			int month = Integer.parseInt(request.getParameter("month"));
			int day = Integer.parseInt(request.getParameter("day"));
			int year = Integer.parseInt(request.getParameter("year"));
			String first = request.getParameter("first_name");
			String last = request.getParameter("last_name");
			LocalDate date = LocalDate.of(year, month, day);
			Caretaker newCare = new Caretaker(first, last, date);
			list.add(newCare);
			zoo.setCaretakerList(list);
			zooHelp.updateZoo(zoo);
		}
			
		else if (whatDo.equals("Add Animal"))
		{
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			int caretaker = Integer.parseInt(request.getParameter("caretaker_id"));
			CaretakerHelper helpCare = new CaretakerHelper();
			Caretaker caretake = helpCare.searchId(caretaker);
			List<Animal> list = caretake.getAnimalList();
			Animal animal = new Animal(name, age);
			list.add(animal);
			caretake.setAnimalList(list);
			helpCare.updateCaretaker(caretake);
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
		
	}

}
