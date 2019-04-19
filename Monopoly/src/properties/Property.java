package properties;

import player.Player;

public class Property extends Space {
	private int rent;
	private int houses = 0; // 1 -3 actual house if 4 means its hotel
	private int houseCost;
	private int cost;
	private Player owner = null;
	
	public Property(String name, String colour, int cost) {
		super(name, colour);
		this.cost = cost;
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Property [cost=" + cost + ", owner=" + owner + "]";
	}

	/**
	 * @return the houses
	 */
	public int getHouses() {
		return houses;
	}

	/**
	 * @param houses the houses to set
	 */
	public void setHouses(int houses) {
		this.houses = houses;
	}


	/**
	 * @return the houseCost
	 */
	public int getHouseCost(int location) {
		if(location < 10){
			houseCost = 50;
		} else if (location < 20){
			houseCost = 100;
		} else if (location < 30){
			houseCost = 150;
		} else if (location < 40){
			houseCost = 200;
		}
		return houseCost;
	}

	/**
	 * @param houseCost the houseCost to set
	 */
	public void setHouseCost(int houseCost) {
		this.houseCost = houseCost;
	}

	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost
	 *            the cost to set
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}

	/**
	 * @return the owner
	 */
	public Player getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Player owner) {
		this.owner = owner;
	}

	/**
	 * @return the rent
	 */
	public int getRent(int location) {
		switch (location + 1) {
		case 2:
		case 4:
			rent = (int) (cost * 0.04);
			break;
		case 7:
		case 9:
		case 10:
			rent = (int) (cost * 0.06);
			break;
		case 12:
		case 14:
		case 15:
			rent = (int) (cost * 0.07);
			break;
		case 17:
		case 19:
		case 20:
		case 22:
		case 24:
		case 25:
			rent = (int) (cost * 0.08);
			break;
		case 27:
		case 28:
		case 30:
		case 32:
		case 33:
		case 35:
			rent = (int) (cost * 0.09);
			break;
		case 38:
		case 40:
			rent = (int) (cost * 0.1);
			break;
		}
		switch(houses){
		case 1:
			rent*=5;
			break;
		case 2:
			rent*=15;
			break;
		case 3:
			rent *= 30;
			break;
		case 4:
			rent *= 45;
			break;
		}
		//System.out.println(rent);
		return rent;
	}

	/**
	 * @param rent
	 *            the rent to set
	 */
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	public Player buyHouse(Player p){
		houses++;
		p.loseMoney(houseCost);
		return p;
	}

}
