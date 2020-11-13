package main;

import java.util.Random;

public class Board {

	private int numMines;
	private int maxX;
	private int maxY;
	private Square listSquares[][];
	
	public Board(int numMines, int maxX,	int maxY){
		this.numMines = numMines;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	public int getNumMines() {return numMines;}
	
	public void setNumMines(String type) {this.numMines = numMines;}
	
	public int getMaxX() {return maxX;}
	
	public void setMaxX(String type) {this.maxX = maxX;}
	
	public int getMaxY() {return maxY;}
	
	public void setMaxY(String type) {this.maxY = maxY;}
	
	
	public void createBoard() {
		
		for(int i=0;i<maxX;i++) {
			for(int j=0;j<maxX;j++) {
				listSquares[i][j] = new Square();
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
		
		while (mines<numMines) {
			
			int randX = createRandom(maxX);
			int randY = createRandom(maxY);
			
			if(listSquares[randX][randY].getTypeObject() == null) {
				listSquares[randX][randY].setTypeObject("mine");
				mines++;
			}			
		}	
	}
	
}
