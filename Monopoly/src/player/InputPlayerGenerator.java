package player;

import java.util.Scanner;

public class InputPlayerGenerator {
	private static final String YES = "y";
	private static final String NO = "n";
	private String name;
	private String character;

	public InputPlayerGenerator() {

	}

	/**
	 * @return the name
	 */
	public String getName() {
		String name = verifyName();
		return name;
	}

	private String verifyName() {
		Scanner sc = new Scanner(System.in);
		String rightName = NO;
		String name = null;
		while (rightName.equals(NO)) {
			System.out.println("What is your name?");
			name = sc.nextLine();
			System.out.println("Your name is " + name + " (y/n)");
			rightName = verify(YES, NO);
		}

		return name;
	}

	private String verify(String var1, String var2) {
		Scanner sc = new Scanner(System.in);
		String answer = sc.nextLine();
		while (!answer.equals(var1) && !answer.equals(var2)) {
			System.out.println("Invalid Input, please try again.");
			answer = sc.nextLine();
		}
		return answer;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param chars
	 * @return the character
	 */
	public String getCharacter(Characters chars) {
		String character = chooseChar(chars);
		return character;
	}

	private String chooseChar(Characters chars) {
		System.out.println("Please enter the number beside your character of choice.");
		chars.printChars();
		int choice = verifyChoice(chars);
		//System.out.println(choice);
		chars.removeChar(choice);
		return chars.getAtIndex(choice);
	}

	private int verifyChoice(Characters chars) {
		Scanner sc = new Scanner(System.in);
		int num;
		try {
			num = sc.nextInt();
		} catch (Exception InputMismatchException) {
			num = 10;
		}

		while (num < 1 || num > chars.length() - 1) {
			System.out.println("Invalid Input, please choose again.");
			while (!sc.hasNextInt()) {
				System.out.println("That is not a number");
				sc.next();
			}
			num = sc.nextInt();

		}
		return num - 1;
	}

	/**
	 * @return the character
	 */
	public String getCharacter() {
		return character;
	}

	/**
	 * @param character
	 *            the character to set
	 */
	public void setCharacter(String character) {
		this.character = character;
	}

}
