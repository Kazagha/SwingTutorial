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
		view.setFetchButton(fetchButton());
	}
	
	public ActionListener fetchButton()
	{
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String tempText = model.getText();
				view.setText(tempText);
			}
		};
	}
}
