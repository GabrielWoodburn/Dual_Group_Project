package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Caretaker;



public class CaretakerHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mini_group_project");
	
	public void insertCaretaker(Caretaker caretaker)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(caretaker);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteCaretaker(int index)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Caretaker target = em.find(Caretaker.class, index);
		em.remove(target);
		em.getTransaction().commit();
		em.close();
	}
	
	public Caretaker searchId(int idNumber)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Caretaker retrieved = em.find(Caretaker.class, idNumber);
		em.close();
		return retrieved;
	}
	
	public void updateCaretaker(Caretaker caretaker)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(caretaker);
		em.getTransaction().commit();
		em.close();
	}
	public List<Caretaker> getCaretakers()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Caretaker> allCaretakers = em.createQuery("SELECT caretaker FROM Caretaker caretaker").getResultList();
		return allCaretakers;
	}
	public void clean()
	{
		emfactory.close();
	}

}
