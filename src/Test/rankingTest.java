package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Ranking;

class rankingTest {

	@Test
	void addOne() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 502);

        assertEquals("person1",ranking.getRanking(1).getName());
	}
	
	@Test
	void OrderTwoTest1() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 500);
        ranking.createRankingPlayer("person2", 501);

        assertEquals("person2",ranking.getRanking(1).getName());
        assertEquals("person1",ranking.getRanking(2).getName());
	}
	
	@Test
	void OrderTwoTest2() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 500);
        ranking.createRankingPlayer("person2", 499);

        assertEquals("person1",ranking.getRanking(1).getName());
        assertEquals("person2",ranking.getRanking(2).getName());
	}
	
	void OrderTwoTest3() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 500);
        ranking.createRankingPlayer("person2", 500);

        assertEquals("person1",ranking.getRanking(1).getName());
        assertEquals("person2",ranking.getRanking(2).getName());
	}
	
	@Test
	void OrderFourTest() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 500);
        ranking.createRankingPlayer("person2", 300);
        ranking.createRankingPlayer("person3", 900);
        ranking.createRankingPlayer("person4", 600);

        //4 asserts equal
        assertEquals("person3",ranking.getRanking(1).getName());
        assertEquals("person4",ranking.getRanking(2).getName());
        assertEquals("person1",ranking.getRanking(3).getName());
        assertEquals("person2",ranking.getRanking(4).getName());
	}
	
	@Test
	void OrderFiveTest1() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 500);
        ranking.createRankingPlayer("person2", 300);
        ranking.createRankingPlayer("person3", 900);
        ranking.createRankingPlayer("person4", 400);
        ranking.createRankingPlayer("person5", 600);

        //5 asserts equal
        assertEquals("person3",ranking.getRanking(1).getName());
        assertEquals("person5",ranking.getRanking(2).getName());
        assertEquals("person1",ranking.getRanking(3).getName());
        assertEquals("person4",ranking.getRanking(4).getName());
        assertEquals("person2",ranking.getRanking(5).getName());

	}
	
	@Test
	void OrderFiveTest2() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 700);
        ranking.createRankingPlayer("person2", 100);
        ranking.createRankingPlayer("person3", 20);
        ranking.createRankingPlayer("person4", 700);
        ranking.createRankingPlayer("person5", 20);

        //5 asserts equal
        assertEquals("person1",ranking.getRanking(1).getName());
        assertEquals("person4",ranking.getRanking(2).getName());
        assertEquals("person2",ranking.getRanking(3).getName());
        assertEquals("person3",ranking.getRanking(4).getName());
        assertEquals("person5",ranking.getRanking(5).getName());

	}
	
	@Test
	void OrderFiveTest3() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 10);
        ranking.createRankingPlayer("person2", 15);
        ranking.createRankingPlayer("person3", 10);
        ranking.createRankingPlayer("person4", 30);
        ranking.createRankingPlayer("person5", 11);

        //5 asserts equal
        assertEquals("person4",ranking.getRanking(1).getName());
        assertEquals("person2",ranking.getRanking(2).getName());
        assertEquals("person5",ranking.getRanking(3).getName());
        assertEquals("person1",ranking.getRanking(4).getName());
        assertEquals("person3",ranking.getRanking(5).getName());

	}
	
	@Test
	void addLastTest() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 515);
        ranking.createRankingPlayer("person2", 514);
        ranking.createRankingPlayer("person3", 513);
        ranking.createRankingPlayer("person4", 512);
        ranking.createRankingPlayer("person5", 500);
        ranking.createRankingPlayer("person6", 501);


        //5 asserts equal
        assertEquals("person1",ranking.getRanking(1).getName());
        assertEquals("person2",ranking.getRanking(2).getName());
        assertEquals("person3",ranking.getRanking(3).getName());
        assertEquals("person4",ranking.getRanking(4).getName());
        assertEquals("person6",ranking.getRanking(5).getName());
	}

	@Test
	void addFirstTest() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 515);
        ranking.createRankingPlayer("person2", 514);
        ranking.createRankingPlayer("person3", 513);
        ranking.createRankingPlayer("person4", 512);
        ranking.createRankingPlayer("person5", 511);
        ranking.createRankingPlayer("person6", 900);


        //5 asserts equal
        assertEquals("person6",ranking.getRanking(1).getName());
        assertEquals("person1",ranking.getRanking(2).getName());
        assertEquals("person2",ranking.getRanking(3).getName());
        assertEquals("person3",ranking.getRanking(4).getName());
        assertEquals("person4",ranking.getRanking(5).getName());
	}
	
	@Test
	void addMiddleTest() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 515);
        ranking.createRankingPlayer("person2", 514);
        ranking.createRankingPlayer("person3", 513);
        ranking.createRankingPlayer("person4", 512);
        ranking.createRankingPlayer("person5", 511);
        ranking.createRankingPlayer("person6", 514);


        //5 asserts equal
        assertEquals("person1",ranking.getRanking(1).getName());
        assertEquals("person2",ranking.getRanking(2).getName());
        assertEquals("person6",ranking.getRanking(3).getName());
        assertEquals("person3",ranking.getRanking(4).getName());
        assertEquals("person4",ranking.getRanking(5).getName());
	}
	
	@Test
	void addPeopleRankingTest() {
		
		Ranking ranking = new Ranking();

        ranking.createRankingPlayer("person1", 501);
        ranking.createRankingPlayer("person2", 501);
        ranking.createRankingPlayer("person3", 501);
        ranking.createRankingPlayer("person4", 501);
        ranking.createRankingPlayer("person5", 501);
        ranking.createRankingPlayer("person6", 501);
        ranking.createRankingPlayer("person7", 20);
        ranking.createRankingPlayer("person8", 9001);
        ranking.createRankingPlayer("person9", 300);
        ranking.createRankingPlayer("person10", 501);
        ranking.createRankingPlayer("person11", 502);


        //5 asserts equal
        assertEquals("person8",ranking.getRanking(1).getName());
        assertEquals("person11",ranking.getRanking(2).getName());
        assertEquals("person1",ranking.getRanking(3).getName());
        assertEquals("person2",ranking.getRanking(4).getName());
        assertEquals("person3",ranking.getRanking(5).getName());
	}
}