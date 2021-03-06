import java.util.List;

import controller.AnimalHelper;
import controller.EmployeeHelper;
import controller.ZooHelper;
import model.Animal;
import model.Employee;
import model.Zoo;

public class Tester {
	public static void main(String[] args)
	{
		//This should insert the instance of Animal, Zoo, and Employee and then get a list of what's stored
		//in their respective database
		Zoo newZoo = new Zoo("Henry Doorly");
		Employee newEmployee = new Employee("Logan", "Riedell", "Pooper Scooper");
		Animal newAnimal = new Animal("Mickey Mouse", 93, 5.4);
		//Insert and retrieve lists
		List<Animal> animals = testAnimals(newAnimal);
		List<Zoo> zoos = testZoos(newZoo);
		List<Employee> employees = testEmployees(newEmployee);
		
		//Print Zoo list
		System.out.println("Zoos:");
		for (Zoo zoo: zoos)
		{
			System.out.println(zoo.toString());
		}
		//Print Employee list
		System.out.println("Employee:");
		for (Employee employee: employees)
		{
			System.out.println(employee.toString());
		}
		//Print Animal list
		System.out.println("Animals:");
		for (Animal animal: animals)
		{
			System.out.println(animal.toString());
		}
	}
	
	//should insert into database and then extract that object and return
	public static List<Animal> testAnimals(Animal animal)
	{
		AnimalHelper help = new AnimalHelper();
		help.insertAnimal(animal);
		List<Animal> retrievedAnimals  = help.getAnimals();
		return retrievedAnimals;
	}
	
	public static List<Zoo> testZoos(Zoo zoo)
	{
		ZooHelper help = new ZooHelper();
		help.insertZoo(zoo);
		List<Zoo> retrievedZoos = help.getZoos();
		return retrievedZoos;
	}
	
	public static List<Employee> testEmployees(Employee employee)
	{
		EmployeeHelper help = new EmployeeHelper();
		help.insertEmployee(employee);
		List<Employee> retrievedEmployees = help.getEmployees();
		return retrievedEmployees;
	}

}