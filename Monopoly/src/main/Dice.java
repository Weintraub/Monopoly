package main;

import java.util.Random;

public class Dice {
	public static int roll(){
		Random rand = new Random();
		int diceOne = rand.nextInt(6)+1;
		int diceTwo = rand.nextInt(6)+1;
		System.out.println("You rolled a " + diceOne);
		System.out.println("You rolled a " + diceTwo);
		int total = (diceOne+diceTwo);
		if(diceOne == diceTwo){
			total *= 2;
			System.out.println("You rolled doubles! Move double the spaces!");
		}
		
		System.out.println("You moved " + total + " spaces");
		return total;
	}
}
