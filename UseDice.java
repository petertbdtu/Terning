// Program: Terning
// Version: 3.00
// Date created: 2014-06-10
// Last modified: 2017-10-09
// Author: Bjørn Christensen 
// Modified by: Agner Fog
// Modified by: Asef Khatak

// Description:
// This program simulates roll of a die

package terning;

import java.util.Scanner;

public class UseDice {

	public static void main(String[] args) {
		Dice cup = new Dice();   // Make an instance of Dice
		Scanner keyboard=new Scanner(System.in);   // Make an instance of keyboard Scanner
		System.out.println("Welcome to the diceroll program");
		while (true)
		{
			System.out.println("How many times do you want to roll the dice?");
			if (!keyboard.hasNextInt()) keyboard.nextLine();
			else break;
		}
		int n = keyboard.nextInt();  // Read integer
		cup.rollMultiple(n);         // Roll the dice n times
		keyboard.close();            // Close the scanner
	}
}
