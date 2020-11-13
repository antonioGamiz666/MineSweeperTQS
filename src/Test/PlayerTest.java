package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Player;

class PlayerTest {

	@Test
	void ConstructorTest() {
		String[] player = {"Facundo","Euc@list”","xXx_-Gracia-_xXx", "Marcela23",""};

		Player ply = new Player("Facundo"); 
		Player ply2 = new Player("Euc@list”");
		Player ply3 = new Player("xXx_-Gracia-_xXx");
		Player ply4 = new Player("Marcela23");
		Player ply5 = new Player("");
		
		
		assertEquals(player[0],ply.getName());
		assertEquals(player[1],ply2.getName());
		assertEquals(player[2],ply3.getName());
		assertEquals(player[3],ply4.getName());
		assertEquals(player[4],ply5.getName());
	}
}
