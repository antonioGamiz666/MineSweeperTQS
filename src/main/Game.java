package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import main.Printer;

public class Game {
	
	Board Board;
	Printer printer;
	Ranking ranking;
	Player player;
	boolean gameOver;
	boolean gameEnd;
	int movX,movY,flag;
	
	public Game(){
		
		this.gameOver = false;
		this.gameEnd = false;
	}
	
	public static void main(String[] arg)
	{
		Printer printer = new Printer();
		Game game = new Game();
				
		int play = game.printMenuStart(printer);
		if(play == 1)
		{
			game.newPlayer();
			game.play(printer);
		}
		
		//game.showFarewell
		
		
	}
	
	
	public int printMenuStart(Printer printer)
	{
		int option = printer.printMenu();
		switch (option) {
		case 2:
			//showStats()
			option = printer.printMenu();
			break;
		case 3:
			//showFarewell()
			gameEnd = true;
			break;

		}
		return option;
		
		
	}
	
	private void printRanking() {
        
        int length = ranking.numPlayers();
        for(int pos=1;pos<length;pos++) {
            printer.printRanking(ranking.getName(pos),ranking.getPoints(pos),pos);
        }
    }
	
	private void showMineMap(){
	    int boardX = Board.getMaxX();
	    int boardY = Board.getMaxY();
	    String type;

	    for(int i=0;i<boardX;i++){
	        for(int j=0;j<boardY;j++){
	            type = Board.getTypeObject(i,j);
	            if(type=="mine"){
	                Board.isSelected(i,j); ////////// ¿¿Cuál es la función que abre la casilla??
	            }
	        }
	    }
	}
	
	public void newPlayer(/*int points*/) {
		System.out.println("Write your name: ");
		try{
	           BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	           String name = bufferRead.readLine();
	           player = new Player(name);
	           //player.setName(name);
	           //ranking.createRankingPlayer(name,points);
	       }
	       catch(IOException e)
	       {
	           e.printStackTrace();
	       }
	}
	
	
	private void createBoard(int difficulty) {
		//Board.Board(numberMines,sizeX,sizeY);
		if (difficulty==0) {	
			Board = new Board(10,8,8); 
		}else {
			if(difficulty==1) {
				Board = new Board(40,16,16); 
			}else{
				Board = new Board(99,16,30); 
			}
		}
	}
	
	private void askMovement() {
		
		Scanner keyboard = new Scanner(System.in);
		
		boolean check=false;
		
		while(!check) {
			System.out.println("Write x axis: ");
	        movX = keyboard.nextInt();
	        if(Board.checkCoordX(movX)) {
	        	check=true;
	        }
		}
		check = false;
		while(!check) {
			System.out.println("Write y axis: ");
	        movY = keyboard.nextInt();
	        if(Board.checkCoordY(movY)) {
	        	check=true;
	        }
		}
		check=false;
		while(!check) {
			System.out.println("Flag? Write 0(yes)-1(no): ");
			flag = keyboard.nextInt();
	        if(flag == 0 || flag == 1) {
	        	check=true;
	        }
		}
	}
	
		
	public void play(Printer printer){

	    String type;
	    //boolean gameEnd = false;
	    int points = 0;
	    int difficulty = printer.printDifficultMenu();
	    
	    while(!gameOver)
	    {
	    	this.createBoard(difficulty);
	    	while(!gameEnd)
	    	{
	    		askMovement();
	    	}
	    }
	    
	    
	    
	    
	    while(!gameOver && !gameEnd) {
	    	
	        //Pedirle la i y la j y si quiere poner una banderita
	    		    	
	        //hacer esto solo si no ha puesto una bandera	        
	        type = Board.getTypeObject(i,j);

	        if(type=="number") {
	        	//llamar funcion recursiva
	        	//gameEnd= llamar funcion si se ha completado el juego
	        	
	        }else {
	        	if(type=="flag") {
	        		//llamar funcion poner/quitar flag
	        	}else{
	        		//llamar funcion poner mina
	        		gameOver= true;
	        	}
	        }
	        Printer.printBoard(Board);
	    }

	    if(gameOver){
	        showMineMap();
	        Printer.printBoard(Board);
	        newPlayer(points);
	    }else{
	    	newPlayer(points);
	    }
	}
	
	/**----------------------------------------------------Functions to test ---------------------------**/
	
	public void askMovementTest() {askMovement();}
	public void createBoardTest() {createBoard(0);}
	
}
