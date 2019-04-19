package main;
// A monopoly board consists of a total of 40 spaces

import properties.Space;

// 28 properties
// Twenty Two Streets (8 Color Groups)
// 4 Railway Stations
// 3 Chance spots
// 3 Community Chests
// 4 Event spots (Go,Jail,Parking,GoToJail)

public class Board {
	private Space[] board;

	/**
	 * @return the board
	 */
	public Space[] getBoard() {
		return board;
	}

	/**
	 * @param board
	 *            the board to set
	 */
	public void setBoard(Space[] board) {
		this.board = board;
	}

	/**
	 * @param board
	 */
	public Board(Space[] board) {
		this.board = board;
	}

	public void setBoardValue(int index, Space value) {
		this.board[index] = value;
	}

	/**
	 * @param board
	 * @param index
	 * @return
	 */
	public Space getBoardValue(int index) {
		return this.board[index];

	}

}
