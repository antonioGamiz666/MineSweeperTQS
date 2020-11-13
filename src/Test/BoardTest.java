package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Board;

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

}
