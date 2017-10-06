

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
	public void testRoll() {
		
		int testRolls = 60000; // Shouldn't exceed 357913940, which is approx intmax/6
		double expectedVariance = 0.04;
		double diceAverage = 3.5; // Average roll of a six-sided die is 3.5
		System.out.println(diceAverage);
		double totalMinimum = (1-expectedVariance) * testRolls * diceAverage;
		double totalMaximum = (1+expectedVariance) * testRolls * diceAverage;
		int total = 0;
		int[] tally = new int[6];
		for (int i = 0; i < testRolls; i++)
		{
			int roll = die.roll();
			assertTrue(1 <= roll && roll <= 6);
			total += roll;
			tally[roll-1]++;
		}
		System.out.println(tally[0]);
		System.out.println(tally[1]);
		System.out.println(tally[2]);
		System.out.println(tally[3]);
		System.out.println(tally[4]);
		System.out.println(tally[5]);
		assertTrue(totalMinimum < total && total < totalMaximum);

	}

		@Test
		public void testRollMultiple() {
			// fail("Not yet implemented");
		}

}