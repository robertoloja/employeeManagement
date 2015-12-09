import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class MiddlePanel extends JPanel implements ActionListener {

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

	private JPanel levelPanel;
	private final JLabel levelsLabel = new JLabel("LEVEL");
	private JComboBox levels;
	
	private JPanel saleTargetPanel;
	private final JLabel salesTargetLabel = new JLabel("SALES TARGET");
	private JTextField salesTarget;
	
	private JPanel terrorityPanel;
	private final JLabel terrorityLabel = new JLabel("TERRORITY");
	private JComboBox terrority;
	
	private JPanel departmentPanel;
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
		salesmanRadioButton.addActionListener(this);
		technicianRadioButton = new JRadioButton(TECHNICIAN);
		technicianRadioButton.setActionCommand(TECHNICIAN);
		technicianRadioButton.addActionListener(this);
		
	    typeOfEmployeeGroup =  new ButtonGroup();
		typeOfEmployeeGroup.add(salesmanRadioButton);
		typeOfEmployeeGroup.add(technicianRadioButton);
		typeOfEmployeeGroup.setSelected(salesmanRadioButton.getModel(), true);
		
		typePanel.add(typeOfEmployee);
		typePanel.add(salesmanRadioButton);
		typePanel.add(technicianRadioButton);
		
	
		JPanel firstPanel = new JPanel();
		
		
		 levelPanel = new JPanel();

		
		levels = populateComboBoxes(generateLevelList() );
		levelPanel.add(levelsLabel);
		levelPanel.add(levels);
		
		 saleTargetPanel = new JPanel();
		salesTarget = new JTextField();
		salesTarget.setColumns(15);
		
		saleTargetPanel.add(salesTargetLabel);
		saleTargetPanel.add(salesTarget);
		
		firstPanel.add(levelPanel);
		levelPanel.setVisible(false);
		
		firstPanel.add(saleTargetPanel);
		
		
		JPanel secondPanel = new JPanel();
		
		 terrorityPanel = new JPanel();
		terrority = populateComboBoxes(company.getValidTerritories());
		
		terrorityPanel.add(terrorityLabel);
		terrorityPanel.add(terrority);
		
		 departmentPanel = new JPanel();
		department = populateComboBoxes( company.getValidDepts());
		departmentPanel.add(departmentLabel);
		departmentPanel.add(department);
		departmentPanel.setVisible(false);
		
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


	
	
	public void sendDataFields() {
		//JOptionPane.showMessageDialog(this, );
		String getTypeofEmployee = typeOfEmployeeGroup.getSelection().getActionCommand();
		
		if (getTypeofEmployee.equals(SALESMAN)){
			try {
				company.addEmployee("s", nameTextArea.getText(), terrority.getSelectedItem().toString(), "", -1, Double.parseDouble(salesTarget.getText()));
	
			}catch (NumberFormatException e){
				JOptionPane.showMessageDialog(this, "INVALID SALES ");
			}
						
		}
		else if (getTypeofEmployee.equals(TECHNICIAN)){
			company.addEmployee("t", nameTextArea.getText(), "", department.getSelectedItem().toString(),Integer.parseInt( levels.getSelectedItem().toString()), 0);
		}
	}
	
	private int [] generateLevelList(){
		int maxlevel = company.getMaxLevel();
		int[] arrayReturn = new int[maxlevel];
		for (int i = 1 ; i < maxlevel+1;i++){
			arrayReturn[i-1] = i;
			
		}
		return arrayReturn;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String selected = arg0.getActionCommand() ;
		
		if (selected.equalsIgnoreCase(TECHNICIAN)){
			terrorityPanel.setVisible(false);
			saleTargetPanel.setVisible(false);
			salesTarget.setText("");
			departmentPanel.setVisible(true);
			levelPanel.setVisible(true);
			
			
		}
		else if(selected.equalsIgnoreCase(SALESMAN)){
			terrorityPanel.setVisible(true);
			saleTargetPanel.setVisible(true);
			departmentPanel.setVisible(false);
			levelPanel.setVisible(false);
		}
		
	}


}
