package learn;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AlcoholCalculator {
	
	JLabel totalDisplay = new JLabel();
	
	public AlcoholCalculator()
	{
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{
		JLabel OGLabel = new JLabel("Original Gravity");
		JLabel TGLabel = new JLabel("Terminal Gravity");
		JLabel totalLabel = new JLabel("Alcohol Content:");
		JLabel totalDisplay = new JLabel("0%");
		JTextField OGField = new JTextField(5);
		JTextField TGField = new JTextField(5);
		JButton calculateButton = new JButton();

		
		//Create and setup the window
		JFrame frame = new JFrame("Alcohol Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setup Button
		calculateButton.setText("Calculate");
		calculateButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						percentActionButtonPerformed(evt);
					}
				}
			);
		
		//Create Menu
		JMenuBar topMenu = new JMenuBar();
		topMenu.setOpaque(true);
		topMenu.setBackground(new Color(154, 165, 127));
		topMenu.setPreferredSize(new Dimension(250, 20));
		
		//Content Pane
		JPanel content = new JPanel();
		content.setOpaque(true);
		content.setPreferredSize(new Dimension(250, 125));
				
		content.add(OGLabel);
		content.add(OGField);
		content.add(TGLabel);
		content.add(TGField);
		
		GroupLayout layout = new GroupLayout(content);
		content.setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addComponent(OGLabel)
						.addComponent(TGLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addComponent(OGField)
						.addComponent(TGField)
						.addComponent(calculateButton))
					.addContainerGap()
		);
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(OGLabel)
						.addComponent(OGField))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(TGLabel)
						.addComponent(TGField))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(calculateButton))
				);
		
		//Add Menu and Content to root frame
		frame.setJMenuBar(topMenu);
		frame.getContentPane().add(content);
		
		//Display the Window
		frame.pack();
		frame.setVisible(true);
	}
	
	public void percentActionButtonPerformed(ActionEvent evt)
	{
		totalDisplay.setText("1%");
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
				new AlcoholCalculator();
			}
		});
	}
}
