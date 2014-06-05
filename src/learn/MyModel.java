package learn;

import java.util.ArrayList;
import java.util.Random;

public class MyModel {
	
	public ArrayList<String> data = new ArrayList<String>();

	public MyModel()
	{
		setDummyText();
	}
	
	public String getText()
	{
		int num = new Random().nextInt(data.size());
		return data.get(num);
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
