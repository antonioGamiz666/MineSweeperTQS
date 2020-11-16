package main;

public class RankingPlayer implements Comparable<RankingPlayer>{
	private String name;
	private int points;
	
	public RankingPlayer(String name, int points){
		this.name = name;
		this.points = points;
	}
	
	public String getName() {return name;}
	
	//public void setName(String type) {this.name = name;}
	
	public int getPoints() {return points;}
	
	//public void setPoints(String type) {this.points = points;}

	@Override
    public int compareTo(RankingPlayer rp) {
        return rp.points - this.points;
    }

}
