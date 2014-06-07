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
		
		//Create the JTree
		JTree tree = new JTree(top);
		tree.setCellRenderer(new MyTreeRenderer());
		
		//Add Dummy Nodes
		createNodes(top);
				
		//Setup the Scroll Pane
		JScrollPane treeView = new JScrollPane(tree);
		rootPanel.add(treeView);
		
		return rootPanel;
	}
	
	public void createNodes(DefaultMutableTreeNode top)
	{
		DefaultMutableTreeNode book;
		//Add Some Dummy Nodes
	
		book = new DefaultMutableTreeNode(new bookData("The Importance of Living", true));
		top.add(book);
		
		book = new DefaultMutableTreeNode(new bookData("A Leaf in the Storm", true));
		top.add(book);
		
		book = new DefaultMutableTreeNode(new bookData("The Wisdom of Laotse", true));
		top.add(book);
		
		book = new DefaultMutableTreeNode(new bookData("The Vigil of a Nation", false));
		top.add(book);
		
		book = new DefaultMutableTreeNode(new bookData("The Pleasure of a Nonconformist", false));
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
		Icon green;
		Icon book;
		MyTreeRenderer()
		{
			blue = new ImageIcon("images/middle.gif");
			book = new ImageIcon("images/books.jpg");
			green = new ImageIcon("images/checkmarkgreen.gif");
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
			
			//Set all leaf nodes icons to a book
			if(leaf)
			{
				setIcon(book);
			}
			
			//Set 'tick' icon on read books
			if(leaf && isRead(value))
			{
				setIcon(green);
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
		
		/**
		 * Check if the specified book node has been read
		 * @param obj - Specified Node
		 * @return boolean - true if book has been read
		 */
		public boolean isRead (Object obj)
		{			
			DefaultMutableTreeNode node = (DefaultMutableTreeNode)obj;
			if(node.getUserObject() instanceof bookData)
			{
				bookData nodeInfo = (bookData)node.getUserObject();
				return nodeInfo.isRead();
			} else {
				return false;
			}

		}
	}
	
	class bookData {
		public String bookName;
		public boolean read;
		
		bookData(String bookName, boolean read)
		{
			this.bookName = bookName;
			this.read = read;
		}
		
		public String getName()
		{
			return bookName;
		}
		
		public String toString()
		{
			return bookName;
		}
		
		public boolean isRead()
		{
			return read;
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
