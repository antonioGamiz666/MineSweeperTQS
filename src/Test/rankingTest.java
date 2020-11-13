package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Ranking;

class rankingTest {

	@Test
	void addPeopleRankingTest() {
		
		createRankingPlayer("person1", 501);
		createRankingPlayer("person2", 501);
		createRankingPlayer("person3", 501);
		createRankingPlayer("person4", 501);
		createRankingPlayer("person5", 501);
		createRankingPlayer("person6", 501);
		createRankingPlayer("person7", 20);
		createRankingPlayer("person8", 9001);
		createRankingPlayer("person9", 300);
		createRankingPlayer("person10", 501);
		createRankingPlayer("person11", 502);

		
		//5 asserts equal
		assertEquals("person8",getRanking(1).getName());
		assertEquals("person11",getRanking(2).getName());
		assertEquals("person1",getRanking(3).getName());
		assertEquals("person2",getRanking(4).getName());
		assertEquals("person3",getRanking(5).getName());
	}

}