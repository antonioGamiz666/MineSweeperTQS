package main;

import java.util.ArrayList;
import java.util.List ;
import java.util.Collections;

public class Ranking {

	List<RankingPlayer> rankingList = new ArrayList<RankingPlayer>();
	
	public Ranking() {}
		
	/*private void updateRanking() {
		Collections.sort(rankingList);
	}*/
	
	public void createRankingPlayer(String name, int points){
		
		if(rankingList.isEmpty()) {
			rankingList.add(new RankingPlayer(name,points));
		}else{
			
			int sizeList = rankingList.size();
			int lastPoints = rankingList.get(sizeList-1).getPoints();
			
			if(sizeList <= 4) {
				if(lastPoints < points) {
					rankingList.add(new RankingPlayer(name,points));
					Collections.sort(rankingList);
				}else {
					rankingList.add(new RankingPlayer(name,points));
				}
			}else{
				if(lastPoints < points) {
					/*rankingList.add(new RankingPlayer(name,points));
					Collections.sort(rankingList);
					sizeList = rankingList.size()-1;*/
					
					
					
					rankingList.remove(4);
					rankingList.add(new RankingPlayer(name,points));
					Collections.sort(rankingList);
					
					/*if(sizeList>5) {
						rankingList.remove(5);
					}*/
				}
			}
		}
	}
		
	public RankingPlayer getRanking(int position) {
			return rankingList.get(position-1);
	}	
    public int getPoints(int position) {return rankingList.get(position-1).getPoints();}
    public String getName(int position) {return rankingList.get(position-1).getName();}
    public int numPlayers() {return rankingList.size();}
	
}
