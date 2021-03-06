package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Employee;



public class EmployeeHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mini_group_project");
	
	public void insertEmployee(Employee employee)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(employee);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteEmloyee(int index)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Employee target = em.find(Employee.class, index);
		em.remove(target);
		em.getTransaction().commit();
		em.close();
	}
	
	public Employee searchId(int idNumber)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Employee retrieved = em.find(Employee.class, idNumber);
		em.close();
		return retrieved;
	}
	
	public void updateEmployee(Employee employee)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(employee);
		em.getTransaction().commit();
		em.close();
	}
	public List<Employee> getEmployees()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Employee> allEmployees = em.createQuery("SELECT employee FROM Employee employee").getResultList();
		return allEmployees;
	}
	public void clean()
	{
		emfactory.close();
	}

}
