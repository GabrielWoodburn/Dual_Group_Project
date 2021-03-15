package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Animal;

public class AnimalHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mini_group_project");
	
	public void insertAnimal(Animal animal)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(animal);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteAnimal(int index)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Animal animal = em.find(Animal.class, index);
		em.remove(animal);
		em.getTransaction().commit();
		em.close();
	}
	
	public Animal searchId(int idNumber)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Animal retrieved = em.find(Animal.class, idNumber);
		em.close();
		return retrieved;
	}
	
	public void updateAnimal(Animal animal)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(animal);
		em.getTransaction().commit();
		em.close();
	}
	public List<Animal> getAnimals()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Animal> allAnimals = em.createQuery("SELECT animal FROM Animal animal").getResultList();
		return allAnimals;
	}
	public void clean()
	{
		emfactory.close();
	}

}