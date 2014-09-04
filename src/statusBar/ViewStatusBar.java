package statusBar;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import learn.MyController;
import learn.MyModel;
import learn.MyView;

public class ViewStatusBar extends JPanel {
	
	//Frame Width and Height
	final int FRAME_WIDTH = 300;
	final int FRAME_HEIGHT = 650;	
	
	public ViewStatusBar()
	{
	JPanel rootPanel = new JPanel();
	rootPanel.setOpaque(true);
	rootPanel.setVisible(true);
	
	JLabel inactiveLabel = new JLabel("Nodes");
	JLabel activeLabel = new JLabel("Active");
	JLabel selectedLabel = new JLabel("Selected");
	
	JTextField inactiveTextField = new JTextField();
	JTextField activeTextField = new JTextField();
	JTextField selectedTextField = new JTextField();
	
	JLabel inactiveStatus = new JLabel("50");
	JLabel activeStatus = new JLabel("10");
	JLabel selectedStatus = new JLabel("1");
		
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
