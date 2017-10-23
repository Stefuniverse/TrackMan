package de.infinithings.Trackman.view;

import java.io.File;

import de.infinithings.Trackman.control.ModelController;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import de.infinithings.Trackman.model.Project;


public class ProjectList extends VBox {


	public ProjectList(){
		super();
		this.getStyleClass().add("vbox");
		File css = new File("styles/list.css");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));
		refreshProjectList();
	}

	public void refreshProjectList() {

		for(Project i : ModelController.getProjects()){
			this.getChildren().add(new ProjectLabel(i.getName()));
		}


	}



}
