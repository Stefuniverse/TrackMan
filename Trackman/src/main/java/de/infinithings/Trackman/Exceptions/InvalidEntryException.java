package de.infinithings.Trackman.Exceptions;

import java.io.IOException;

import javafx.scene.control.Alert;

@SuppressWarnings("serial")
public class InvalidEntryException extends IOException {

	public InvalidEntryException(){
		super("The Workentry is invalid");
		Alert a = new Alert(Alert.AlertType.ERROR);
		a.setTitle("Fehler");
		a.setContentText("The Workentry is invalid! Please check the times");
		a.showAndWait();
	}

}