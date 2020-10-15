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

			if(typeExpected == "fake")
			{
				assertEquals("wrong", square.getTypeObject());
				assertTrue(Square.getObject() == null);
			}
			else
			{
				assertEquals(typeExpected, square.getTypeObject());
				assertFalse(square.isSelected());
			}
		}
		
		

	}

}
