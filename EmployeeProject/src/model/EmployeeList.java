package model;
/**************************************************************
* Name        : Employee Performance
* Author      : Regina Cameron
* Created     : 05/06/20
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program overall description here
*               Input:  enter project name and score along with employee name and position
*               Output: list of project and score and employee list with project and score 
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

	@Entity
	@Table(name = "employee")
	public class EmployeeList {
	


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLOYEE_ID")
	private int id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "POSITION")
	private String position;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable(name="project_list",
			 joinColumns={ @JoinColumn(name="EMPLOYEE_ID",
			referencedColumnName="EMPLOYEE_ID") },
			 inverseJoinColumns={ @JoinColumn(name="PROJECT_ID",
			referencedColumnName="PROJECT_ID", unique=true) })
	private List<Projects>listofProjects;
	
	
	public EmployeeList() {
		super();
	}
	public EmployeeList (int id, String name, String position, List<Projects> listofProjects) {
		super();
		this.id = id;
		this.name = name;
		this.position = position;
		this.listofProjects = listofProjects;
	}
	
	public EmployeeList(String name, String position, List<Projects>listofProjects) {
		super();
		this.name = name;
		this.position = position;
		this.listofProjects = listofProjects;
	}
	
	public EmployeeList(String name, String position) {
		super();
		this.name = name;
		this.position = position;
		
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public List<Projects> getListofProjects() {
		return listofProjects;
	}


	public void setListofProjects(List<Projects> listofProjects) {
		this.listofProjects = listofProjects;
	}

	@Override
	public String toString() {
		return"EmployeeList [id= "  + id + ", name=" + name + ", position=" +  position + ", listofProjects=" + listofProjects + "]";
	}
	
	}
	
