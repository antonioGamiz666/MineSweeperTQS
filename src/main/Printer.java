package main;

import java.util.Scanner;
import main.Board;

public class Printer {
	
	final static char squareNotSlected = 127;
	final static char squareSelected = 160;
	final static char mine = 216;
	final static char flag = 182;
	final
	
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
	
	public void printBoard(Board board)
	{
		
		for(int i = -1; i < board.getMaxX(); i ++)
		{
			System.out.print("| ");
			if(i == -1)
			{
				for(int j = -1; j < board.getMaxY(); j++)
				{
					if(j ==-1) {System.out.print(" | ");}
					else {System.out.print(j+1 + "| ");}
					
				}
				System.out.println("");
			}
			else
			{
				for(int j = -1; j < board.getMaxY(); j++)
				{
					if(j == -1) { System.out.print(i+1 + "| ");}
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
						System.out.print("| ");
					}
					

				}
				
				System.out.println("");
			}
		}
				
			
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


}
