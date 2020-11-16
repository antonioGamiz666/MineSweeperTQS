package Test;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Game;
import main.Printer;
import main.Ranking;

public class mainTest {
	
	@Test
	void maintest()
	{
		 	GameI game= new mockObjectGame();
		    Ranking ranking = new Ranking();
		    Printer printer = new Printer();
		    
		    for(int i=1; i<=3; i++)
		    {
		    	int playOption = 1;
		    	while(playOption!=3)	{	
					
					playOption = game.printMenuStart(printer);
					
					if(playOption == 1)
					{
						int points = 0;
						game.newPlayer(printer);
						points = game.play(printer);
						
						ranking.createRankingPlayer(game.getName(), points);
					}
					if(playOption == 2)
					{
						printer.showRanking(ranking);
					}

				}
				printer.showFarewell(game.getName());
		    }


				
	}
}


