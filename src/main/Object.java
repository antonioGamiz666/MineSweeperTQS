package main;

public class Object {
	private String type = "empty";
	private int number = 0;
	
	public Object(String type){
		this.type = type;
	}
	
	public Object(String type, int number)
	{
		this.type = type;
		this.number = number;
	}
	
	public String getType() {return type;}
	
	public void setType(String type) {this.type = type;}
	public void setNumber(int number) {this.number = number;}
	public int getNumber() {return number;}
}
