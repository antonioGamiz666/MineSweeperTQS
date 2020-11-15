package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import main.Board;
import main.Printer;

class BoardTest {

	@Test
	void ConstructorTest() {
		
		int numMines = 7;
		int boardX = 8;
		int boardY = 12;
		
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
		
		Board board = new Board(7,10,10);
		board.setAllSelecetd();
		
		print.printBoard(board);
		
		int check = sc.nextInt();
		
		assertTrue(1==check);
	}

}
