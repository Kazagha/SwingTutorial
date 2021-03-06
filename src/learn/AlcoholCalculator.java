package learn;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AlcoholCalculator {
	
	JPanel content = new JPanel();
	JLabel percentValue = new JLabel("0%");
	JLabel stdDrinksValue = new JLabel("-");
	JTextField OGField = new JTextField(5);
	JTextField TGField = new JTextField(5);
	JTextField percentField = new JTextField(5);
	JTextField volumeField = new JTextField(5);
	
	public AlcoholCalculator()
	{
		createAndShowGUI();
	}
	
	public void createAndShowGUI()
	{
		//Create basic elements
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//Create and setup the window
		JFrame frame = new JFrame("Alcohol Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create Menu
		JMenuBar topMenu = createMenu();
		
		//Content Pane
		//JPanel content = new JPanel();
		content.setOpaque(true);
		content.setPreferredSize(new Dimension(250, 150));
		
		//Tabbed Pane
		content.add(tabbedPane);
		tabbedPane.addTab("Percent", makePercentPanel());
		tabbedPane.addTab("Drinks", makeDrinksPanel());
		
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
			
		//Add Menu and Content to root frame
		frame.setJMenuBar(topMenu);
		frame.getContentPane().add(content);
		
		//Display the Window
		frame.pack();
		frame.setVisible(true);
	}
	
	protected JPanel makePercentPanel()
	{
		//Create Swing Components
		JPanel panel = new JPanel();
		JLabel OGLabel = new JLabel("Original Gravity");
		JLabel TGLabel = new JLabel("Terminal Gravity");
		JLabel percentLabel = new JLabel("Alcohol Content:");
		JButton calculateButton = new JButton();
				
		//Create Layout for Percent Pane
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);	
				
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addComponent(OGLabel)
						.addComponent(TGLabel)
						.addComponent(percentLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addComponent(OGField)
						.addComponent(TGField)
						.addComponent(percentValue)
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
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(percentValue)
						.addComponent(percentLabel))
				);
		
		//Setup Calculate Button
		calculateButton.setText("Calculate");
		calculateButton.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						try {
							double OG =  Double.valueOf(OGField.getText());
							double TG = Double.valueOf(TGField.getText());
							double percentage = calcAlcoholContent(OG, TG);
							setPercent(percentage);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(content, "Invalid Input:\n Please enter a number ", "Input Error",
									JOptionPane.ERROR_MESSAGE);	
						}
					}
				}
			);
		calculateButton.setEnabled(true);
		calculateButton.setToolTipText("Calculate the percentage alcohol content");
		
		return panel;
	}
	
	protected JPanel makeDrinksPanel()
	{
		JPanel panel = new JPanel();
		panel.setOpaque(true);
		
		JLabel volumeLabel = new JLabel("Volume (ml)");
		JLabel percentLabel = new JLabel("Alcohol %");
		JButton calculateButton = new JButton("Calculate");
		JLabel stdDrinksLabel = new JLabel("Standard Drinks:");
		//percentField volumeFiedl stdDrinksValue
		
		calculateButton.addActionListener(
				new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent evt)
					{
						try {
							double percent = Double.valueOf(percentField.getText());
							double volume = Double.valueOf(volumeField.getText());
							double valueDouble = calcStdDrinks(percent, volume);
							String valueString = String.format("%.2f", valueDouble);
							stdDrinksValue.setText(String.valueOf(valueString));
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(content, "Invalid Input:\n Please enter a number ", "Input Error",
									JOptionPane.ERROR_MESSAGE);							
						}
					}
				});
		calculateButton.setToolTipText("Calculate number of standard drinks");
		
		GroupLayout layout = new GroupLayout(panel);
		panel.setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addComponent(volumeLabel)
						.addComponent(percentLabel)
						.addComponent(stdDrinksLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
						.addComponent(volumeField)
						.addComponent(percentField)
						.addComponent(calculateButton)
						.addComponent(stdDrinksValue))
					.addContainerGap()
				);
				
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(percentLabel)
					.addComponent(percentField))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(volumeLabel)
					.addComponent(volumeField))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(calculateButton))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					.addComponent(stdDrinksLabel)
					.addComponent(stdDrinksValue))
				.addContainerGap()
				);
		
		return panel;
	}
	
	protected JMenuBar createMenu()
	{
		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(true);
		//menuBar.setBackground(new Color(190, 190, 190));
		menuBar.setPreferredSize(new Dimension(250, 20));
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenu formulaSubmenu = new JMenu("Formula");
		menu.add(formulaSubmenu);
		
		JMenuItem alcoholFormula = new JMenuItem("Alcohol Content");
		alcoholFormula.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tempText = String.format("Alcohol contenet is calculated using the below formula%n"
						+ "where OG is Original Gravity and TG is Terminal Gravity%n"
						+ "((1.05 * (OG - TG)) / TG) / .79");
				JOptionPane.showMessageDialog(content, tempText, 
						"Alcohol Content Formula", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		formulaSubmenu.add(alcoholFormula);
		
		JMenuItem drinksFormula = new JMenuItem("Standard Drinks");
		drinksFormula.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tempText = String.format(
						  "Calculate the standard number of drinks%n"
						+ "where .789 is the specific gravity of alcohol%n"
						+ "375ml drink at 5%% multiplied by .789 equals 1.5 standard drinks%n"
						+ "0.375 X 5 X 0.789 = 1.5 standard drinks");
				JOptionPane.showMessageDialog(content, tempText, 
						"Standard Drinks Formula", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		formulaSubmenu.add(drinksFormula);
				
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		menu.add(exit);		
		
		return menuBar;
	}
	
	public void percentActionButtonPerformed(ActionEvent evt)
	{
		double OG =  Double.valueOf(OGField.getText());
		double TG = Double.valueOf(TGField.getText());
		double percentage = calcAlcoholContent(OG, TG);
		percentValue.setText(String.format("%.2f %%", percentage*100));
	}
	
	public void setPercent(double i)
	{
		percentValue.setText(String.format("%.2f %%", i*100));
	}

	/**
	 * Calculate Alcohol Content <br>
	 * Calculate the alcohol content using the below formula <br>
	 * Where OG is original gravity and TG is terminal gravity
	 * @param OG - Original Gravity 
	 * @param TG - Terminal Gravity
	 * @return - The alcohol content 
	 */
	public double calcAlcoholContent(double OG, double TG) {
		return (((1.05 * (OG - TG)) / TG) / .79);
	} 
	
	/**
	 * Calculate Standard Drinks 
	 * Calculate the standard number of drinks using volume of the drink and percentage alcohol content
	 * 375ml drink at 5% multiplied by .789 equals 1.5 standard drinks
	 * 0.375 X 5 X 0.789 = 1.5 standard drinks
	 * @param vol - Volume in ml
	 * @param percent - Percent Alcohol
	 * @return - Number of standard drinks
	 */
	private double calcStdDrinks (double vol, double percent) {
		return ((vol/1000) * percent * .789);
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
