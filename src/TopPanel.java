import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
		 JScrollPane scroll = new JScrollPane (displayInformation);
		    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		    
		add(scroll, BorderLayout.CENTER);
		this.company = company;
		updateDisplayInformation();
	}
	
	public void resetInformation (){
		company.resetList();
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
