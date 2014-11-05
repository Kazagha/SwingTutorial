package learn;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class TestJava2D extends JPanel {

	public TestJava2D()
	{
		JPanel rootPanel = new JPanel();
		rootPanel.setVisible(true);
		rootPanel.setOpaque(true);
		
		setLayout(new BorderLayout());
		rootPanel.add(new JLabel("Grid layout test"));
		
		add(rootPanel, BorderLayout.PAGE_START);
		
		JPanel gridPanel = new JPanel(new FlowLayout());
		gridPanel.add(new Box());
		gridPanel.add(new Box());
		gridPanel.add(new Box());
		gridPanel.add(new Box());	
		
		//add(gridPanel, BorderLayout.SOUTH);
		
		BoxArray ba = new BoxArray(10, 8);
		ba.printInfo();
		add(ba, BorderLayout.CENTER);
	}	
	
	class Box extends Component {
		int x;
		int y; 
		
		public void Box()
		{
			x = 50;
			y = 50;
		}
	}

	class BoxArray extends Component {
		int[][] array;
		Box[][] boxArray;
		
		public BoxArray(int x, int y)
		{
			boxArray = new Box[x][y];
		}
		
		public Dimension getPreferredSize()
		{
			return new Dimension(100, 100);
		}
		
		public void printInfo()
		{
			System.out.println(boxArray.length);
		}
		
		public void drawTest(Graphics2D g2, int x, int y)
		{			
			g2.drawLine(x, y, x + 25, y + 25);
		}
		
		public void drawNorth(Graphics2D g2, int x, int y)
		{			
			g2.drawLine(x, y, x + 48, y + 0);
		}
		
		public void drawSouth(Graphics2D g2, int x, int y)
		{
			g2.drawLine(x + 0, y + 48, x + 48, y + 48);
		}
		
		public void drawEast(Graphics2D g2, int x, int y)
		{
			g2.drawLine(x + 48, y + 0, x + 48, y + 48);
		}
		
		public void drawWest(Graphics2D g2, int x, int y)
		{
			g2.drawLine(x + 0, y + 0, x + 0, y + 48);
		}		
		
		public void paint(Graphics g)
		{
			Graphics2D g2 = (Graphics2D) g;
			
			for(int i = 0; i < boxArray.length; i++)
			{
				for(int j = 0; j < boxArray[i].length; j++)
				{
					drawNorth(g2, i * 50, j * 50);
					drawEast(g2, i * 50, j * 50);
					drawSouth(g2, i * 50, j * 50);
					drawWest(g2, i * 50, j * 50);					
				}
			}
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
	
	public static void main(String[] args)
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
			TestJava2D test = new TestJava2D();
			test.createAndShowGUI();
			}
		});

	}
}

