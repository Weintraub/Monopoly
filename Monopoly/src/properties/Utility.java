package properties;

import main.Board;
import player.Player;

public class Utility extends Property {
	private int rent = 0;

	public Utility(String name, String colour, int cost) {
		super(name, colour, cost);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the rent
	 */
	public int getRent(Board board, int diceRollSum, Player player) {
		int[] indexes = new int[] { 12, 28 };
		for (int i = 0; i < 2; i++) {
			try {
				if (((Utility) board.getBoardValue(indexes[i])).getOwner().getName().equals(player.getName())) {
					if (i == 0) {
						rent += 4;
					} else if (i == 1 && rent > 0) {
						rent += 6;
					} else {
						rent += 4;
					}
				}
			} catch (Exception NullPointerException) {
				continue;
			}
		}
		int total = rent * diceRollSum;
		return total;
	}

	/**
	 * @param rent
	 *            the rent to set
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}

}
