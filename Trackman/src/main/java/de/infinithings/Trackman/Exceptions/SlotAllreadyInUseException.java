package de.infinithings.Trackman.Exceptions;

import java.io.IOException;
import java.util.Calendar;

import javafx.scene.control.Alert;

@SuppressWarnings("serial")
public class SlotAllreadyInUseException extends IOException {

	public SlotAllreadyInUseException(){
		super("This timeslot is already in use.");
		Alert a = new Alert(Alert.AlertType.ERROR);
		a.setTitle("Error!");
		a.setContentText("This timeslot is already in use.");
		a.showAndWait();
	}

}
