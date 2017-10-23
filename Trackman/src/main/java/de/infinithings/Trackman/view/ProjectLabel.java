package de.infinithings.Trackman.view;

import javafx.scene.layout.HBox;

import java.io.File;
import java.util.LinkedList;
import javafx.scene.control.Label;

/**
 * Builds labels for the work-on List
 *
 * @author stef
 *
 */
public class ProjectLabel extends HBox {

	Label text;

	//TODO subactivities
	LinkedList<String> activities;

	public ProjectLabel(String name){
		super();
		File css = new File("styles/ListEntry.css");
		this.text = new Label(name);
		this.text.getStyleClass().add("plabel");
		this.text.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));
		this.getChildren().add(this.text);

		this.getStyleClass().add("hbox");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));

	}

}
