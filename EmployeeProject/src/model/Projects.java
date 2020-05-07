package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "project")
public class Projects {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int projectID;
	@Column(name="PROJECT_NAME")
	private String projectName;
	@Column(name="SCORE")
	private int score;
	
	
	public Projects() {
		super();
		
	}
	public Projects(String projectName, int score) {
		super();
		this.projectName = projectName;
		this.score = score;
	}

	public int getProjectID() {
		return projectID;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return projectName +  ":" + score ;
	}
	

}
