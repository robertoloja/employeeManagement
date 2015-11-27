import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JLabel;

/**
 * Stub placeholder.
 * 
 * @author
 * @version
 */

// the GUI logic (i.e. applet display) consists of three panels - one to display
// a summary of data; one to allow the add or delete of a specific record; and
// one to contain any required control buttons. This is similar to the Brandi's
// Bagels and the GICApplet.

//
/*
 * In the top panel, the applet will display all of the Technicians and/or
 * Salesmen as were controlled in previous project. They will be in a text area
 * (JTextArea) or other suitable component.
 * 
 * The middle area will provide a panel with text fields/radio buttons/combo
 * boxes/etc. to enter data to add a new Technician's or SalesMan's or the
 * Employee Number to delete an employee.
 * 
 * The bottom area will provide a panel with buttons for reset to original data,
 * display, sort, add and delete. You can use a single listener and then check
 * the buttons with an if statement or create individual listeners.
 */

public class CompanyApplet extends JApplet {
	JLabel label1, label2;

	public CompanyApplet() { // Default layout manager is BorderLayout

	}

	public void init() {
	
		label1 = new JLabel("Message from constructor", JLabel.CENTER);
		add(label1, BorderLayout.NORTH);
		JLabel label2 = new JLabel("Message from init()", JLabel.LEFT);
		add(label2, BorderLayout.WEST);
	}
}
