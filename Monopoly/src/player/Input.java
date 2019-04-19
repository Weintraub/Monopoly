package player;


import main.Board;
import main.InputGenerator;
import properties.InputPropertyGenerator;
import properties.InputTrainStationGenerator;
import properties.InputUtilityGenerator;
import properties.Property;
import properties.Street;
import properties.TrainStation;
import properties.Utility;

public class Input {
	public static Player getPlayerData(InputPlayerGenerator data, Characters chars) {
		return new Player(data.getName(), data.getCharacter(chars));
	}

	public static Player getPropertyChoice(InputPropertyGenerator data, Board board, Player p, Property s, Street[] streets, Player[] players){
		return InputPropertyGenerator.propertyChoice(p, s, board, streets, players);
	}
	
	public static Player getTrainStationChoice(InputTrainStationGenerator data, Board board, Player p, TrainStation s){
		return InputTrainStationGenerator.propertyChoice(p, s, board);
	}
	
	public static Player getUtilityChoice(InputUtilityGenerator data, Board board, Player p, Utility s, int diceRollSum){
		return InputUtilityGenerator.utilityChoice(p, s, board, diceRollSum);
	}

	public static int getNumberOfPlayers() {
		return InputGenerator.getPlayerChoice();
	}
	
	
}
