package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import main.Printer;

public class Game {
	
	private final static int MIN_POINTS = 10;
	
	private Board Board;
	private Player player;
	private boolean gameOver;
	private boolean gameEnd;
	private int movX,movY,flag;
	
	public Game(){
		
		this.gameOver = false;
		this.gameEnd = false;
	}
		
	public int printMenuStart(Printer printer)
	{
		int option = printer.printMenu();
		return option;
	}
	
	
	public void newPlayer(Printer printer) {
		printer.chooseName();
		try{
	           BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	           String name = bufferRead.readLine();
	           player = new Player(name);

	       }
	       catch(IOException e)
	       {
	           e.printStackTrace();
	       }
	}
	
	public String getName() {return player.getName();}
	
	
	private void createBoard(int difficulty) {

		if (difficulty==1) {	
			Board = new Board(4,8,8); 
		}else {
			if(difficulty==2) {
				Board = new Board(40,16,16); 
			}else{
				Board = new Board(99,16,30); 
			}
		}
	}
	
	public void askMovement(Printer printer) {
		Scanner keyboard = new Scanner(System.in);
		
		boolean check=false;
		
		while(!check) {
			printer.printCoordX();
	        movX = keyboard.nextInt();
	        if(Board.checkCoordX(movX-1)) {
	        	check=true;
	        }
		}
		check = false;
		while(!check) {
			printer.printCoordY();
	        movY = keyboard.nextInt();
	        if(Board.checkCoordY(movY-1)) {
	        	check=true;
	        }
		}
		check=false;
		while(!check) {
			printer.printFlag();
			flag = keyboard.nextInt();
	        if(flag == 0 || flag == 1) {
	        	check=true;
	        }
		}
		
	}
	
		
	public int play(Printer printer){

	    int points = 0, result = 0;
	    int difficulty = printer.printDifficultMenu();
	    
	    
	    while(!gameOver && !gameEnd)
	    {
	    	this.createBoard(difficulty);
	    	printer.showBoard(Board, getName(), points);
	    	
		    gameEnd = false;
		    gameOver = false;
	    	
	    	while(!gameEnd)
	    	{
	    		askMovement(printer);
	    		if(flag == 0)
	    		{
	    			if(!Board.isSelected(movX-1, movY-1)) {
	    				Board.setFlag(movX-1, movY-1);
	    			}
	    		}
	    		else
	    		{
	    			if(!Board.isSelected(movX-1, movY-1) && !Board.getFlag(movX-1, movY-1)) 
	    			{
	    				result = Board.openSquare(movX-1, movY-1);
	    				gameEnd = Board.checkFinish();
	    			}
	    			if(result == 0)
	    			{
	    				gameEnd = true;
	    				gameOver = true;
	    			
	    			}
	    			else
	    			{
	    				if(result == -1)
	    				{
	    					System.out.println("!!!!!!ERROR!!!!!!!!");
	    				}else {
	    					points+=result;
	    				}
	    			}
	    		}
	    		
	    		printer.showBoard(Board, getName(), points);;
	    	}
    		printer.printGameOver();
	    	if(!gameOver)
	    	{
	    		points += (difficulty+1)*MIN_POINTS;
	    	}
	    	gameEnd=false;
	    }
	    return points;

	}
	
	
	/**----------------------------------------------------Functions to test ---------------------------**/
	
	public void askMovementTest(Printer printer) {askMovement(printer);}
	public void createBoardTest() {createBoard(0);}
	
}
