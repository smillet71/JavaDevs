package stm.dev.game.objects;

public class GameObject {
	
	//
	private GameWorld gworld = null;

	/**
	 * 
	 * @param gworld
	 */
	public GameObject(GameWorld gworld) {
		this.gworld = gworld;
	}
	
	/**
	 * 
	 * @return
	 */
	public GameWorld world() {
		return gworld;
	}
}
