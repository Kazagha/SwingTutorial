package learn;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class MyView extends JPanel {
	
	JTextField text = new JTextField();
	JButton nextButton = new JButton("Next");
	JButton prevButton = new JButton("Prev");
	
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
						.addComponent(text)
						.addGroup(Alignment.CENTER, layout.createSequentialGroup()
							.addComponent(prevButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(nextButton)))
				.addContainerGap());
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addContainerGap()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(titleLabel))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup()
						.addComponent(text))
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(prevButton)
						.addComponent(nextButton))
				.addContainerGap());
	}

	public void setNextButton(ActionListener a)
	{
		nextButton.addActionListener(a);
	}
	
	public void setPrevButton(ActionListener a)
	{
		prevButton.addActionListener(a);
	}
	
	public void setText(String s)
	{
		text.setText(s);
	}
	
	class test implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			text.setText("Test Action");
		}
	}

	public void createAndShowGUI()
	{
		//Create frame setup Window
		JFrame frame = new JFrame("My View");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(250, 150));
		
		//Add the content  
		frame.getContentPane().add(this);
		
		//Display the window
		frame.pack();
		frame.setVisible(true);		
	}
}
