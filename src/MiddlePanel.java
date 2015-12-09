import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.NumberFormatter;

public class MiddlePanel extends JPanel {

	// The middle area will provide a panel with text fields/radio buttons/combo
	// boxes/etc. to enter data to add a new Technician's or SalesMan's or the
	// Employee Number to delete an employee.

	private final static String TECHNICIAN = "Technician";
	private final  static String SALESMAN = "Salesman";
	
	private Company company;

//
	
	private final JLabel nameLabel = new JLabel("NAME");
	private JTextField nameTextArea;
	
	
	private ButtonGroup  typeOfEmployeeGroup ;
	private final JLabel typeOfEmployee = new JLabel("TYPE OF EMPLOYEE");
	private JRadioButton salesmanRadioButton;
	private JRadioButton technicianRadioButton;

	private final JLabel levelsLabel = new JLabel("LEVEL");
	private JComboBox levels;
	
	private final JLabel salesTargetLabel = new JLabel("SALES TARGET");
	private JFormattedTextField salesTarget;
	
	private final JLabel terrorityLabel = new JLabel("TERRORITY");
	private JComboBox terrority;
	
	private final JLabel departmentLabel = new JLabel("DEPARTMENT");
	private JComboBox department;

	public MiddlePanel(Company company) {
		this.company = company;
		
		setLayout(new GridLayout(5,1));
		
		//intFormatter = createIntegerFormatter();
	
	
		JPanel namePanel = new JPanel();
		//namePanel.setLayout(new FlowLayout());
		nameTextArea = new JTextField(15);
		namePanel.add(nameLabel);
		namePanel.add(nameTextArea);
		
		
		JPanel typePanel = new JPanel();
		
		
		
		salesmanRadioButton = new JRadioButton(SALESMAN);
		salesmanRadioButton.setActionCommand(SALESMAN);
		technicianRadioButton = new JRadioButton(TECHNICIAN);
		technicianRadioButton.setActionCommand(TECHNICIAN);
		
	    typeOfEmployeeGroup =  new ButtonGroup();
		typeOfEmployeeGroup.add(salesmanRadioButton);
		typeOfEmployeeGroup.add(technicianRadioButton);
		typeOfEmployeeGroup.setSelected(salesmanRadioButton.getModel(), true);
		
		typePanel.add(typeOfEmployee);
		typePanel.add(salesmanRadioButton);
		typePanel.add(technicianRadioButton);
	
		JPanel firstPanel = new JPanel();
		
		
		JPanel levelPanel = new JPanel();
		levels = populateComboBoxes( Company.LEVELS_LIST);
		levelPanel.add(levelsLabel);
		levelPanel.add(levels);
		
		JPanel saleTargetPanel = new JPanel();
		salesTarget = new JFormattedTextField(createDoubleFormatter());
		salesTarget.setColumns(15);
		
		saleTargetPanel.add(salesTargetLabel);
		saleTargetPanel.add(salesTarget);
		
		firstPanel.add(levelPanel);
		firstPanel.add(saleTargetPanel);
		
		
		JPanel secondPanel = new JPanel();
		
		JPanel terrorityPanel = new JPanel();
		terrority = populateComboBoxes(Company.VALID_TERRITORIES);
		
		terrorityPanel.add(terrorityLabel);
		terrorityPanel.add(terrority);
		
		JPanel departmentPanel = new JPanel();
		department = populateComboBoxes( Company.VALID_DEPTS);
		departmentPanel.add(departmentLabel);
		departmentPanel.add(department);
		
		secondPanel.add(terrorityPanel);
		secondPanel.add(departmentPanel);
		
		add(namePanel);

		add(typePanel);
		add(firstPanel);
		
		add(secondPanel);
		setVisible(true);
		
	}
	
	private JComboBox<?> populateComboBoxes ( Object arrayFilled){
		Vector comboBoxItems=new Vector<Object>();
	   
	    
		if (arrayFilled instanceof int[]){
			int[] intArrayFilled = (int[]) arrayFilled;
			for (int i : intArrayFilled){
		
				comboBoxItems.add(i+"");
			}
			
		}
		else if (arrayFilled instanceof String[]){
			String[] stringArrayFilled = (String[]) arrayFilled;
			for (String s : stringArrayFilled){
				comboBoxItems.add(s);
			}
		}
		return new JComboBox<>(comboBoxItems);
	}


	private NumberFormatter createDoubleFormatter() {
		NumberFormat format = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setValueClass(Double.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Double.MAX_VALUE);
		// If you want the value to be committed on each keystroke instead of
		// focus lost
		//formatter.setCommitsOnValidEdit(true);

		return formatter;
	}
	
	public void sendDataFields() {
		//JOptionPane.showMessageDialog(this, );
		String getTypeofEmployee = typeOfEmployeeGroup.getSelection().getActionCommand();
		
		if (getTypeofEmployee.equals(SALESMAN)){
	
			company.addEmployee("s", nameTextArea.getText(), terrority.getSelectedItem().toString(), "", -1, (((Number)salesTarget.getValue()).doubleValue()));
			
		}
		else if (getTypeofEmployee.equals(TECHNICIAN)){
			company.addEmployee("t", nameTextArea.getText(), "", department.getSelectedItem().toString(),Integer.parseInt( levels.getSelectedItem().toString()), 0);
		}
	}

}
