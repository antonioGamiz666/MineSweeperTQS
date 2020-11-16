package Test;

import main.Printer;

public interface GameI {
	
	public int printMenuStart(Printer printer);
	public void newPlayer(Printer printer);
	public int play(Printer printer);
	public String getName();
	
	public void createBoard(int difficulty);
	public void askMovement(Printer printer);
	
	
	
}
