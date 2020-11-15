package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Board;
import main.Printer;

class BoardTest {

	//@Test
	void ConstructorTest() {
		
		int numMines = 25;
		int boardX = 8;
		int boardY = 8;
		
		Board brd = new Board(numMines,boardX,boardY); 

		assertEquals(numMines,brd.getNumMines());
		assertEquals(boardX,brd.getMaxX());
		assertEquals(boardY,brd.getMaxY());
	}
	
	//@Test
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
		board.setTypeObject(2, 2, "mine");
		board.setNumbertest(2, 2);
		
		printer.printBoard(board);
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------Check wrong number(5,3)--------");
		assertEquals(-1, board.openSquare(5, 3));
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------Check wrong number(3,5)--------");
		assertEquals(-1, board.openSquare(3, 5));
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------Check open number(2,3)---------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(2,3);
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("---------Check open empty Square(0,0)------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(0,0);
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------------Second test--------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board = new Board(0,5,5);		
		board.setTypeObject(0,0, "mine");
		board.setNumbertest(0,0);
		board.setTypeObject(0,4, "mine");
		board.setNumbertest(0,4);
		board.setTypeObject(4,0, "mine");
		board.setNumbertest(4,0);
		board.setTypeObject(4,4, "mine");
		board.setNumbertest(4,4);
		
		printer.printBoard(board);	
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("---------Check corner Mines----------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(2,2);
		
		printer.printBoard(board);
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------------Three test---------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board = new Board(0,5,5);
		board.setTypeObject(2,2, "mine");
		board.setTypeObject(0, 0, "mine");
		board.setTypeObject(1, 1,"mine");
		board.setNumbertest(2,2);
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("-------------Check open a mine-------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		assertEquals(0, board.openSquare(2, 2));
		
		printer.printBoard(board);
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------------Four test---------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board = new Board(0,5,5);
		board.setTypeObject(2,2, "mine");
		board.setNumbertest(2,2);
		board.setTypeObject(1, 2, "flag");
		board.setTypeObject(1, 0, "flag");
		board.setTypeObject(0, 1, "flag");
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("-------Check openSquare with flags---------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(0, 0);
		
		printer.printBoard(board);
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("------------------Five test---------------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board = new Board(0,5,5);
		board.setTypeObject(2,2, "mine");
		board.setNumbertest(2,2);
		board.setTypeObject(1, 2, "flag");
		board.setTypeObject(1, 0, "flag");
		board.setTypeObject(0, 1, "flag");
		
		printer.printBoard(board);		
		System.out.println("");
		System.out.println("-------------------------------------------");
		System.out.println("-------Check openSquare with flags---------");
		System.out.println("-------------------------------------------");
		System.out.println("");
		
		board.openSquare(4, 4);
		printer.printBoard(board);
		
	}

}
