package stm.dev.game;

import java.util.Hashtable;
import java.util.Vector;

import stm.dev.game.objects.Game;
import stm.dev.game.states.GameOptionsState;
import stm.dev.game.states.GameRunningState;
import stm.dev.game.states.MainMenuState;
import stm.dev.game.states.NewGameState;

/**
 * 
 * @author smill
 *
 */
public class Application {

	//
	private Vector<GameState> gstates = null;
	//
	private Hashtable<String, GameState> hstates = null;
	//
	private GameState currentGameState = null;
	//
	private Game game = null;

	/**
	 * 
	 */
	public Application()
	{
		//
		loadIniFile();
		//
		initGameStates();
		//
		setCurrentGameState("MainMenu");
	}

	/**
	 * 
	 */
	private void loadIniFile() {
			Options.loadOptions();
	}

	/**
	 * 
	 */
	public void initGameStates() 
	{
		//
		gstates = new Vector<GameState>();
		hstates = new Hashtable<String, GameState>();
		//
		new MainMenuState("MainMenu", this);
		new GameOptionsState("OptionsMenu", this);
		new GameRunningState("Game", this);
		new NewGameState("New Game", this);
	}

	/**
	 * 
	 * @param gameState
	 */
	public void addState(GameState gameState) {
		gstates.add(gameState);
		hstates.put(gameState.getName(), gameState);
	}

	/**
	 * 
	 * @param gs
	 */
	public void setCurrentGameState(String gameStateName)
	{
		GameState gs = hstates.get(gameStateName);
		assert(gs!=null);
		setCurrentGameState(gs);
	}
	
	/**
	 * 
	 * @param gs
	 */
	public void setCurrentGameState(GameState gs)
	{
		//
		if (currentGameState!=null) {
			currentGameState.deActivate();
		}
		//
		currentGameState = gs;
		//
		currentGameState.activate();
	}


	/**
	 * 
	 * @return
	 */
	public boolean isGameCreated() {
		return game != null;
	}
	
	/**
	 * 
	 * @return
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * 
	 */
	public void createNewGame() {
		//
		game = new Game();
	}

	/**
	 * 
	 */
	public static void exit() {
		System.exit(-1);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		new Application();
	}


}
