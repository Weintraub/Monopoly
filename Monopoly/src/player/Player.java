package player;

import properties.Property;
import properties.Space;

public class Player {
	private String name;
	private String character;
	private int money = 1500;
	private Space[] properties = new Space[40];
	private boolean getOutOfJailFree = false;
	private int location = 0;
	private boolean inJail = false;
	private int turnsInJail = 0;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		System.out.println("name : " + name);
		//System.out.println("character : " + character);
		System.out.println("money : " + money);
		System.out.println("location : " + location);
		//System.out.println("in jail : " + inJail);
		System.out.println("properties :");
		for(Space s : properties){
			if(!(s == null)){
				System.out.println(s.getName());
			}
		}
		return "";
	}

	/**
	 * @param name
	 * @param character
	 */
	public Player(String name, String character) {
		this.name = name;
		this.character = character;

	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the item
	 */
	public String getCharacter() {
		return character;
	}

	/**
	 * @param item
	 *            the item to set
	 */
	public void setCharacter(String character) {
		this.character = character;
	}

	/**
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * @param money
	 *            the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * @return the properties
	 */
	public Space[] getProperties() {
		return properties;
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Space[] properties) {
		this.properties = properties;
	}

	/**
	 * @return the location
	 */
	public int getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(int location) {
		this.location = location;
	}
	
	public void addMoves(int moves) {
		this.location += moves;
		if(location > 40){
			System.out.println("You passed GO, collect $200");
			money += 200;
			location -= 40;
		} else if (location == 40){
			System.out.println("You landed on GO, collect $400");
			money += 400;
			location -= 40;
		}
	}

	public void addMoney(int money) {
		this.money += money;
		System.out.println("You gained " + money + " dollars.");
	}

	public void loseMoney(int money) {
		this.money -= money;
		System.out.println("You paid " + money + " dollars.");
	}

	/**
	 * @return the getOutOfJailFree
	 */
	public boolean isGetOutOfJailFree() {
		return getOutOfJailFree;
	}

	/**
	 * @param getOutOfJailFree
	 *            the getOutOfJailFree to set
	 */
	public void setGetOutOfJailFree(boolean getOutOfJailFree) {
		this.getOutOfJailFree = getOutOfJailFree;
	}

	/**
	 * @return the turnsInJail
	 */
	public int getTurnsInJail() {
		return turnsInJail;
	}

	/**
	 * @param turnsInJail
	 *            the turnsInJail to set
	 */
	public void setTurnsInJail(int turnsInJail) {
		this.turnsInJail = turnsInJail;
	}

	/**
	 * @return the inJail
	 */
	public boolean isInJail() {
		return inJail;
	}

	/**
	 * @param inJail
	 *            the inJail to set
	 */
	public void setInJail(boolean inJail) {
		this.inJail = inJail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((character == null) ? 0 : character.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		if (character == null) {
			if (other.character != null) {
				return false;
			}
		} else if (!character.equals(other.character)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}
	
	public void addProperty(int index, Property p){
		properties[index] = p;
	}
	
	public void decrementJail(){
		if (isInJail()) {
			if (getTurnsInJail() == 0) {
				inJail = false;
			} else {
				turnsInJail--;
			}
		}
	}
	
	public void checkWin(Player[] players){
		if (money < 0) {
			System.out.println("Game Over");
			Player winner = players[0];
			for (Player winners : players) {
				if (winners.getMoney() > winner.getMoney()) {
					winner = winners;
				}
			}
			System.out.println(winner.getName() + " has won the game!");
			System.exit(0);
		}
	}

}
