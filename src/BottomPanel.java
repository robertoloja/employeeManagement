import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//The bottom area will provide a panel with buttons for reset to original data,
//display, sort, add and delete. You can use a single listener and then check the buttons
//with an if statement or create individual listeners.

public class BottomPanel extends JPanel {
	JButton displayButton;
	JButton sortButton;
	JButton addButton;
	JButton deleteButton;

	public BottomPanel() {

		setLayout(new FlowLayout());
		displayButton = new DisplayButton();
		sortButton = new SortButton();
		addButton = new AddButton();
		deleteButton = new DeleteButton();

		add(displayButton);
		add(sortButton);
		add(addButton);
		add(deleteButton);

	}

	class DisplayButton extends JButton implements ActionListener {

		public DisplayButton() {
			super("Display");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(this, "Display Showed");
		}

	}

	class SortButton extends JButton implements ActionListener {

		public SortButton() {
			super("Sort");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(this, "Sort Showed");
		}

	}

	class AddButton extends JButton implements ActionListener {

		public AddButton() {
			super("Add");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(this, "Add Showed");
		}

	}

	class DeleteButton extends JButton implements ActionListener {

		public DeleteButton() {
			super("Delete");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(this, "Delete Showed");
		}

	}
}
