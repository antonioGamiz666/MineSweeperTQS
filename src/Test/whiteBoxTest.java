package Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import main.Board ;
import main.*;

public class whiteBoxTest {
	
	@Test
	void decisionCoverage1()
	{
		//DecisionCoverage createRanking
		Ranking ranking = new Ranking();
		
		/*** First path TRUE***/
        ranking.createRankingPlayer("person1", 515);
        
        /*** Second path FALSE - TRUE - TRUE***/
        ranking.createRankingPlayer("person2", 516);
        
        /*** Third path FALSE - TRUE - FALSE ***/
        ranking.createRankingPlayer("person3", 513);
        
        /*** Fourth path FALSE - FALSE - TRUE ***/
        ranking.createRankingPlayer("person4", 512);
        ranking.createRankingPlayer("person5", 511);
        ranking.createRankingPlayer("person6", 600);
        
        /** Fifth path FALSE - FALSE - FALSE ***/
        
        ranking.createRankingPlayer("person6", 200);

	}
	
	@Test
	void decisionCoverage2()
	{
		//DecisionCoverage setFlag(int X, nt Y)
		Board board = new Board(0,4,4);
		board.setTypeObject(1,1, "mine");
		board.setNumbertest(1, 1);
		
		/*** First path  FALSE ***/
		board.setFlag(1, 1);
		
		/*** Second path TRUE - TRUE ***/
		board.setFlag(1,1);
		
		/*** Third path TRUE - FALSE ***/
		board.setFlag(0, 0);
		board.setFlag(0, 0);
		
	}
	
	@Test
	void decisionCoverage3()
	{
		//public int openSquare(int posX, int posY){
		Board board = new Board(0,4,4);
		board.setTypeObject(1, 1, "mine");
		board.setNumbertest(1, 1);
		
		/*** First path TRUE TRUE TRUE TRUE ***/
		board.openSquare(0, 0);
		
		/*** Second path TRUE TRUE TRUE FALSE ***/
		board.openSquare(3,3);
		
		board = new Board(0,4,4);
		board.setTypeObject(1, 1, "mine");
		board.setNumbertest(1, 1);
		
		/*** Third path TRUE TRUE FALSE ***/
		board.openSquare(1, 1);
		
		/*** Fourth path TRUE FALSE ***/
		board.openSquare(0, 0);
		board.openSquare(0,0);
		
		/*** Fifth path FALSE ***/
		board.openSquare(20, 0);
	}
	
	@Test 
	void conditionCoverage3()
	{
		//public int openSquare(int posX, int posY){
		Board board = new Board(0,4,4);
		board.setTypeObject(1, 1, "mine");
		board.setNumbertest(1, 1);
		
		/*** First path TRUE(true&&true) TRUE TRUE TRUE ***/
		board.openSquare(0, 0);
		
		/*** Second path TRUE(true&&true) TRUE TRUE FALSE ***/
		board.openSquare(3,3);
		
		board = new Board(0,4,4);
		board.setTypeObject(1, 1, "mine");
		board.setNumbertest(1, 1);
		
		/*** Third path TRUE(true&&true) TRUE FALSE ***/
		board.openSquare(1, 1);
		
		/*** Fourth path TRUE(true&&true) FALSE ***/
		board.openSquare(0, 0);
		board.openSquare(0,0);
		
		/*** Fifth path FAlSE(false&&true) ***/
		board.openSquare(20, 0);
		
		/*** Sixth path FAlSE(true&&false) ***/
		board.openSquare(0, 20);
		
		/*** Seventh path False(false&&false) ***/
		board.openSquare(20, 20);
	}




}
