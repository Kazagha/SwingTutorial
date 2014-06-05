package learn;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.*;

public class MyView extends JPanel {
	
	JTextField text = new JTextField();
	
	public MyView()
	{
		JPanel rootPanel = new JPanel();
		rootPanel.setOpaque(true);
		rootPanel.setVisible(true);
		
		JLabel titleLabel = new JLabel("This is a view of a text box:");
		rootPanel.add(titleLabel);
		
		text = new JTextField();
		text.setEditable(false);
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup()
						.addComponent(titleLabel)
						.addComponent(text))
				.addContainerGap());
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup()
						.addComponent(titleLabel))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup()
						.addComponent(text))
				.addContainerGap());
	}
	
	private JPanel createContent()
	{
		return new JPanel();
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
