package main;

public class Square {
	private String type;
	private int number;
	//private static Object object;
	private boolean selected;
	
	
	public Square()
	{
		
		//object = null;
		this.number = 0;
		this.type = null;
		this.setSelected(false);
	}
	
	public Square(String typeObject)
	{
		this.number = 0;
		this.type = typeObject;
		this.setSelected(false);
		/*if(this.exist(typeObject))
		{
			this.object = new Object(typeObject);
		}
		else
		{
			this.object = null;
		}
		
		this.selected = false;*/
		
		
	}
	
	private boolean exist(String type)
	{
		boolean correct;
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

	/*public static Object getObject() {return object;}
	public void setObject(String type, int number) {this.object = new Object(type, number);}*/

	public boolean isSelected() {return selected;}
	public void setSelected(boolean selected) {this.selected = selected;}

	public String getTypeObject() {
		
		return type;
		/*if (object != null)
		{
			return object.getType();
		}
		else
		{
			return "wrong";
		}*/
		
	}
	
	public void setTypeObject(String type) 
	{
		this.type = type;
		/*if(object == null)
		{
			object = new Object(type);
		}
		else {
			object.setType(type);
		}*/
			
	}
	/*
	public void setNumbers(int number) {object.setNumber(number);}
	public int getNumber() {return object.getNumber();}
	*/	
	public void setNumbers(int number) {this.number = number;}
	public int getNumber() {return number;}
	
	
	
	

}
