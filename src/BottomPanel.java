import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//The bottom area will provide a panel with buttons for reset to original data,
//display, sort, add and delete. You can use a single listener and then check the buttons
//with an if statement or create individual listeners.

public class BottomPanel extends JPanel {

	private JButton resetButton;
	private JButton sortButton;
	private JButton addButton;
	private JButton deleteButton;
	Company company;
	TopPanel topPanel;
	MiddlePanel middlePanel;

	public BottomPanel(Company company, TopPanel topPanel,
			MiddlePanel middlePanel) {

		setLayout(new FlowLayout());
		resetButton = new ResetButton();
		sortButton = new SortButton();
		addButton = new AddButton();
		deleteButton = new DeleteButton();

		this.company = company;
		this.topPanel = topPanel;
		this.middlePanel = middlePanel;

		add(resetButton);
		add(sortButton);
		add(addButton);
		add(deleteButton);

	}

	class ResetButton extends JButton implements ActionListener {

		public ResetButton() {
			super("Reset");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			topPanel.resetInformation();
		}

	}

	class SortButton extends JButton implements ActionListener {

		public SortButton() {
			super("Sort");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			// JOptionPane.showMessageDialog(this, "Sort Showed");
			company.sortList();
			topPanel.updateDisplayInformation();
		}

	}

	class AddButton extends JButton implements ActionListener {

		public AddButton() {
			super("Add");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			middlePanel.sendDataFields();
			topPanel.updateDisplayInformation();
			// JOptionPane.showMessageDialog(this, "Add Showed");
		}

	}

	class DeleteButton extends JButton implements ActionListener {

		public DeleteButton() {
			super("Delete");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int input = -9999;
			do {
				try {
					input = Integer
							.parseInt((String) JOptionPane
									.showInputDialog(
											this,
											"Enter only Employee number you wish to delete",
											"",
											JOptionPane.INFORMATION_MESSAGE,
											null, null, ""));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(this,
							"INVALID EMPLOYEE NUMBERS");
				}
			} while (input == -9999);

			int found = company.deleteEmployee(input);

			if (found == 0) {
				topPanel.updateDisplayInformation();
			}
			else {
				JOptionPane.showMessageDialog(this,
						"EMPLOYEE NUMBER " + input + " NOT FOUND");
			}
		}
	}
}
