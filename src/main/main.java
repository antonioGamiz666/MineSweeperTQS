package main;

import Test.GameI;
import Test.mockObjectGame;

public class main {

	public static void main(String[] args)
	{			
	    Game game= new Game();
		//GameI game = new mockObjectGame();
	    Ranking ranking = new Ranking();
	    Printer printer = new Printer();
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
		if(ranking.numPlayers()>0) {
			printer.showFarewell(game.getName());	
		}
	}
}
