package Test;

import main.Square;

public class mockObjectBoard implements Board {

	private Square listSquare[][];
	public mockObjectBoard(int numMines, int maxX,    int maxY){
		
		listSquare = new Square[maxX][maxY];
		switch (numMines) {
		case 1:
			listSquare[0][0] = new Square("mine");
			listSquare[0][1] = new Square();
			listSquare[0][2] = new Square("flag");
			listSquare[1][0] = new Square("empty");
			listSquare[1][1] = new Square("mine");
			listSquare[1][2] = new Square();
			listSquare[2][0] = new Square();
			listSquare[2][1] = new Square("mine");
			listSquare[2][2] = new Square("number");
			break;
		
			
		default:
			break;
		}
    }
	
	
	@Override
	public void setSquare(Square square, int X, int Y) {
		
		listSquare[X][Y] = square;	
		
	}

	@Override
	public Square getSquare(int X, int Y) {
		return listSquare[X][Y];

	}
	
	

}
