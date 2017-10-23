package de.infinithings.Trackman.control;

import java.util.LinkedList;
import de.infinithings.Trackman.model.Project;
import java.sql.*;

public class ModelController {

	private ModelController i;
	static final String DATABASE_LINK = "/home/stef/test.sqlite";


	private LinkedList<Project> projects = new LinkedList<Project>();

	/**
	 * Method Stub for model
	 * @return project stub
	 */
	public LinkedList<Project> getProjects(){
		return projects;
	}

	public void addProject(Project p){
		projects.add(p);
	}

	public  getEntriesByDate(){

	}


}
