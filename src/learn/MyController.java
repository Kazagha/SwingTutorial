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
		this.view.setNextButton(new nextButton());
	}
	
	public void setActions()
	{
		view.setNextButton(new nextButton());
	}
	
	class nextButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			//String tempText = model.getText();
			//view.setText(tempText);
			view.setText("Controller Test Action");
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
