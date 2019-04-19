package main;

import java.util.Scanner;

import eventplace.ActionPlace;
import player.Characters;
import player.Input;
import player.InputPlayerGenerator;
import player.Player;
import properties.InputPropertyGenerator;
import properties.InputTrainStationGenerator;
import properties.InputUtilityGenerator;
import properties.Property;
import properties.Street;
import properties.TrainStation;
import properties.Utility;

/**
 * @author daniel
 *
 */
public class Main {

	public static void main(String[] args) {
		InputPlayerGenerator data = new InputPlayerGenerator();
		Characters chars = new Characters();
		int numPlayers = Input.getNumberOfPlayers();
		Player[] players = new Player[numPlayers];
		
		for(int i = 0; i < numPlayers; i++){
			players[i] = Input.getPlayerData(data, chars);
		}
		
		Board board = new Board(Constants.getSpaces());
		
		Street[] streets = Constants.getStreetInfo(board);
		int turn = 0;

		while (true) {
			turn++;
			System.out.println("Turn: " + turn);
			System.out.println("");
			
			for (int i = 0; i < players.length; i++) {
				Player p = players[i];
				System.out.println(p.toString());
				if(p.isInJail()){
					p.decrementJail();
					continue;
				}
			
				System.out.println(p.getName() + "'s turn");
				int moves = Dice.roll();
				p.addMoves(moves);

				String landed = board.getBoardValue(p.getLocation()).getClass().getSimpleName();
				// System.out.println(landed);
				switch (landed) {
				case "Property":
					Property prop = (Property) board.getBoardValue(p.getLocation());
					InputPropertyGenerator propData = new InputPropertyGenerator();
					p = Input.getPropertyChoice(propData, board, p, prop, streets, players);
					break;
				case "Utility":
					Utility util = (Utility) board.getBoardValue(p.getLocation());
					InputUtilityGenerator utilData = new InputUtilityGenerator();
					p = Input.getUtilityChoice(utilData, board, p, util,moves);
					break;
				case "TrainStation":
					TrainStation train = (TrainStation) board.getBoardValue(p.getLocation());
					InputTrainStationGenerator trainData = new InputTrainStationGenerator();
					p = Input.getTrainStationChoice(trainData, board, p, train);
					break;
				case "ActionPlace":
					p = ((ActionPlace) board.getBoardValue(p.getLocation())).action(p, players, board, streets, players);
					break;
				}
				players[i] = p;
				p.checkWin(players);
				System.out.println("Your turn has ended press enter");
				Scanner sc = new Scanner(System.in);
				sc.nextLine();
				System.out.println("");
			}
		}
	}

}
