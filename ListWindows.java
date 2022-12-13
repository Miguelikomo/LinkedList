import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ListWindows extends JFrame {
	
	LinkedList list = new LinkedList();
	
	JButton insert = new JButton("Insert");
	JButton remove = new JButton("Remove");
	JTextField data= new JTextField(30);
	JLabel  dataLabel = new JLabel("New Data:");
	JLabel flabel= new JLabel("Insert at: Front");
	JLabel rlabel= new JLabel("  Rear");
	JRadioButton insertFront = new JRadioButton();
	JRadioButton insertRear  = new JRadioButton();
	ButtonGroup insertGroup = new ButtonGroup();
	JButton printList = new JButton("Print List");
	
	JPanel panel = new JPanel();
	
	public ListWindows() {
		setSize(500,300);
		setTitle("Linked List Control Window");
		panel.add(dataLabel);
		panel.add(data);
		panel.add(insert);
		panel.add(remove);
		panel.add(flabel);
		panel.add(insertFront);
		insert.addActionListener(new InsertListener());
		remove.addActionListener(new RemoveListener());
		panel.add(rlabel);
		panel.add(insertRear);
		insertGroup.add(insertFront);
		insertGroup.add(insertRear);
		panel.add(printList);
		printList.addActionListener(new PrintListener());
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ListWindows();
	}

	class InsertListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (insertFront.isSelected()) {
				System.out.println("Inserting at front");
				list.insertFront(data.getText());
				data.setText("");
			}
			if (insertRear.isSelected()) {
				System.out.println("Insert at rear");
				list.insertRear(data.getText());
				data.setText("");
			}
		}
	}
	
	class RemoveListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (insertFront.isSelected()) {
				System.out.println("Removing: "+list.removeFront());
			}
			if (insertRear.isSelected()) {
				System.out.println("Removing: "+list.removeRear());
			}			
		}
		
	}
	
	class PrintListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			list.print();
		}
		
	}
}
