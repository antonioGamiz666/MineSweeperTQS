package Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Printer;


public class PrinterTest {
	
	//@Test
	void menuTest()
	{
		Printer printer = new Printer();
		
		printer.printMenu();
		assertTrue(true);
		
	}
	
	@Test 
	void boardPrintTest()
	{
		
		//printAllChar();
		Printer printer = new Printer();
		
		//Print all board hide
		Board board = new mockObjectBoard(2, 3, 3);
		printer.printBoard(board);
		assertTrue(true);
		
		//Print all board not hide
		Board board1 = new mockObjectBoard(1, 3, 3);
		printer.printBoard(board1);
		assertTrue(true);
	}
	
	
	void printAllChar()
	{
		for (int i = 0; i<256; i++)
		{
			System.out.println(i +": " + (char)i);
		}
	}

}
