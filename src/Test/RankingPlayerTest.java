package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.RankingPlayer;

class RankingPlayerTest {

	@Test
	void ConstructorTest() {
		
		String name = "Julia";
		int points = 580;
		
		RankingPlayer rp = new RankingPlayer(name,points);
		
		assertEquals(name,rp.getName());
		assertEquals(points,rp.getPoints());
	}

}
