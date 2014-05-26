package learn;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AlcoholCalculator {
	
	JLabel percentValue = new JLabel("0%");
	JTextField OGField = new JTextField(5);
	JTextField TGField = new JTextField(5);
	
	public AlcoholCalculator()
	{
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{
		//Create basic elements
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Create the Alcohol Percent Calculator
		JPanel percentPanel = new JPanel();
		JLabel OGLabel = new JLabel("Original Gravity");
		JLabel TGLabel = new JLabel("Terminal Gravity");
		JLabel percentLabel = new JLabel("Alcohol Content:");
		JButton calculateButton = new JButton();
		
		//Create Drinks per Volume Calculator
		JPanel drinksPanel = new JPanel();
		
		//Create and setup the window
		JFrame frame = new JFrame("Alcohol Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Setup Button
		calculateButton.setText("Calculate");
		calculateButton.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						percentActionButtonPerformed(evt);
					}
				}
			);
		calculateButton.setEnabled(true);
		
		//Create Menu
		JMenuBar topMenu = new JMenuBar();
		topMenu.setOpaque(true);
		topMenu.setBackground(new Color(154, 165, 127));
		topMenu.setPreferredSize(new Dimension(250, 20));
		
		//Content Pane
		JPanel content = new JPanel();
		content.setOpaque(true);
		content.setPreferredSize(new Dimension(250, 150));
		
		//Tabbed Pane
		content.add(tabbedPane);
		tabbedPane.addTab("Percent", percentPanel);
		tabbedPane.addTab("Drinks", drinksPanel);
		
		//Create Basic Layout for the tabbed pane
		GroupLayout contentLayout = new GroupLayout(content);
		content.setLayout(contentLayout);
		
		contentLayout.setHorizontalGroup(
				contentLayout.createSequentialGroup()
				.addComponent(tabbedPane)
				);
		contentLayout.setVerticalGroup(
				contentLayout.createSequentialGroup()
				.addComponent(tabbedPane)
				);

		//Create Layout for Percent Pane
		GroupLayout layout = new GroupLayout(percentPanel);
		percentPanel.setLayout(layout);		
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addComponent(OGLabel)
						.addComponent(TGLabel)
						.addComponent(calculateButton)
						.addComponent(percentLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addComponent(OGField)
						.addComponent(TGField)
						.addComponent(percentValue))
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
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(percentValue)
						.addComponent(percentLabel))
				);
				
		//Add Menu and Content to root frame
		//frame.setJMenuBar(topMenu);
		frame.getContentPane().add(content);
		
		//Display the Window
		frame.pack();
		frame.setVisible(true);
	}
	
	public void percentActionButtonPerformed(ActionEvent evt)
	{
		double OG =  Double.valueOf(OGField.getText());
		double TG = Double.valueOf(TGField.getText());
		double percentage = calcAlcoholContent(OG, TG);
		setPercent(percentage);
	}
	
	public void setPercent(double i)
	{
		percentValue.setText(String.format("%.2f %%", i*100));
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
