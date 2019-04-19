package properties;

import java.util.Arrays;

import player.Player;

public class Street {
	private Property[] street;

	/**
	 * @return the street
	 */
	public Property[] getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(Property[] street) {
		this.street = street;
	}
	
	public Property getStreetIndexValue(int index){
		return street[index];
	}

	/**
	 * @param street
	 */
	public Street(Property[] street) {
		this.street = street;
	}
	
	public boolean getBooleanStreet(Property p, Player player, Player[] players){
		boolean answer = true;
		Property firstValue = street[0];
		for(Property prop : street){
			if(!firstValue.getOwner().equals(prop.getOwner())){
				answer = false;
				break;
			}
			
		}
		return answer;
	}
	
	
}
