import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {
	
	private GradeBook gb1, gb2;

	@BeforeEach
	void setUp() throws Exception {
		gb1 = new GradeBook(3);
		gb1.addScore(70);
		gb1.addScore(85);
		gb1.addScore(100);
		
		gb2 = new GradeBook(5);
		gb2.addScore(80);
		gb2.addScore(85);
		gb2.addScore(50);
		gb2.addScore(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		gb1 = null;
		gb2 = null;
	}


	@Test
	void testAddScore() {
		gb1 = new GradeBook(3);
		gb2 =  new GradeBook(2);
		gb2.addScore(50);
		gb2.addScore(60);
		
		assertEquals(0, gb1.getScoreSize());
		assertEquals(0, gb1.sum(), 0.001);
		gb1.addScore(100);
		assertEquals(1, gb1.getScoreSize());
		assertEquals(100, gb1.sum(), 0.001);
		gb1.addScore(80);
		assertEquals(2, gb1.getScoreSize());
		assertEquals(180, gb1.sum(), 0.001);
		
		assertEquals(2, gb2.getScoreSize());
		assertEquals(110, gb2.sum(), 0.001);
	}

	@Test
	void testSum() {
		assertEquals(255, gb1.sum(), 0.001);
		assertEquals(315, gb2.sum(), 0.001);
	}

	@Test
	void testMinimum() {
		assertEquals(70, gb1.minimum(), 0.001);
		assertEquals(50, gb2.minimum(), 0.001);
	}

	@Test
	void testFinalScore() {
		assertEquals(185, gb1.finalScore(), 0.001);
		assertEquals(265, gb2.finalScore(), 0.001);
	}

	@Test
	void testGetScoreSize() {
		assertEquals(3, gb1.getScoreSize());
		gb1.addScore(90); // add one more then should be 4 for scoreSize
		assertEquals(3, gb1.getScoreSize()); //still 3 because was set only 3
		
		assertEquals(4, gb2.getScoreSize());
		gb2.addScore(95); //add one more then should be 5 at scoreSize
		assertEquals(5, gb2.getScoreSize()); 
	}

	@Test
	void testToString() {
		assertTrue(gb1.toString().equals("70.0 85.0 100.0"));
		assertTrue(gb2.toString().equals("80.0 85.0 50.0 100.0"));
		
	}

}
