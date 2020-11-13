package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Ranking;
import main.RankingPlayer;

class rankingTest {

	@Test
	void addPeopleRankingTest() {
		RankingPlayer person1 = new RankingPlayer("persona1", 501);
		RankingPlayer person2 = new RankingPlayer("persona2", 501);
		RankingPlayer person3 = new RankingPlayer("persona3", 501);
		RankingPlayer person4 = new RankingPlayer("persona4", 501);
		RankingPlayer person5 = new RankingPlayer("persona5", 501);
		RankingPlayer person6 = new RankingPlayer("persona6", 501);
		RankingPlayer person7 = new RankingPlayer("persona7", 20);
		RankingPlayer person8 = new RankingPlayer("persona8", 9001);
		RankingPlayer person9 = new RankingPlayer("persona9", 300);
		RankingPlayer person10 = new RankingPlayer("persona10", 501);
		RankingPlayer person11 = new RankingPlayer("persona11", 502);
		
		//5 asserts equal
		assertEquals(person8,getRanking(1));
		assertEquals(person11,getRanking(2));
		assertEquals(person1,getRanking(3));
		assertEquals(person2,getRanking(4));
		assertEquals(person3,getRanking(5));
	}
	
	

}
