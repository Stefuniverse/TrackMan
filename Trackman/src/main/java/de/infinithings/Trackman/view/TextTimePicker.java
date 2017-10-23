package de.infinithings.Trackman.view;

import java.io.File;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;

public class TextTimePicker extends TextField{

	public TextTimePicker(){
		super();

		this.setText("00:00");

		File css = new File("styles/TimeField.css");
		this.getStyleClass().add("TimeField");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));

		this.focusedProperty().addListener(new ChangeListener<Boolean>(){

			@Override
			public void changed(ObservableValue<? extends Boolean> arg0, Boolean old, Boolean now) {
				if (now){
					return;
				} else{
					controlText();
				}

			}

		});
	}

	private void controlText(){
		String test = this.getText().trim();
		if(Pattern.compile("\\d{1,2}:\\d{0,2}").matcher(test).matches()){
			String correct = test.split(":")[1];
			if(correct.length() == 1){
				test += "0";
			} else if(correct.length() == 0) {
				test += "00";
			}
		} else if(Pattern.compile("\\d{1,4}").matcher(test).matches()){
			switch(test.length()){
			case 1:
				test = "0"+test;
			case 2:
				test += ":00";
				break;
			case 3:
				test = test.substring(0,2)+":"+test.charAt(2)+"0";
				break;
			case 4:
				test = test.substring(0,2)+":"+test.substring(2,4);
				break;
			}
		} else{
			test ="00:00";
		}
		if(Integer.parseInt(test.split(":")[0]) <= 24 && Integer.parseInt(test.split(":")[1]) <= 60){
			this.setText(test);
			return;
		} else{
			this.setText("00:00");
		}
	}

}
