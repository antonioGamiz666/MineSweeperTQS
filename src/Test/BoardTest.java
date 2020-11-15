package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Board;
import main.Printer;

class BoardTest {

	@Test
	void ConstructorTest() {
		
		int numMines = 25;
		int boardX = 8;
		int boardY = 8;
		
		Board brd = new Board(numMines,boardX,boardY); 

		assertEquals(numMines,brd.getNumMines());
		assertEquals(boardX,brd.getMaxX());
		assertEquals(boardY,brd.getMaxY());
	}
	
	@Test
	void setNumbersTest()
	{
		Printer print = new Printer();
		Scanner sc = new Scanner(System.in);
		
		Board board = new Board(25,10,10);
		board.setAllSelecetd();
		
		print.printBoard(board);
		
		int check = sc.nextInt();
		
		assertTrue(1==check);
	}
	
	@Test
	void openSquaretest()
	{
		Printer printer = new Printer();
		System.out.println("--------------------First test--------------");
		
		Board board = new Board(0,5,5);		
		board.setTypeObject(3, 3, "mine");
		board.setNumbertest(3, 3);
		
		printer.printBoard(board);
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------Check open number(4,5)---------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(4,5);
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("---------Check open empty Square(1,1)------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(1,1);
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------------Second test--------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board = new Board(0,5,5);		
		board.setTypeObject(0,0, "mine");
		board.setNumbertest(0,0);
		board.setTypeObject(0,5, "mine");
		board.setNumbertest(0,5);
		board.setTypeObject(5,0, "mine");
		board.setNumbertest(5,0);
		board.setTypeObject(5,5, "mine");
		board.setNumbertest(5,5);
		
		printer.printBoard(board);	
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("---------Check corner Mines----------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(3,3);
		printer.printBoard(board);
		
		
	}

}
