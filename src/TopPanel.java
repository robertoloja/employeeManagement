import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopPanel extends JPanel {

	// In the top panel, the applet will display all of the Technicians and/or
	// Salesmen as were controlled in previous project. They will be in a text
	// area (JTextArea) or other suitable component.
	
	private JTextArea displayInformation ;
	public TopPanel() {
		setLayout(new BorderLayout());
		displayInformation = new JTextArea("Display Area");
		displayInformation.setEditable(false);
		add(displayInformation,BorderLayout.CENTER);
	}
}
