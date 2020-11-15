package Test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Game;


public class GameTest {
	
	
	@Test
	void askMovementTest()
	{
		Game game = new Game();
		
		game.createBoardTest();
		game.askMovementTest();
	}
	
	

}
