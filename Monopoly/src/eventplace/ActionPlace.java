package eventplace;

import java.util.Random;
import java.util.Scanner;

import main.Board;
import player.Player;
import properties.Space;
import properties.Street;

public class ActionPlace extends Space implements IActionPlaceConstants{
	private String code;

	public ActionPlace(String name, String colour, String code) {
		super(name, colour);
		this.code = code;
	}
	
	public Player action(Player player, Player[] others, Board board, Street[] streets, Player[] players){
		Random rand = new Random();
		switch(code){
		case COMMUNITYCHEST: 
			System.out.println("You landed on Community Chest");
			CommunityChest.getEffect(player, others);
			break;
		case CHANCE: 
			System.out.println("You landed on Chance");
			player = Chance.getEffect(player, others, board, streets, players);
			break;
		case GO:
			System.out.println("You landed on GO");
			System.out.println("You've landed on go collect double the amount");
			player.addMoney(ADD_400); // doubling if landed on GO, only 200 if passing (thus method not called)
			break;
		case LUXURYTAX:
			System.out.println("You landed on Luxury Tax");
			System.out.println("You need to pay $100 in luxury tax");
			player.loseMoney(LOSE_100);
			break;
		case INCOMETAX:
			System.out.println("You landed on Income Tax");
			System.out.println("Would you like to pay $200, or 10% of your total worth.");
			int percentWorth = (int) (player.getMoney()*0.1);
			System.out.println("10% of your total worth is :" + percentWorth);
			String answer = getIncomeTaxAnswer();
			if(answer.equals(TAX)){
				player.loseMoney(percentWorth);
			} else {
				player.loseMoney(LOSE_200);
			}
			break;
		case JAIL: // need to debug
			System.out.println("You landed on Jail");
			if(player.getTurnsInJail()==0){
				System.out.println("You visit jail, your turn ends");
			} else {
				System.out.println("You have " + player.getTurnsInJail() + " more turns");
				System.out.println("Do you want to buy your way out for $150?");
				String choice = verifyChoice();
				if(choice.equals(YES)){
					player.loseMoney(LOSE_150);
					player.setInJail(NOT_IN_JAIL);
					player.setTurnsInJail(NO_TURN_IN_JAIL);
				} else {
					player.setTurnsInJail(player.getTurnsInJail()-1);
				}
			}
			
			break;
		case GOTOJAIL:
			System.out.println("You have been sent to jail");
			player.setLocation(JAIL_INDEX); 
			player.setInJail(IN_JAIL);
			player.setTurnsInJail(TURNS_IN_JAIL);
			break;
		case FREEPARKING:
			System.out.println("You landed on Free Parking");
			break;
		}
		return player;
	}

	private String verifyChoice() {
		Scanner sc = new Scanner(System.in);
		String name = sc.nextLine().toLowerCase();
		while (!name.equals(NO) && !name.equals(YES)) {
			System.out.println("Invalid Input, please try again with (y,n) only");
			name = sc.nextLine().toLowerCase();
		}
		return name;
	}

	private String getIncomeTaxAnswer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter either 'tax' or 'pay'");
		String response = sc.nextLine().toLowerCase(); 
		while(!response.equals(TAX) && !response.equals(PAY)){
			System.out.println("Invalid input, please try again.");
			response = sc.nextLine().toLowerCase();
		}
		return response;
	}

}
