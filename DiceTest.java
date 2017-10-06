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
		int testRolls = 60000; // Bør ikke overstige 357913940, som er intmax/6. Går den over er der "chance" for overflow hvis alle rammer en 6'er.
		double allowVariance = 0.04; // Bør ikke afvige med mere end 4%.
		double diceAverage = 3.5; // Gennemsnitlig antal øjne på en seks sidet terning er 3.5.
		System.out.println(diceAverage);
		double totalMinimum = (1-allowVariance) * testRolls * diceAverage;
		double totalMaximum = (1+allowVariance) * testRolls * diceAverage;
		int total = 0;
		int[] tally = new int[6];
		// laver en løkke der tester for 60000 kast
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
