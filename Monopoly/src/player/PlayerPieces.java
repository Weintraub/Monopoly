package player;

public enum PlayerPieces {
	
	BATTLESHIP("BATTLESHIP"),
	CAT("CAT"),
	DOG("DOG"),
	PENGUIN("PENGUIN"),
	RACECAR("RACECAR"),
	DUCK("DUCK"),
	TOPHAT("TOP-HAT"),
	TREX("T-REX"),
	NONE("NONE");

	private String name;
	
	PlayerPieces(String name)
	{
		this.name = name; 
	}
	
	public String getName()
	{
		return name;
	}
	
	
}
