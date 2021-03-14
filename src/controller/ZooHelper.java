package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Zoo;

public class ZooHelper {
static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("mini_group_project");
	
	public void insertZoo(Zoo zoo)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(zoo);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteZoo(int index)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Zoo target = em.find(Zoo.class, index);
		em.remove(target);
		em.getTransaction().commit();
		em.close();
	}
	
	public Zoo searchId(int idNumber)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Zoo retrieved = em.find(Zoo.class, idNumber);
		em.close();
		return retrieved;
	}
	
	public void updateZoo(Zoo zoo)
	{
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(zoo);
		em.getTransaction().commit();
		em.close();
	}
	public List<Zoo> getZoos()
	{
		EntityManager em = emfactory.createEntityManager();
		List<Zoo> allZoos = em.createQuery("SELECT zoo FROM Zoo zoo").getResultList();
		return allZoos;
	}
	public void clean()
	{
		emfactory.close();
	}

}
