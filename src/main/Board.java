package main;

import java.util.Random;

public class Board {

	private int numMines;
	private int maxX;
	private int maxY;
	private Square[][] listSquares;
	
	public Board(int numMines, int maxX, int maxY){
		this.numMines = numMines;
		this.maxX = maxX;
		this.maxY = maxY;
		
		listSquares = new Square[maxX][maxY];
		
		createBoard();
		createMines();
		
	}
	
	public int getNumMines() {return numMines;}
	
	public void setNumMines(String type) {this.numMines = numMines;}
	
	public int getMaxX() {return maxX;}
	
	public void setMaxX(String type) {this.maxX = maxX;}
	
	public int getMaxY() {return maxY;}
	
	public void setMaxY(String type) {this.maxY = maxY;}
	
	
	public void createBoard() {
		
		for(int i=0;i<maxX;i++) {
			for(int j=0;j<maxY;j++) {
				listSquares[i][j] = new Square("number");
			}
		}
	}
	
	
	private int createRandom(int size) {
		Random rand = new Random();
		int random = rand.nextInt(size);
		return random;
		
	}
	
	public void createMines() {
		
		int mines = 0;
		boolean putMine = false;
		
		while (mines<numMines) {
			
			int randX = createRandom(maxX);
			int randY = createRandom(maxY);
			
			if(checkCoordX(randX) && checkCoordY(randY))
			{
				if(listSquares[randX][randY].getTypeObject() == null) {putMine = true;}
				else
				{
					if(listSquares[randX][randY].getTypeObject() == null) {putMine = true;}
					else
					{
						if(listSquares[randX][randY].getTypeObject() == "number") {putMine = true;}
					}					
				}
			}
			
			if(putMine) 
			{
				listSquares[randX][randY].setTypeObject("mine");
				setNumbers(randX, randY);
				mines++;
				putMine = false;
			}
		}	
		
	}
	
	private boolean checkCoordX(int coordX) {return(coordX >= 0 && coordX < maxX);}
	private boolean checkCoordY(int coordY) {return(coordY >= 0 && coordY < maxY);}
	
	private void setNumbers(int X, int Y)
	{
		for(int auxX =X-1; auxX<= X+1; auxX++)
		{
			for(int auxY =Y-1; auxY<= Y+1; auxY++)
			{
				if(checkCoordX(auxX) && checkCoordY(auxY))
				{
					if(listSquares[auxX][auxY].getTypeObject() == null)
					{
						listSquares[auxX][auxY].setNumbers(1);
					}
					else
					{
						if(listSquares[auxX][auxY].getTypeObject() == "number")
						{
							listSquares[auxX][auxY].setNumbers(listSquares[auxX][auxY].getNumber() + 1);
						}
					}
				}
			}
		}
	}
	
	
	public void setSquare(Square square, int X, int Y)
	{
		listSquares[X][Y] = square;	
	}
	
	public Square getSquare(int X, int Y)
	{
		return listSquares[X][Y];
	}
	
	public String getTypeObject(int X, int Y) {
		
		return listSquares[X][Y].getTypeObject();
	}
	
	public boolean isSelected(int X, int Y) {return listSquares[X][Y].isSelected();}
	

	public int getNumber(int x, int y) {return listSquares[x][y].getNumber();}
	
	
	//----------------function for test--------------------------------------------------------------//
	public void setAllSelecetd()
	{
		for(int x=0; x<maxX; x++)
		{
			for(int y=0; y<maxY; y++)
			{
				listSquares[x][y].setSelected(true);
			}				
		}
	}
	
	public void setTypeObject(int X, int Y, String type) {listSquares[X][Y].setTypeObject(type);}
	
	public void setNumbertest(int X, int Y) {this.setNumbers(X, Y);}

	//----------------------------------------------------------------------------------------------//
	
}
