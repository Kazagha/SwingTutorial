package learn;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class JTreeGUI extends JPanel {

	public JTreeGUI()
	{
		JPanel content = new JPanel(); 
		content.setOpaque(true);
		content.setVisible(true);
		
		JLabel titleLabel = new JLabel("Hierarchy Manager");
		content.add(titleLabel);
		
		JPanel tree = createJTree();
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
							.addComponent(titleLabel)
							.addComponent(tree))
					//.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addContainerGap());
		
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
							.addComponent(titleLabel))	
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup()
							.addComponent(tree))
					.addContainerGap());
	}
	
	private JPanel createJTree()
	{
		//Setup the root Panel
		JPanel rootPanel = new JPanel();
		rootPanel.setLayout(new GridLayout(1,0));
		//rootPanel.setOpaque(true);
		
		//Set the root node 
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Lin Yutang");
		JTree tree = new JTree(top);
		
		//Add Dummy Nodes
		createNodes(top);
				
		//Setup the Scroll Pane
		JScrollPane treeView = new JScrollPane(tree);
		rootPanel.add(treeView);
		
		return rootPanel;
	}
	
	public void createNodes(DefaultMutableTreeNode top)
	{
		DefaultMutableTreeNode book = new DefaultMutableTreeNode();
		//Add Some Dummy Nodes
		book = new DefaultMutableTreeNode("The Importance of Living");
		top.add(book);
		
		book = new DefaultMutableTreeNode("A Leaf in the Storm");
		top.add(book);
		
		book = new DefaultMutableTreeNode("The Wisdom of Laotse");
		top.add(book);
		
		book = new DefaultMutableTreeNode("The Vigil of a Nation");
		top.add(book);
		
		book = new DefaultMutableTreeNode("The Pleasure of a Nonconformist");
		top.add(book);
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
	
	class MyTreeRenderer extends DefaultTreeCellRenderer 
	{
		Icon blue;
		Icon red;
		//ImageIcon blam = new ImageIcon("images/middle.gif");
		MyTreeRenderer()
		{
			blue = new ImageIcon("images/middle.gif");
		}
		
		public Component getTreeCellRendererComponent(
                JTree tree,
                Object value,
                boolean sel,
                boolean expanded,
                boolean leaf,
                int row,
                boolean hasFocus)
		{
			super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
			if(leaf && isStorm(value))
			{
				setIcon(blue);
			}
			return this;
		}
		
		public boolean isStorm (Object obj)
		{
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)obj;
			String name = node.toString().toLowerCase();
			//name.toLowerCase();
			return name.contains("storm");			
		}
		
		
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
