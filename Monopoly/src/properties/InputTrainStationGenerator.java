package properties;

import java.util.Scanner;

import main.Board;
import player.Player;

public class InputTrainStationGenerator {
	public static Player propertyChoice(Player p, TrainStation s, Board board){
		System.out.println("You have landed on " + s.getName());
		if(s.getOwner() == null){
			System.out.println("Do you want to buy " + s.getName() + " for $" + s.getCost());
			String answer = verifyAnswer();
			if(answer.equals("y")){
				s.setOwner(p);
				p.loseMoney(s.getCost());
				p.addProperty(p.getLocation(), s);
			}
		} else if (s.getOwner() != p){
			int rent = s.getRent(board,p);
			System.out.println("You have to pay rent of " + rent);
			p.loseMoney(rent);
		}
		return p;
	}
	
	private static String verifyAnswer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(y / n)");
		String answer = sc.nextLine();
		while(!answer.equalsIgnoreCase("y") && !answer.equals("n")){
			System.out.println("Invalid input");
			answer = sc.nextLine();
		}
		return answer;
	}
}
