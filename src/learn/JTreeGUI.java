package learn;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class JTreeGUI extends JPanel {

	public JTreeGUI()
	{
		JPanel content = new JPanel(); 
		content.setOpaque(true);
		content.setVisible(true);
		
		JLabel titleLabel = new JLabel("Hierarchy Manager");
		content.add(titleLabel);
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel)
					.addContainerGap());
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLabel)
					.addContainerGap());
	}
	
	private JPanel createJTree()
	{
		JPanel rootPanel = new JPanel();
		
		return rootPanel;
	}
	
	private static void createAndShowGUI()
	{
		//Create frame setup Window
		JFrame frame = new JFrame("Hierarchy Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(250, 150));
		
		//Add Content
		frame.add(new JTreeGUI(), BorderLayout.CENTER);
		
		//Display the window
		frame.pack();
		frame.setVisible(true);		
	}
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
