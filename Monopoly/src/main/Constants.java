package main;

import eventplace.ActionPlace;
import properties.Property;
import properties.Space;
import properties.Street;
import properties.TrainStation;
import properties.Utility;

public class Constants implements IConstantsColours{
	/**
	 * @return the spaces
	 */
	public static Space[] getSpaces() {
		// IN FINAL PRODUCT REMOVE PLAYER AND CHANGE ALL TO NULL
		// Player player = new Player("Daniel", "Battleship", 1500, null, 0);

		Space[] spaces = new Space[40];
		spaces[0] = new ActionPlace("Go", ACTION, "go"); // go
		spaces[1] = new Property("Mediterranean Ave", BROWN, 60);
		spaces[2] = new ActionPlace("Community Chest", ACTION, "cc"); // community chest
		spaces[3] = new Property("Baltic Ave", BROWN, 60);
		spaces[4] = new ActionPlace("Income Tax", ACTION, "ixtx"); // income tax
		spaces[5] = new TrainStation("Reading Railroad", "train", 200);
		spaces[6] = new Property("Oriental Ave", TEAL, 100);
		spaces[7] = new ActionPlace("Chance", ACTION, "ch"); // chance
		spaces[8] = new Property("Vermont Ave", TEAL, 100);
		spaces[9] = new Property("Connecticut Ave", TEAL, 120);
		spaces[10] = new ActionPlace("Jail", ACTION, "jail"); // jail
		spaces[11] = new Property("St. Charles Place", PURPLE, 140);
		spaces[12] = new Utility("Water Works", "utility", 150);
		spaces[13] = new Property("States Ave", PURPLE, 140);
		spaces[14] = new Property("Virginia Ave", PURPLE, 160);
		spaces[15] = new TrainStation("Pennsylvania Railroad", "train", 200);
		spaces[16] = new Property("St. James Place", ORANGE, 180);
		spaces[17] = new ActionPlace("Community Chest", ACTION, "cc"); // community chest
		spaces[18] = new Property("Tennessee Ave", ORANGE, 180);
		spaces[19] = new Property("New York Ave", ORANGE, 200);
		spaces[20] = new ActionPlace("Free Parking", ACTION, "fp"); // free parking
		spaces[21] = new Property("Kentucky Ave", RED, 220);
		spaces[22] = new Property("Indiana Ave", RED, 220);
		spaces[23] = new ActionPlace("Chance", ACTION, "ch"); // chance
		spaces[24] = new Property("Illinois Ave", RED, 240);
		spaces[25] = new TrainStation("B. & O. Railroad", "train", 200);
		spaces[26] = new Property("Atlantic Ave", YELLOW, 260);
		spaces[27] = new Property("Ventnor Ave", YELLOW, 260);
		spaces[28] = new Utility("Water Works", "utility", 150);
		spaces[29] = new Property("Marvin Gardens", YELLOW, 280);
		spaces[30] = new ActionPlace("Go to Jail", ACTION, "gtjl"); // go to jail
		spaces[31] = new Property("Pacific Ave", GREEN, 300);
		spaces[32] = new Property("North Carolina Ave", GREEN, 300);
		spaces[33] = new ActionPlace("Community Chest", ACTION, "cc"); // community chest
		spaces[34] = new Property("Pennsylvania Ave", GREEN, 320);
		spaces[35] = new TrainStation("Short Line", "train", 200);
		spaces[36] = new ActionPlace("Chance", ACTION, "ch"); // chance
		spaces[37] = new Property("Park Place", BLUE, 350);
		spaces[38] = new ActionPlace("Luxury Tax", ACTION, "lxtx"); // luxury tax
		spaces[39] = new Property("Boardwalk", BLUE, 400);

		return spaces;
	}
	
	public static Street[] getStreetInfo(Board board){
		Street[] streets = new Street[8];
		Property[] props = new Property[3];
		props = new Property[]{(Property) board.getBoardValue(1), (Property) board.getBoardValue(3)};
		streets[0] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(6), (Property) board.getBoardValue(8), (Property) board.getBoardValue(9)};
		streets[1] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(11), (Property) board.getBoardValue(13), (Property) board.getBoardValue(14)};
		streets[2] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(16), (Property) board.getBoardValue(18), (Property) board.getBoardValue(19)};
		streets[3] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(21), (Property) board.getBoardValue(22), (Property) board.getBoardValue(24)};
		streets[4] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(26), (Property) board.getBoardValue(27), (Property) board.getBoardValue(29)};
		streets[5] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(31), (Property) board.getBoardValue(32), (Property) board.getBoardValue(34)};
		streets[6] = new Street(props);
		props = new Property[]{(Property) board.getBoardValue(37), (Property) board.getBoardValue(39)};	
		streets[7] = new Street(props);
		return streets;
	}

}
