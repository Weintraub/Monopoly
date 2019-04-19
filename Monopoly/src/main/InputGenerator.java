package main;

import java.util.Scanner;

public class InputGenerator {

	private static final String YES = "y";
	private static final String NO = "n";

	public static int getPlayerChoice() {
		int numPlayers = verifyChoice();
		String rightName = verify(YES, NO, numPlayers);
		while(rightName.equals(NO)){
			numPlayers = verifyChoice();
			rightName = verify(YES, NO, numPlayers);
		}
		return numPlayers;
	}

	private static int verifyChoice() {
		System.out.println("How many players are gonna play? (1 - 8)");
		Scanner sc = new Scanner(System.in);
		int num;
		try {
			num = sc.nextInt();
		} catch (Exception InputMismatchException) {
			num = 10;
		}

		while (num < 1 || num > 8) {
			System.out.println("Invalid Input, please choose again.");
			while (!sc.hasNextInt()) {
				System.out.println("That is not a number");
				sc.next();
			}
			num = sc.nextInt();

		}
		
		return num;
	}
	
	private static String verify(String var1, String var2, int numPlayers) {
		System.out.println("You want to play with " + numPlayers + " players? (y/n)");
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		while (!answer.equals(var1) && !answer.equals(var2)) {
			System.out.println("Invalid Input, please try again.");
			answer = sc.nextLine();
		}
		return answer;
	}

}
