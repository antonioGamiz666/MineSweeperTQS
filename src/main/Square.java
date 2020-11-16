package main;

public class Square {
	private String type;
	private int number;
	private boolean selected;
	private boolean flag;
	
	
	/*public Square()
	{
		
		this.number = 0;
		this.type = "empty";
		this.setSelected(false);
		this.flag = false;
	}*/
	
	public Square(String typeObject)
	{
		this.number = 0;
		setTypeObject(typeObject);
		this.setSelected(false);
		this.flag = false;
	}
	
	private boolean exist(String type)
	{
		switch (type) {
		case "mine":
		case "empty":
		case "flag":
		case "number":
			return true;
		default:
			return false;
		}
	}
	
	public boolean isFlag() {return flag;}
	public void setFlag(boolean flag) {this.flag = flag;}


	public boolean isSelected() {return selected;}
	public void setSelected(boolean selected) {this.selected = selected;}

	public String getTypeObject() {		
		return type;
	}
	
	public void setTypeObject(String type) 
	{
		if(exist(type))
		{
			this.type = type;
			if(type == "mine")
			{
				this.number = -1;
			}
		}
		else
		{
			this.number = 0;
			type = "empty";
		}

	
	}

	public void setNumbers(int number) {this.number = number;}
	public int getNumber() {return number;}
	
	
	
	

}
