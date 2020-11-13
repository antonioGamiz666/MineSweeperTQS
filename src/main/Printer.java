package main;

import java.util.Scanner;

public class Printer {
	
	final static char squareNotSlected = 254;
	final static char squareSelected = 32;
	final static char mine = 207;
	final static char flag = 244;
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
	
	public void printBoard(Test.Board board)
	{
		
		for(int i = -1; i < board.getMaxX(); i ++)
		{
			System.out.print("| ");
			if(i == -1)
			{
				for(int j = -1; j < board.getMaxY(); j++)
				{
					if(j ==-1) {System.out.print(" | ");}
					else {System.out.print(j+2 + "| ");}
				}
			}
			else
			{
				for(int j = -1; j < board.getMaxY(); j++)
				{
					if(j == -1) { System.out.print(j+2 + "|");}
					else 
					{
						if(board.isSelected(i, j))
						{
							if(board.getSquare(i, j) !=null)
							{
								switch (board.getTypeObject(i, j)) {
								//"mine", "flag","number","empty",
								case "mine":
									System.out.print(mine);
									break;
								case "wrong":
									System.out.print(squareSelected);
									break;
								case "number":
									System.out.print(/*board.getNumber()*/ "0");
									break;
								case "flag":
									System.out.print(flag);
									break;
								default:
									break;
								}
							}
						}
						else
						{
							if(board.getTypeObject(i, j) == "flag")
							{
								System.out.print(flag);
							}
							else
							{
								System.out.print(squareNotSlected);
							}
						}
						System.out.println("| ");
					}
					

				}
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
