package learn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyController {
	
	private MyModel model;
	private MyView view;

	public MyController(MyModel model, MyView view)
	{
		this.model = model;
		this.view = view;
		setActions();
	}
	
	public void setActions()
	{
		view.setNextButton(new nextButton());
		view.setPrevButton(new prevButton());
	}
	
	class nextButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.nextText();
			view.setText(model.getText());
		}	
	}
	
	class prevButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0)
		{
			model.prevText();
			view.setText(model.getText());
		}
	}
	
	public static void main(String args[])
	{
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MyModel m = new MyModel();
				MyView v = new MyView();
				
				new MyController(m, v);
				
				v.createAndShowGUI();
			}
		});	
	}
}
