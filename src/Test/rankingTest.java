package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Ranking;
import main.RankingPlayer;

class rankingTest {

	@Test
	void addPeopleRankingTest() {
		String name = "person1";
		int points = 501;

		createRankingPlayer(name, points);
		/*RankingPlayer person2 = new RankingPlayer("person2", 501);
		RankingPlayer person3 = new RankingPlayer("person3", 501);
		RankingPlayer person4 = new RankingPlayer("person4", 501);
		RankingPlayer person5 = new RankingPlayer("person5", 501);
		RankingPlayer person6 = new RankingPlayer("person6", 501);
		RankingPlayer person7 = new RankingPlayer("person7", 20);
		RankingPlayer person8 = new RankingPlayer("person8", 9001);
		RankingPlayer person9 = new RankingPlayer("person9", 300);
		RankingPlayer person10 = new RankingPlayer("person10", 501);
		RankingPlayer person11 = new RankingPlayer("person11", 502);*/
		
		//5 asserts equal
		assertEquals(name,getRanking(1).getName());
		/*assertEquals(person11,getRanking(2));
		assertEquals(person1,getRanking(3));
		assertEquals(person2,getRanking(4));
		assertEquals(person3,getRanking(5));*/
	}



}
