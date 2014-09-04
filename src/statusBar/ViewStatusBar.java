package statusBar;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
	
	JPanel inactivePanel = new JPanel();
	JPanel activePanel = new JPanel();
	JPanel selectedPanel = new JPanel();
	
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
					.addContainerGap())
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addContainerGap()
					)
				);
	
	layout.setVerticalGroup(
			layout.createSequentialGroup()
				.addContainerGap()
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(inactiveLabel)
						)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(activeLabel)
						)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)		
				
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(selectedLabel)
						)
				.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)				
				
				.addContainerGap()			
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
