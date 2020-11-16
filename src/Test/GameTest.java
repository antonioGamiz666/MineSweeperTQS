package Test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Game;
import main.Printer;


public class GameTest {
	
	
	@Test
	void askMovementTest()
	{
		Printer printer = new Printer();
		Game game = new Game();
		
		game.createBoardTest();
		game.askMovementTest(printer);
	}
	
	

}
