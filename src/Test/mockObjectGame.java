package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import main.Board;
import main.Player;
import main.Printer;

public class mockObjectGame implements GameI {
	
	private Player player;
	private main.Board Board;
	private int flag;
	private boolean gameEnd;
	private boolean gameOver;
	private int movX,movY;
	private final static int MIN_POINTS = 10;
	
	private int nITest;

	
	public mockObjectGame(){
		
		this.gameOver = false;
		this.gameEnd = false;
		this.nITest = 1;
	}

	@Override
	public int printMenuStart(Printer printer) {
		
		int option = printer.printMenu();
		return option;
	}

	@Override
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

	@Override
	public int play(Printer printer) {
		 int points = 0, result = 0;
		    int difficulty = printer.printDifficultMenu();
		    
		    gameEnd = false;
		    gameOver = false;
		    
		    while(!gameOver && !gameEnd)
		    {
		    	this.createBoard(difficulty);
		    	
		    	printer.showBoard(Board, getName(), points);
		    	
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
		    	
		    }
		    return points;

	}

	@Override
	public String getName() {
		return player.getName();
	}

	@Override
	public void createBoard(int difficulty) {
		if (difficulty==1) {	
			Board = new Board(0,8,8);
			Board.setTypeObject(4, 4, "mine");
			Board.setNumbertest(4, 4);
		}else {
			if(difficulty==2) {
				Board = new Board(0,16,16);
				Board.setTypeObject(4, 4, "mine");
				Board.setNumbertest(4, 4);
			}else{
				Board = new Board(0,16,30);
				Board.setTypeObject(4, 4, "mine");
				Board.setNumbertest(4, 4);
			}
		}
		
	}

	@Override
	public void askMovement(Printer printer) {
		
		switch (nITest) {
		case 1:
			movX = 1;
			movY = 1;
			flag = 1;
			break;
			
		case 2:
			movX = 1;
			movY = 1;
			flag = 1;
			break;
			
		case 3:
			movX = 1;
			movY = 1;
			flag = 1;
			break;

		default:
			break;
		}


		
	}

}
