package main;

import java.util.Scanner;

public class Printer {
	
	public int printMenu()
	{
		System.out.println("----------------MINESWEEPWER------------------");
		System.out.println("--                                          --");
		System.out.println("--                1. Play                   --");
		System.out.println("--                2. Stats                  --");
		System.out.println("--                3. Leavve                 --");
		System.out.println("--                                          --");
		System.out.println("----------------------------------------------");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		if(option < 1 || option > 3)
		{
			errorChoose();
			while(option < 1 || option > 3)
			{
				System.out.println("----------------MINESWEEPWER------------------");
				System.out.println("--                                          --");
				System.out.println("--                1. Play                   --");
				System.out.println("--                2. Stats                  --");
				System.out.println("--                3. Leave                 --");
				System.out.println("--                                          --");
				System.out.println("----------------------------------------------");

				option = sc.nextInt();
			}
		}
		
		return option;		
	}
	
	
	
	private void errorChoose()
	{	System.out.println("----------------------------------------------");
		System.out.println("--             Error: Choose again          --");
		System.out.println("----------------------------------------------");
	}

}
