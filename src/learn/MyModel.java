package learn;

import java.util.ArrayList;
import java.util.Random;

public class MyModel {
	
	public ArrayList<String> data = new ArrayList<String>();
	private int index = 0;

	public MyModel()
	{
		setDummyText();
	}
	
	public String getText()
	{
		return data.get(index);
	}
	
	public void getNext()
	{
		//int num = new Random().nextInt(data.size());
		//Increment the index
		if(index < data.size())
			{
				index++;
			} else {
				index = 0;
			}		
		getText();
	}
	
	public void setText(String s)
	{
		data.add(s);
	}
	
	public void setDummyText()
	{
		data.add("The Importance Of Living");
		data.add("A Leaf In The Storm");
		data.add("The Wisdome of Laotse");
		data.add("The Vigil of a Nation");
		data.add("The Pleasure of a Nonconformist");
	}

}
