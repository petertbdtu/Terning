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
		double diceAverage = 3.5; // Average amount of eyes on a six sided dice is 3.5.
		System.out.println(diceAverage);
		double totalMinimum = (1-allowVariance) * testRolls * diceAverage;
		double totalMaximum = (1+allowVariance) * testRolls * diceAverage;
		int total = 0;
		// creates a loop for 60000 rolls
		for (int i = 0; i < testRolls; i++)
		{
			int roll = die.roll();
			assertTrue(1 <= roll && roll <= 6);
			total += roll;
			
		}
		
		assertTrue(totalMinimum < total && total < totalMaximum);

	}

}
