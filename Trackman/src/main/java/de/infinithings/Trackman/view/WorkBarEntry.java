package de.infinithings.Trackman.view;

import java.io.File;
import java.lang.reflect.Field;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.util.Duration;
import de.infinithings.Trackman.model.Entry;

public class WorkBarEntry extends Label{

	private Entry e;
	private Tooltip t;

	public WorkBarEntry(Entry e){
		this.e = e;
		this.setStyle("-fx-background-color:"+e.getProject().getColorCode()+";");

		File css = new File("styles/workBar.css");
		this.getStyleClass().add("workbarentry");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));

		t = new Tooltip();
		double time = e.getHours().getTimeInMillis() - e.getStartdate().getTimeInMillis();
		time = time/3600000;
		t.setText(e.getProject().getName()+"\nDauer: "+time+" Stunden\n");
		hackTooltipStartTiming(t);
		this.setTooltip(t);

	}

	/**
	 * @author Igor Luzhanov
	 * @param tooltip
	 */
	public static void hackTooltipStartTiming(Tooltip tooltip) {
	    try {
	        Field bhv = tooltip.getClass().getDeclaredField("BEHAVIOR");
	        bhv.setAccessible(true);
	        Object objbhv = bhv.get(tooltip);

	        Field fldTimer = objbhv.getClass().getDeclaredField("activationTimer");
	        fldTimer.setAccessible(true);
	        Timeline objTimer = (Timeline) fldTimer.get(objbhv);

	        objTimer.getKeyFrames().clear();
	        objTimer.getKeyFrames().add(new KeyFrame(new Duration(10)));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public Entry getE() {
		return e;
	}


}
