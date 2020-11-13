package main;

public class Square {
	
	private static Object object;
	private boolean selected;
	
	
	public Square()
	{
		object = null;
		this.setSelected(false);
	}
	
	public Square(String typeObject)
	{
		if(this.exist(typeObject))
		{
			this.object = new Object(typeObject);
		}
		else
		{
			this.object = null;
		}
		
		this.selected = false;
		
		
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

	public static Object getObject() {return object;}
	public void setObject(Object object) {Square.object = object;}

	public boolean isSelected() {return selected;}
	public void setSelected(boolean selected) {this.selected = selected;}

	public String getTypeObject() {
		
		if (object != null)
		{
			return object.getType();
		}
		else
		{
			return "wrong";
		}
		
	}
	
	public void setTypeObject(String type) {object.setType(type);}
	
	
	
	
	

}
