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
	public void testRoll() {
		
		int testRolls = 60000; //Shouldn't exceed 357913940, which is approx intmax/6.
		double expectedVariance = 0.04;
		double totalMinimum = (1-expectedVariance) * testRolls;
		double totalMaximum = (1+expectedVariance) * testRolls;
		int total = 0;
		int[] tally = new int[6];
		for (int i = 0; i < testRolls; i++)
		{
			int roll = die.roll();
			assertTrue(1 <= roll && roll <= 6);
			total += roll;
			if (i%1000==0)
			{
				System.out.print((1-expectedVariance)*i + " ");
				System.out.print(total +" ");
				System.out.println((1+expectedVariance)*i);
			}
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
