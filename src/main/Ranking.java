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
			
			int sizeList = rankingList.size()-1;
			int lastPoints = rankingList.get(sizeList).getPoints();
			
			if(sizeList < 5) {
				if(lastPoints < points) {
					Collections.sort(rankingList);
				}else {
					rankingList.add(new RankingPlayer(name,points));
				}
			}else{
				if(lastPoints < points) {
					rankingList.remove(4);
					rankingList.add(new RankingPlayer(name,points));
					Collections.sort(rankingList);
				}
			}
		}
	}
		
	public RankingPlayer getRanking(int position) {
			return rankingList.get(position-1);
	}	
	
}
