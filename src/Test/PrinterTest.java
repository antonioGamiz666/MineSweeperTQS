package Test;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Printer;


public class PrinterTest {
	
	@Test
	void menuTest()
	{
		Printer printer = new Printer();
		
		printer.printMenu();
		assertTrue(true);
		
	}
	
	@Test boardPrintTest()
	{
		Printer printer = new Printer();
		 Board board = new mockObjectBoard(2, 3, 3);
		
		printer.printBoard(board);
	}

}
