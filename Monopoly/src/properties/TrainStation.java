package properties;

import main.Board;
import player.Player;

public class TrainStation extends Property {
	private int rent = 25;

	public TrainStation(String name, String colour, int cost) {
		super(name, colour, cost);
	}

	/**
	 * @return the rent
	 */
	public int getRent(Board board, Player player) {
		int multiplier = -1;
		int[] trainIndexes = new int[] { 5, 15, 25, 35 };
		for (int i = 0; i < 4; i++) {
			try {
				if (((TrainStation) board.getBoardValue(trainIndexes[i])).getOwner().getName()
						.equals(player.getName())) {
					multiplier++;
				}
			} catch (Exception NullPointerException) {
				continue;
			}

		}
		return (int) (rent * Math.pow(2, multiplier));
	}

	/**
	 * @param rent
	 *            the rent to set
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}

}
