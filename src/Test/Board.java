package Test;

import main.Square;

public interface Board {

	public void setSquare(Square square, int X, int Y);
	public Square getSquare(int X, int Y);
	public int getMaxX();
	public int getMaxY();
	public boolean isSelected(int X, int Y);
	public String getTypeObject(int X, int Y);
	

}
