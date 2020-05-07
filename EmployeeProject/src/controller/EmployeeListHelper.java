package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.EmployeeList;



public class EmployeeListHelper {
	static	EntityManagerFactory	emfactory	=	
			Persistence.createEntityManagerFactory("EmployeeProject");
	
	public void insertEmployeeList(EmployeeList li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
		public List<EmployeeList> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<EmployeeList> allEmployeeList = em.createQuery("SELECT d FROM EmployeeList d").getResultList();
		return allEmployeeList;
		}
		public EmployeeList searchForId(Integer tempId) {
			EntityManager em= emfactory.createEntityManager();
			em.getTransaction().begin();
			EmployeeList found = em.find(EmployeeList.class, tempId);
			em.close();
			return found;
		}

		public void deleteEmployeeList(EmployeeList listToDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<EmployeeList> typedQuery = em.createQuery("select d from EmployeeList d where d.id=:selectedid",EmployeeList.class);

			//Substitute	parameter	with	actual	data	from	the	toDelete	item
			typedQuery.setParameter("selectedid",listToDelete.getId());
			
			//we	only	want	one	result
			typedQuery.setMaxResults(1);
			
			//get	the	result	and	save	it	into	a	new	list	item
			EmployeeList result	=	typedQuery.getSingleResult();
			
			//remove	it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
			}

		public void updateEmployeeList(EmployeeList toEdit) {
		
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
		}
			
		

}
