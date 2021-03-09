package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Zoo;

public class ZooHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniGroupProject");

	public void insertShopper(Zoo li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}

	public List<Zoo> showAllZoos() {
		EntityManager em = emfactory.createEntityManager();
		List<Zoo> allAnimals = em.createQuery("SELECT s FROM Zoo s").getResultList();
		return allAnimals;
	}

	public Zoo findZoo(String nameToLookUp) {

		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Zoo> typedQuery = em.createQuery("select sh from Zoo sh where sh.zoo_name = :selectedName",
				Zoo.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		Zoo foundZoo;
		try {
			foundZoo = typedQuery.getSingleResult();
		} catch (NoResultException ex) {
			foundZoo = new Zoo(nameToLookUp);
		}
		em.close();

		return foundZoo;
	}
}