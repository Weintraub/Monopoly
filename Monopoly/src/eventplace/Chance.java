package eventplace;

import java.util.Random;
import main.Board;
import player.Input;
import player.Player;
import properties.InputPropertyGenerator;
import properties.Property;
import properties.Street;
import properties.TrainStation;
import properties.Utility;

public class Chance implements IChanceConstants{

	public static Player getEffect(Player player, Player[] others, Board board, Street[] streets, Player[] players){
		Random rand = new Random();
		int luck = rand.nextInt(14);
		//System.out.println(luck);
		Property prop;
		InputPropertyGenerator propData;
		switch (luck) {
		case 0: //done
			System.out.println("Advance to Go");
			player.setLocation(0);
			System.out.println("You've landed on go collect double the amount");
			player.addMoney(ADD_400);
			break;
		case 1: //done
			System.out.println("Advance to Illinois Ave");
			if(player.getLocation()>24){
				player.addMoney(ADD_200); // passing go
			}
			player.setLocation(ILLINOIS_AVE);
			prop = (Property) board.getBoardValue(player.getLocation());
			propData = new InputPropertyGenerator();
			player = Input.getPropertyChoice(propData, board, player, prop, streets, players);
			break;
		case 2: //done
			System.out.println("Advance to St. Charles Place");
			if(player.getLocation()>11){
				player.addMoney(ADD_200); // passing go
			}
			player.setLocation(ST_CHARLES);
			prop = (Property) board.getBoardValue(player.getLocation());
			propData = new InputPropertyGenerator();
			player = Input.getPropertyChoice(propData, board, player, prop, streets, players);
			break;
		case 3:
			System.out.println("Advance token to nearest Utility. \nIf unowned, you may buy it from the Bank. \nIf owned, throw dice and pay owner a total ten times the amount thrown");
			if(player.getLocation()-12 < player.getLocation()-28){
				player.setLocation(UTILITY_ONE);
			} else {
				player.setLocation(UTILITY_TWO);
			}
			prop = (Utility) board.getBoardValue(player.getLocation());
			propData = new InputPropertyGenerator();
			player = Input.getPropertyChoice(propData, board, player, prop, streets, players);
			break;
		case 4: // need to add the payment
			System.out.println("Take a trip to Reading Railroad. \nIf owned pay owner double what is owed");
			player.setLocation(ADD_25);
			break;
		case 5:
			System.out.println("Bank pays you dividend of $50");
			player.addMoney(ADD_50);
			break;
		case 6:
			System.out.println("Get a get out of Jail Free Card");
			player.setGetOutOfJailFree(GET_OUT_OF_JAIL_FREE);
			break;
		case 7:
			System.out.println("Go Back 3 Spaces and end your turn");
			player.setLocation(player.getLocation()-3);
			break;
		case 8:
			System.out.println("Go to jail");
			player.setLocation(JAIL);
			player.setInJail(true);
			player.setTurnsInJail(TIME_IN_JAIL);
			break;
		case 9:
			System.out.println("Pay poor tax of $15");
			player.loseMoney(LOSE_15);
			break;
		case 10: //implement double pay
			System.out.println("Take a trip to Reading Railroad.");
			player.setLocation(READING_RAILROAD);
			prop = (TrainStation) board.getBoardValue(player.getLocation());
			propData = new InputPropertyGenerator();
			player = Input.getPropertyChoice(propData, board, player, prop, streets, players);
			break;
		case 11:
			System.out.println("Take a walk on the Boardwalk");
			player.setLocation(BOARDWALK);
			prop = (Property) board.getBoardValue(player.getLocation());
			propData = new InputPropertyGenerator();
			player = Input.getPropertyChoice(propData, board, player, prop, streets, players);
			break;
		case 12:
			System.out.println("You have been elected Chairman of the Board. Pay each player $50");
			int total = 0;
			for(Player person : others){
				if(person.equals(player)){
					continue;
				}
				total += 50;
				person.addMoney(ADD_50);
			}
			player.loseMoney(total);
			break;
		
		case 13:
			System.out.println("Your building and loan matures. Collect $150");
			player.addMoney(ADD_150);
			break;
		case 14:
			System.out.println("You have won a crossword competition. Collect $100");
			player.addMoney(ADD_100);
			break;
		case 15: // no implement
			System.out.println("Make general repairs on all your property. For each house pay $25 – For each hotel $100");
			break;
		}
		return player;
	}
}
