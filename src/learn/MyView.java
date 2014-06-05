package learn;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class MyView extends JPanel {
	
	JPanel content = new JPanel();
	
	public MyView()
	{
		content.setVisible(true);
		content.setOpaque(true);
		
		JLabel titleLabel = new JLabel("This is a view");
		content.add(titleLabel);
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup()
						.addComponent(titleLabel))
				.addContainerGap());
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup()
						.addComponent(titleLabel))
				.addContainerGap());		
	}
	
	private static void createAndShowGUI()
	{
		//Create frame setup Window
		JFrame frame = new JFrame("My View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(250, 150));
		
		//Add the content  
		frame.getContentPane().add(new MyView());
		
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
