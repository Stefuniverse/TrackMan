package de.infinithings.Trackman.view;

import java.util.Calendar;
import de.infinithings.Trackman.Exceptions.InvalidEntryException;
import de.infinithings.Trackman.Exceptions.SlotAllreadyInUseException;
import de.infinithings.Trackman.control.ModelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import de.infinithings.Trackman.model.Project;

public class InputField extends HBox {

	private Button create;
	private TextTimePicker start;
	private TextTimePicker end;
	private DatePicker day;
	private TextArea a;


	public InputField(){
		super();
		start = new TextTimePicker();
		end = new TextTimePicker();
		create = new Button();
		day = new DatePicker();
		a = new TextArea();

		 this.getChildren().add(start);
		 this.getChildren().add(end);
		 this.getChildren().add(create);
		 this.getChildren().add(day);
		 this.getChildren().add(a);


		 create.setText("Add");
		 create.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent event) {
				Calendar c = Calendar.getInstance();
				c.clear();
				c.set(Calendar.DAY_OF_MONTH, day.getValue().getDayOfMonth());
				c.set(Calendar.MONTH, day.getValue().getMonthValue());
				c.set(Calendar.YEAR, day.getValue().getYear());
				c.set(Calendar.HOUR, Integer.parseInt(start.getText().split(":")[0]));
				c.set(Calendar.MINUTE, Integer.parseInt(start.getText().split(":")[1]));
				Calendar d = Calendar.getInstance();
				d.clear();
				d.set(Calendar.DAY_OF_MONTH, day.getValue().getDayOfMonth());
				d.set(Calendar.MONTH, day.getValue().getMonthValue());
				d.set(Calendar.YEAR, day.getValue().getYear());
				d.set(Calendar.HOUR, Integer.parseInt(end.getText().split(":")[0]));
				d.set(Calendar.MINUTE, Integer.parseInt(end.getText().split(":")[1]));
				try {
					//ModelController.getDay(ModelController.roundToDays(c)).createEntry(Project.NOTTRACKED, c, d, a.getText());
				} catch(NullPointerException e){
					//TODO Logging
				}

			}
		});
	}




}
