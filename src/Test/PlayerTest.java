package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Object;

class PlayerTest {

	@Test
	void ConstructorTest() {
		String[] player = {"Facundo","Eucalisto","Gracia", "Marcela23"};

		Object ply = new Player("Facundo"); 
		Object ply2 = new Player("Eucalisto");
		Object ply3 = new Player("Gracia");
		Object ply4 = new Player("Marcela23");

		assertEquals(player[0],ply.getType());
		assertEquals(player[1],ply.getType());
		assertEquals(player[2],ply3.getType());
		assertEquals(player[3],ply4.getType());
	}
}
