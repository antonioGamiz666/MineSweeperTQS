package main;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

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
	
	private void newPlayer(int points) {
		System.out.println("Write your name: ");
		try{
	           BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
	           String name = bufferRead.readLine();
	           player.setName(name);
	           ranking.createRankingPlayer(name,points);
	       }
	       catch(IOException e)
	       {
	           e.printStackTrace();
	       }
	}
	
	
	private void createBoard(int difficulty) {
		//Board.Board(numberMines,sizeX,sizeY);
		if (difficulty==0) {	
			Board Board = new Board(4,5,5); 
		}else {
			if(difficulty==1) {
				Board Board = new Board(31,8,8); 
			}else{
				Board Board = new Board(68,1,11); 
			}
		}
	}
	
	private void askMovement() {
		
		Scanner keyboard = new Scanner(System.in);
		
		boolean check=false;
		
		while(!check) {
			System.out.println("Write x axis: ");
	        movX = keyboard.nextInt();
	        if(movX <= Board.getMaxX()) {
	        	check=true;
	        }
		}
		check = false;
		while(!check) {
			System.out.println("Write y axis: ");
	        movY = keyboard.nextInt();
	        if(movY <= Board.getMaxY()) {
	        	check=true;
	        }
		}
		check=false;
		while(!check) {
			System.out.println("Flag? Write 0(yes)-1(no): ");
			flag = keyboard.nextInt();
	        if(flag <= 1) {
	        	check=true;
	        }
		}
	}
		
	public void play(){

	    String type;
	    boolean gameEnd = false;
	    int points = 0;
	    int difficulty = 0;
	    
	    createBoard(difficulty);
	    
	    
	    while(!gameOver && !gameEnd) {
	    	
	        //Pedirle la i y la j y si quiere poner una banderita
	    	askMovement();

	    	
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
}
