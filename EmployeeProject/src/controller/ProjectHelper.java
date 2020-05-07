package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Projects;

//items to show under the employee name 

public class ProjectHelper {
	static	EntityManagerFactory	emfactory	=	
			Persistence.createEntityManagerFactory("EmployeeProject");
	
	public void insertProject(Projects li) {
		
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public List<Projects>showAllProjects(){
		EntityManager em = emfactory.createEntityManager();
		List<Projects>allProject = em.createQuery("SELECT i FROM Projects i").getResultList();
		return allProject;
	}
	
	public void deleteProject(Projects toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Projects>TypedQuery = em.createQuery("select li from Projects li where li.projectName=:selectedProjectName and  li.score =:selectedScore",Projects.class);
		
		//Substitute	parameter	with	actual	data	from	the	toDelete
		TypedQuery.setParameter("selectedProjectName",toDelete.getProjectName());
		TypedQuery.setParameter("selectedScore",	toDelete.getScore());
		
	
		//we	only	want	one	result
		TypedQuery.setMaxResults(1);
		
		//get	the	result	and	save	it	into	a	new	list	item
		Projects result	=	TypedQuery.getSingleResult();
		
		//remove	it
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		}

	
	
	public Projects searchForProjectId(int idToEdit) {
		EntityManager em= emfactory.createEntityManager();
		em.getTransaction().begin();
		Projects found = em.find(Projects.class, idToEdit);
		em.close();
		return found;
	}

	

	public void updateProject(Projects toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
		
	}

	public List<Projects> searchForProjectName(String projectName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Projects>TypedQuery = em.createQuery("select li from Projects li where li.projectName = :selectedProjectName", Projects.class);
		TypedQuery.setParameter("selectedProjectName", projectName);
		
		List<Projects>foundItems = TypedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<Projects> searchForScore(String score) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Projects>TypedQuery = em.createQuery("select li from Projects li where li.score =:selectedScore",Projects.class);
		TypedQuery.setParameter("selectedScore",score);
		
		List<Projects>foundItems = TypedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	
	public void cleanUp() {
		emfactory.close();
	}

	

	


}
