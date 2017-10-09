package terning;

public class Dice {
	// roll the die and return a value between 1-6
	public int roll() {
		int value = (int)(Math.random() * 6.0) + 1;
	}

	// roll the die n times and print the values
	public void rollMultiple(int n) {
		for (int i=0; i<n; i++) {
			System.out.print(roll() + " ");
		}		

	}

}