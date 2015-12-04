import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TopPanel extends JPanel {

	// In the top panel, the applet will display all of the Technicians and/or
	// Salesmen as were controlled in previous project. They will be in a text
	// area (JTextArea) or other suitable component.

	private JTextArea displayInformation;
	private Company company;
	
	public TopPanel(Company company) {
		setLayout(new BorderLayout());
		displayInformation = new JTextArea();
		displayInformation.setEditable(false);
		add(displayInformation, BorderLayout.CENTER);
		this.company = company;
		updateDisplayInformation();
	}

	public void updateDisplayInformation() {
		String displayString = "";
		for (Employee e : company.getEmployees()){
			displayString += e;
			displayString += "\n";
		}
		displayInformation.setText(displayString);
		
	}
}
