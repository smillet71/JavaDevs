package stm.dev.game.objects;

public class Game {

	//
	GameWorld gworld = null;
	
	//
	Ship playerSC = null;
	
	// 
	public Game() {
		gworld = new GameWorld();
		playerSC = new Ship(gworld);
	}
	
	//
	public Ship getPlayerSC() {
		return playerSC;
	}
	
}
