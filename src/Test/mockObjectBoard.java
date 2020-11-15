package Test;

import main.Square;

public class mockObjectBoard implements Board {

	private Square[][] listSquare;
	private int maxX;
	private int maxY;
	
	public mockObjectBoard(int boardTest, int maxX,    int maxY){
		
		listSquare = new Square[maxX][maxY];
		switch (boardTest) {
		
		case 1:
			listSquare[0][0] = new Square("mine");
			listSquare[0][0].setSelected(true);
			listSquare[0][1] = new Square("hi");
			listSquare[0][1].setSelected(true);
			listSquare[0][2] = new Square("flag");
			listSquare[0][2].setSelected(true);
			listSquare[1][0] = new Square("empty");
			listSquare[1][0].setSelected(true);
			listSquare[1][1] = new Square("mine");
			listSquare[1][1].setSelected(true);
			listSquare[1][2] = new Square("fake");
			listSquare[1][2].setSelected(true);
			listSquare[2][0] = new Square("fake");
			listSquare[2][0].setSelected(true);
			listSquare[2][1] = new Square("mine");
			listSquare[2][1].setSelected(true);
			listSquare[2][2] = new Square("number");
			listSquare[2][2].setSelected(true);
			break;
			
		case 2:
			listSquare[0][0] = new Square("mine");
			listSquare[0][1] = new Square("fake");
			listSquare[0][2] = new Square("flag");
			listSquare[1][0] = new Square("empty");
			listSquare[1][1] = new Square("mine");
			listSquare[1][2] = new Square("fake");
			listSquare[2][0] = new Square("fake");
			listSquare[2][1] = new Square("mine");
			listSquare[2][2] = new Square("number");
			break;
		
			
		default:
			break;
		}
		this.maxX = maxX;
		this.maxY = maxY;
    }
	
	
	@Override
	public void setSquare(Square square, int X, int Y) {
		
		listSquare[X][Y] = square;	
		
	}

	@Override
	public Square getSquare(int X, int Y) {
		return listSquare[X][Y];

	}


	@Override
	public int getMaxX() {return maxX;}


	@Override
	public int getMaxY() {return maxY;}


	@Override
	public boolean isSelected(int X, int Y) {return listSquare[X][Y].isSelected();}


	@Override
	public String getTypeObject(int X, int Y) {return listSquare[X][Y].getTypeObject();}


	@Override
	public int getNumber(int i, int j) {
		return listSquare[i][j].getNumber();
	}
	
	

}
