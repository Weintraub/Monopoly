package eventplace;

import java.util.Random;

import player.Player;

public class CommunityChest implements ICommunityChestConstants{

	public static void getEffect(Player player, Player[] others) {
		Random rand = new Random();
		int luck = rand.nextInt(NUM_CHANCE_CARDS); // add one later
		//System.out.println(luck);
		switch (luck) {
		case 0:
			System.out.println("Advance to GO");
			player.setLocation(0);
			player.addMoney(ADD_400);
			System.out.println("You've landed on go collect double the amount");
			player.addMoney(ADD_400);
			break;
		case 1:
			System.out.println("Bank error in your favor");
			player.addMoney(ADD_200);
			break;
		case 2:
			System.out.println("Doctor's fees");
			player.loseMoney(LOSE_50);
			break;
		case 3:
			System.out.println("You sold some stocks");
			player.addMoney(ADD_50);
			break;
		case 4:
			System.out.println("You gained get out of jail free card");
			player.setGetOutOfJailFree(GET_OUT_OF_JAIL_FREE);
			break;
		case 5:
			System.out.println("Go immediately to jail");
			player.setLocation(JAIL);
			player.setInJail(true);
			player.setTurnsInJail(TIME_IN_JAIL);
			break;
		case 6:
			System.out.println("Grand Opera Night - Collect $50 from every player");
			for (Player p : others) {
				if (p.equals(player)) {
					continue;
				}
				p.setMoney(p.getMoney() - LOSE_50);
			}
			player.addMoney(ADD_150);
			break;
		case 7:
			System.out.println("Holiday Fund matures");
			player.addMoney(ADD_100);
			break;
		case 8:
			System.out.println("Income tax refund");
			player.addMoney(ADD_20);
			break;
		case 9:
			System.out.println("It is your birthday - Collect $10 from each player");
			for (Player p : others) {
				if (p.equals(player)) {
					continue;
				}
				p.setMoney(p.getMoney() - LOSE_10);
			}
			player.addMoney(ADD_30);

			break;
		case 10:
			System.out.println("Life insurance matures");
			player.addMoney(ADD_100);
			break;
		case 11:
			System.out.println("Pay hospital fees");
			player.loseMoney(LOSE_100);
			break;
		case 12:
			System.out.println("Pay school fees");
			player.loseMoney(LOSE_150);
			break;
		case 13:
			System.out.println("Receive $25 consultancy fee");
			player.addMoney(ADD_25);
			break;
		case 14:
			System.out.println("You have won second prize in a beauty contest");
			player.addMoney(ADD_10);
			break;
		case 15:
			System.out.println("You inherit $100");
			player.addMoney(ADD_100);
			break;
		case 16: // the hotels and houses CC card $40 / house $155 / hotel
			break;
		}

	}
}
