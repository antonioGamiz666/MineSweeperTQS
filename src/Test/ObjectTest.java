package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Object;


class ObjectTest {
	
	
	@Test
	void ConstructorTest() {
		String[] object = {"mine","flag","number", "empty"};

		Object obj = new Object("mine"); 
		Object obj2 = new Object("flag");
		Object obj3 = new Object("number");
		Object obj4 = new Object("empty");

		assertEquals(object[0],obj.getType());
		assertEquals(object[1],obj2.getType());
		assertEquals(object[2],obj3.getType());
		assertEquals(object[3],obj4.getType());
	}
	
}
