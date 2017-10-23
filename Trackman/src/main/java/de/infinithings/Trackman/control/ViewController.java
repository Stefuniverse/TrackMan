package de.infinithings.Trackman.control;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import de.infinithings.Trackman.view.InputField;
import de.infinithings.Trackman.view.ProjectList;
import de.infinithings.Trackman.view.WorkBar;

public class ViewController extends Application {

	private static BorderPane root;
	private static Scene s;
	private static double masterWidth;
	private static double masterHeight;


	public void start(Stage ps) throws Exception {
		root = new BorderPane();
		ps.setTitle("TrackMan 0.1");
		s = new Scene(root, 800, 600);
		masterWidth = s.getWidth();
		masterHeight = s.getHeight();

		ps.setScene(s);

		root.setRight(new ProjectList());
		root.setTop(new WorkBar());
		root.setCenter(new InputField());
		ps.show();

	}

	public static void go(String[] args) {
		launch(args);

	}

	public static double  getMasterHeight(){
		return masterHeight;
	}
	public static double getMasterWidth(){
		return masterWidth;
	}

	public static void rebuildWorkBar() {
		root.setTop(new WorkBar());
	}

}
