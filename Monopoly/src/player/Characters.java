package player;

import java.util.List;

public class Characters {
	
	private List<PlayerPieces> pp;
	
	
	private String[] chars = new String[] { "BATTLESHIP", "CAT", "DOG", "PENGUIN", "RACECAR", "DUCK", "TOP HAT",
	"T-REX","" };

	/**
	 * @return the chars
	 */
	public String[] getChars() {
		return chars;
	}

	/**
	 * @param chars the chars to set
	 */
	public void setChars(String[] chars) {
		this.chars = chars;
	}
	
	public void removeChar(int index){
		String[] newArr = new String[chars.length - 1];
		int j = 0;
		for (int i = 0; i < chars.length; i++) {
			if (i == index) {
				continue;
			} else {
				newArr[j] = chars[i];
				j++;
			}
		}
		chars = newArr;
	}
	
	public void printChars() {
		for (int i = 0; i < chars.length-1; i++) {
			System.out.println(i + 1 + " - " + chars[i]);
		}
	}

	public String getAtIndex(int index){
		//System.out.println(index);
		return chars[index];
	}
	
	public int length(){
		return chars.length;
	}
}
