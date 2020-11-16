package main;

import java.util.Scanner;
import main.Board;

public class Printer {
	
	final static char squareNotSlected = 127;
	final static char squareSelected = 160;
	final static char mine = 216;
	final static char flag = 182;
	
	public void showRanking(Ranking rank)
	{
		 int length = rank.numPlayers();
	        for(int pos=1;pos<=length;pos++) {
	            printRanking(rank.getName(pos),rank.getPoints(pos),pos);
	        }
	}
	
	
	
	private void printRanking(String name, int points, int pos) {
		if(pos==1) {
			System.out.println("----------------- RANKING -----------------");
			System.out.println("| --------- Name ------------- Points -----|");
		}
			System.out.println("| ----"+pos+"."+name+"-------------"+points+"---|" );	
	}
	
	public int printMenu()
	{
		printMenuChoose();
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		if(option < 1 || option > 3)
		{
			errorChoose();
			while(option < 1 || option > 3)
			{

				printMenuChoose();
				option = sc.nextInt();
			}
		}
		
		return option;		
	}
	
	public int printDifficultMenu()
    {
        chooseDifficulty();
        Scanner sc = new Scanner(System.in);
        
        int difficulty = sc.nextInt();
        if(difficulty < 1 || difficulty > 3)
        {
            errorChoose();
            while(difficulty < 1 || difficulty > 3)
            {
                chooseDifficulty();
                difficulty = sc.nextInt();
            }
        }
        
        return difficulty;        
    }

    private void chooseDifficulty()
    {
        System.out.println("----------------------------------------------");
        System.out.println("--            Choose your difficult         --");
        System.out.println("----------------------------------------------");
        System.out.println("--            1: Amateur                    --");
        System.out.println("--            2: Medium                     --");
        System.out.println("--            3: Professional               --");
        System.out.println("----------------------------------------------");
       
    }
    
    public void showBoard(Board board, String name, int points)
    {
    	printLine(-1, board.getMaxY(), "_");
    	printHead(name, points);
    	printLine(-1, board.getMaxY(), "_");
    	System.out.println("");
    	
    	printBoard(board);
    }
    
    private void printHead(String name, int points)
    {
    	System.out.println("  Name: " + name );
    	System.out.println("  Points: " + points );
    }
    
	private void printBoard(Board board)
	{
		
		for(int i = -1; i < board.getMaxX(); i ++)
		{
			System.out.print("| ");
			if(i == -1)
			{
				for(int j = -1; j < board.getMaxY(); j++)
				{
					if(j ==-1) {System.out.print("  | ");}
					else {if(j<9) {System.out.print(j+1 + " | ");}
					else {System.out.print(j+1 + "| ");}}
					
				}
				System.out.println("");
				printLine(-1, board.getMaxY(), " ");
			}
			else
			{
				for(int j = -1; j < board.getMaxY(); j++)
				{
					if(j == -1) { 
						if(i<9) {System.out.print(i+1 + " | ");}
						else {System.out.print(i+1 + "| ");}
						}
					else 
					{
						if(board.isSelected(i, j))
						{
							if(board.getSquare(i, j) !=null)
							{
								switch (board.getTypeObject(i, j)) {
								//"mine", "flag","number","empty",
								case "mine":
									System.out.printf("%c", mine);
									break;
								case "wrong":
									System.out.printf("%c",squareSelected);
									break;
								case "number":
									int nAux = board.getNumber(i,j);
									if(nAux != 0) {System.out.print(nAux);}
									else {System.out.printf("%c", squareSelected);}									
									break;
								case "flag":
									System.out.printf("%c",flag);
									break;
								default:
									System.out.printf("%c", squareSelected);
									break;
								}
							}
						}
						else
						{
							if(board.getTypeObject(i, j) == "flag")
							{
								System.out.printf("%c",flag);
							}
							else
							{
								System.out.printf("%c",squareNotSlected);
							}
						}
						System.out.print(" | ");
					}
					

				}
				
				System.out.println("");
				printLine(-1, board.getMaxY(), " ");

			}
		}		
			
	}
	
	public void printGameOver()
	{
		
		System.out.println("----------------------------------------------");
		System.out.println("--                  Game over               --");
		System.out.println("----------------------------------------------");
	}
	
	public void showFarewell(String name)
	{
		System.out.println("----------------------------------------------");
		System.out.println("--    Good bye "+name);
		System.out.println("----------------------------------------------");
	}
	
	private void printLine(int min, int max, String compl)
	{
		System.out.print(" ");
		for (int i = min; i<max; i++)
		{
			System.out.print("___" + compl);

		}
		System.out.println("");
	}
	
	private void printMenuChoose()
	{
		System.out.println("----------------MINESWEEPWER------------------");
		System.out.println("--                                          --");
		System.out.println("--                1. Play                   --");
		System.out.println("--                2. Stats                  --");
		System.out.println("--                3. Leave                 --");
		System.out.println("--                                          --");
		System.out.println("----------------------------------------------");
	}
	private void errorChoose()
	{	System.out.println("----------------------------------------------");
		System.out.println("--             Error: Choose again          --");
		System.out.println("----------------------------------------------");
	}
	
		public void chooseName() {
			
			System.out.println("----------------------------------------------");
			System.out.print("--             Choose yor name:");

		
		
	}

	
	/*** --------------function for test----------------------------- ***/
	
	public void printBoardTest(Board board)
	{
		printBoard(board);
	}
	
	public void printCoordX()
	{
		System.out.println("Write x axis: ");
	}
	
	public void printCoordY()
	{
		System.out.println("Write y axis: ");
	}
	
	public void printFlag()
	{
		System.out.println("Flag? Write 0(put/quit)-1(movement): ");
	}
	




}
