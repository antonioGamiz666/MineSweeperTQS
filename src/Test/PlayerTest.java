package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Object;

class PlayerTest {

	@Test
	void ConstructorTest() {
		String[] player = {"Facundo","Eucalisto","Gracia", "Marcela23"};

		Object obj = new Player("Facundo"); 
		Object obj2 = new Player("Eucalisto");
		Object obj3 = new Player("Gracia");
		Object obj4 = new Player("Marcela23");

		assertEquals(player[0],obj.getType());
		assertEquals(player[1],obj2.getType());
		assertEquals(player[2],obj3.getType());
		assertEquals(player[3],obj4.getType());
	}
}
