package learn;

import java.awt.*;

import javax.swing.*;

public class AlcoholCalculator {
	
	public static void createAndShowGUI()
	{
		JLabel OGLabel = new JLabel("Original Gravity");
		JLabel TGLabel = new JLabel("Terminal Gravity");
		JTextField OGField = new JTextField();
		JTextField TGField = new JTextField();
		JButton calculate = new JButton();
		
		//Create and setup the window
		JFrame frame = new JFrame("Alcohol Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create Menu
		JMenuBar topMenu = new JMenuBar();
		topMenu.setOpaque(true);
		topMenu.setBackground(new Color(154, 165, 127));
		topMenu.setPreferredSize(new Dimension(300, 20));
		
		//Content Pane
		JLabel content = new JLabel();
		content.setOpaque(true);
		content.setPreferredSize(new Dimension(300, 150));
		
		//Add Menu and Content to root frame
		frame.setJMenuBar(topMenu);
		frame.getContentPane().add(content);
		
		//Display the Window
		frame.pack();
		frame.setVisible(true);
	}

	//Calculate the alcohol content using the below formula
	//Where OG is original gravity and TG is terminal gravity
	public double calcAlcoholContent(double OG, double TG) {
		return (((1.05 * (OG - TG)) / TG) / .79);
	} 
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run()
			{
				createAndShowGUI();
			}
		});
	}
}
