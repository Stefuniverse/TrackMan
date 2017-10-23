package de.infinithings.Trackman.view;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javafx.scene.layout.HBox;
import de.infinithings.Trackman.model.Entry;
import de.infinithings.Trackman.model.Project;
import de.infinithings.Trackman.control.ModelController;
import de.infinithings.Trackman.control.ViewController;
import org.joda.time.LocalDate;

/**
 * implements the upper Bar
 * @author Stef
 *
 */
public class WorkBar extends HBox{

	LocalDate l;
	public WorkBar(){
		super();

		l = LocalDate.now();
		generateVisualElements();

		File css = new File("styles/workBar.css");
		this.getStyleClass().add("workbar");
		this.getStylesheets().add("file:///"+css.getAbsolutePath().replace("\\", "/"));
	}

	private void generateVisualElements() {
		Calendar relativeTime = Calendar.getInstance();
		relativeTime.setTimeInMillis(this.d.getDate().getTimeInMillis());
		Entry before = new Entry(ModelController.roundToDays(relativeTime));
		for (Entry e : d.getEntriesSorted()){
			double m = e.getHours().getTimeInMillis() - e.getStartdate().getTimeInMillis();
			double length = (m / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
			if(!before.getHours().equals(e.getStartdate())){
				Entry ee = new Entry(before.getHours(),e.getStartdate(),"Keine erfasste Zeit",Project.NOTTRACKED);
				double mi = ee.getHours().getTimeInMillis() - ee.getStartdate().getTimeInMillis();
				double lengthi = (mi / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
				WorkBarEntry wi = new WorkBarEntry(ee);
				wi.setMinWidth(lengthi);
				this.getChildren().add(wi);

			}
			WorkBarEntry en = new WorkBarEntry(e);
			before = e;
			en.setMinWidth(length);
			this.getChildren().add(en);

		}
		relativeTime.add(Calendar.DAY_OF_MONTH, 1);
		if (!relativeTime.equals(before.getHours())){
			Entry ee = new Entry(before.getHours(),relativeTime,"Keine erfasste Zeit",Project.NOTTRACKED);
			double mi = ee.getHours().getTimeInMillis() - ee.getStartdate().getTimeInMillis();
			double lengthi = (mi / 86400000)*ViewController.getMasterWidth(); //calculates length relative to Bar-length
			WorkBarEntry wi = new WorkBarEntry(ee);
			wi.setMinWidth(lengthi);
			this.getChildren().add(wi);
		}
		return;
	}

}
