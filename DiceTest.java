package terning;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	Dice die;

	@Before
	public void setUp() throws Exception {
		die = new Dice();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRoll()
	{
		int testRolls = 60000; // Should not exceed 357913940, which is equivalent to intmax/6. If it does exceed, there is a small "chance" for overflow.
		double allowVariance = 0.04; // Should not vary more than 4%.
		double tallyMinimum = testRolls * (1-allowVariance) / 6;
		double tallyMaximum = testRolls * (1+allowVariance) / 6;
		int tally1 = 0;
		int tally2 = 0;
		int tally3 = 0;
		int tally4 = 0;
		int tally5 = 0;
		int tally6 = 0;
		// creates a loop for 60000 rolls
		for (int i = 0; i < testRolls; i++)
		{

			int roll = die.roll();
			assertTrue(1 <= roll && roll <= 6);
			switch(roll) {
			case 1:  
				tally1++;
				break;
			case 2:  
				tally2++;
				break;
			case 3:  
				tally3++;
				break;
			case 4:  
				tally4++;
				break;
			case 5:  
				tally5++;
				break;
			case 6:  
				tally6++;
				break;	
			}

		}
		assertTrue(tallyMinimum < tally1 && tally1 < tallyMaximum);
		assertTrue(tallyMinimum < tally2 && tally2 < tallyMaximum);
		assertTrue(tallyMinimum < tally3 && tally3 < tallyMaximum);
		assertTrue(tallyMinimum < tally4 && tally4 < tallyMaximum);
		assertTrue(tallyMinimum < tally5 && tally5 < tallyMaximum);
		assertTrue(tallyMinimum < tally6 && tally6 < tallyMaximum);
		
	}

}