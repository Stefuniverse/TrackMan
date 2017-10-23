package de.infinithings.Trackman.model;

import java.util.Calendar;

/**
 * One Entry what you have done today
 *
 * @author stef
 *
 */
public class Entry {

	private double startHour;
	private double endHour;
	private String notes;
	private Project project;

	public Entry(double startdate, double hours, String notes, Project project){
		this.project = project;
		this.startHour = startdate;
		this.endHour = hours;
		this.notes = notes;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getStartHour() {
		return startHour;
	}

	public void setStartHour(double startHour) {
		this.startHour = startHour;
	}

	public double getEndHour() {
		return endHour;
	}

	public void setEndHour(double endHour) {
		this.endHour = endHour;
	}




}
