import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class MiddlePanel extends JPanel {

	// The middle area will provide a panel with text fields/radio buttons/combo
	// boxes/etc. to enter data to add a new Technician's or SalesMan's or the
	// Employee Number to delete an employee.
	private final static int LEVELS_LIST[] = { 1, 2, 3 };

	private NumberFormatter intFormatter;
	private NumberFormatter doubleFormatter;

	private JTextField nameTextArea;
	private JFormattedTextField employeeNumberTextField;
	private JRadioButton salesmanRadioButton;
	private JRadioButton technicianRadioButton;

	private JComboBox levels;
	private JFormattedTextField salesTarget;
	private JTextField terrority;
	private JTextField department;

	public MiddlePanel() {

		intFormatter = createIntegerFormatter();
		doubleFormatter = createDoubleFormatter();

		nameTextArea = new JTextField("Enter the name");
		employeeNumberTextField = new JFormattedTextField(intFormatter);
		
		salesmanRadioButton = new JRadioButton("Salesman");
		technicianRadioButton = new JRadioButton("Technician");
		
		ButtonGroup  typeOfEmployeeGroup =  new ButtonGroup();
		typeOfEmployeeGroup.add(salesmanRadioButton);
		typeOfEmployeeGroup.add(technicianRadioButton);
		
		levels = new JComboBox<>(new Vector(Arrays.asList(LEVELS_LIST)));
		salesTarget = new JFormattedTextField(doubleFormatter);
		
		terrority = new JTextField("Terrority");
		department = new JTextField("Department");
		
		add(nameTextArea);
		add(employeeNumberTextField);
		
		add(salesmanRadioButton);
		add(technicianRadioButton);
		add(terrority);
		add(department);
		setVisible(true);
		
	}

	private NumberFormatter createIntegerFormatter() {
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		formatter.setCommitsOnValidEdit(true);

		return formatter;
	}

	private NumberFormatter createDoubleFormatter() {
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Double.MAX_VALUE);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		formatter.setCommitsOnValidEdit(true);

		return formatter;
	}

}
