package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Square;

class SqaureTest {

	@Test
	void constructor1() {
		
		Square square = new Square();
		
		assertEquals(null, Square.getObject());
		

	}
	
	@Test
	void constructor2() {
		
		String typeObjects[] = {"mine", "flag","number","empty","fake"};
		
		for(String typeExpected : typeObjects)
		{
			Square square = new Square(typeExpected);
			assertEquals(typeExpected, square.getTypeObject());
			
			if(typeExpected == "fake")
			{
				assertTrue(Square.getObject() == null);
			}
		}

	}

}
