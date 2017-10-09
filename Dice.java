package terning;

public class Dice {
	// roll dice and return value between 1-6
	public int roll() {
		return (int)(Math.random() * 6.0) + 1;	
	}
	
	// roll dice multiple times
	public void rollMultiple(int n) {
		for (int i=0; i<n; i++) {
			System.out.print(roll() + " ");
		}
	}
}

