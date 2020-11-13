package main;

public class Board {

	private int numMines;
	private int maxX;
	private int maxY;
	
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
}
