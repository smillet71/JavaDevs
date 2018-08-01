package stm.dev.game;

/**
 * 
 * @author smill
 *
 */
public class GameState  {
	
	private String name = null;
	protected Application application = null;
	private boolean activated = false;
	
	/**
	 * 
	 * @param _game
	 */
	public GameState(String _name, Application _appli)
	{
		name = _name;
		application = _appli;
		application.addState(this);
	}

	/**
	 * 
	 */
	public void deActivate() {
		activated = false;
	}
	
	/**
	 * 
	 */
	public void activate() {
		System.out.println("state "+name+" activated");
		activated = true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isActivated() {
		return activated;
	}

	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
}
