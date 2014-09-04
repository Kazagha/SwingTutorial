package statusBar;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Dimension;
import java.security.acl.Group;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import learn.MyController;
import learn.MyModel;
import learn.MyView;

public class ViewStatusBar extends JPanel {
	
	//Frame Width and Height
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 650;	
	
	JButton setButton = new JButton();

	JLabel selectedStatus;
	JLabel activeStatus;
	JLabel inactiveStatus; 
	
	JTextField inactiveTextField;
	JTextField activeTextField;
	JTextField selectedTextField;
	
	public ViewStatusBar()
	{
	JPanel rootPanel = new JPanel();
	rootPanel.setOpaque(true);
	rootPanel.setVisible(true);

	setButton.setText("Set Active");
	setButton.addActionListener(new MyActionListener());
	
	JLabel inactiveLabel = new JLabel("Nodes");
	JLabel activeLabel = new JLabel("Active");
	JLabel selectedLabel = new JLabel("Selected");
	
	inactiveTextField = new JTextField();
	activeTextField = new JTextField();
	selectedTextField = new JTextField();
	
	// Set Item Listener
	MyDocListener listener = new MyDocListener();
	selectedTextField.getDocument().putProperty("owner", selectedTextField);
	selectedTextField.getDocument().addDocumentListener(listener);
	inactiveTextField.getDocument().putProperty("owner", inactiveTextField);
	inactiveTextField.getDocument().addDocumentListener(listener);
	activeTextField.getDocument().putProperty("owner", activeTextField);
	activeTextField.getDocument().addDocumentListener(listener);	
	
	inactiveStatus = new JLabel("---");
	activeStatus = new JLabel("---");
	selectedStatus = new JLabel("---");
	
	//JStatusBar test = new JStatusBar();
	MyStatusBar status = new MyStatusBar();
	status.addRightComponent(inactiveStatus, Color.GRAY);
	status.addRightComponent(activeStatus, Color.ORANGE);
	status.addRightComponent(selectedStatus, Color.GREEN);
	
	status.setLeftComponent(new JLabel("Loading..."));	
	
	GroupLayout layout = new GroupLayout(this);
	setLayout(layout);
	
	layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addComponent(inactiveLabel)
						.addComponent(activeLabel)
						.addComponent(selectedLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addComponent(inactiveTextField)
						.addComponent(activeTextField)
						.addComponent(selectedTextField))
					.addContainerGap()
					)
				.addComponent(status)
				.addComponent(setButton, GroupLayout.Alignment.CENTER)
				);
	
	layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addContainerGap()
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(inactiveLabel)
						.addComponent(inactiveTextField)
						)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(activeLabel)
						.addComponent(activeTextField)
						)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)		
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(selectedLabel)
						.addComponent(selectedTextField)
						)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(setButton)
						)
				
				.addGap(20, 1000, 1000)
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						//.addComponent(test, 23, 23, 23))
						.addComponent(status))
			);
	}
	
	
	public void createAndShowGUI()
	{
		//Create frame setup Window
		JFrame frame = new JFrame();
		frame.setTitle("Status Bar Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(FRAME_HEIGHT, FRAME_WIDTH));
		
		//Add the content  
		frame.getContentPane().add(this);
		
		//Display the window
		frame.pack();
		frame.setVisible(true);		
	}
	
	public class MyActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String tempString = selectedTextField.getText();
			selectedStatus.setText(tempString);
		}
		
	}
	
	public class MyDocListener implements DocumentListener
	{
		
		private JTextField tempTextField = null;

		@Override
		public void changedUpdate(DocumentEvent ev) {
			// Do Nothing
		}

		@Override
		public void removeUpdate(DocumentEvent ev) {
			// Do Nothing
		}

		@Override
		public void insertUpdate(DocumentEvent ev) {
			Object owner = ev.getDocument().getProperty("owner");
			
			if(owner == selectedTextField)
			{
				selectedStatus.setText(selectedTextField.getText());
			} 
			
			if (owner == inactiveTextField) {
				inactiveStatus.setText(inactiveTextField.getText());
			}
			
			if (owner == activeTextField) {
				activeStatus.setText(activeTextField.getText());
			}
		
		}		
	}
	
	public static void main(String args[])
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ViewStatusBar vsb = new ViewStatusBar();
				vsb.createAndShowGUI();
			}
		});	
	}	
}
