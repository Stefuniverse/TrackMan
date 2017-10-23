package de.infinithings.Trackman.model;

import java.util.LinkedList;

public class Project {

	public static final Project NOTTRACKED = new Project("Not tracked", "#000000",false);

	private String name;
	private boolean active;
	private String colorCode;
	private LinkedList<String> subProjects;

	public Project(String name, String c, boolean active){
		this.name = name;
		this.colorCode = c;
		this.active = active;
		this.subProjects = new LinkedList<String>();
	}

	public Project(String name, String c, boolean active, LinkedList<String> sp){
		this.name = name;
		this.colorCode = c;
		this.active = active;
		this.subProjects = sp;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public LinkedList<String> getSubProjects() {
		return subProjects;
	}

	public void setSubProjects(LinkedList<String> subProjects) {
		this.subProjects = subProjects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void createSubproject(String name){
		subProjects.add(name);
	}

}
