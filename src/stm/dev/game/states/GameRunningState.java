package stm.dev.game.states;

import stm.dev.game.Application;
import stm.dev.game.GameState;
import stm.dev.game.objects.CommandProcessor;
import stm.dev.game.objects.Game;
import stm.dev.gui.GameWindow;


public class GameRunningState extends GameState {

	//
	private GameWindow GW = null;
	
	// 
	private CommandProcessor cproc = null;
	
	/**
	 * 
	 * @param _game
	 */
	public GameRunningState(String _name, Application _appli) {
		super(_name, _appli);
	}

	/**
	 * 
	 */
	public void deActivate() {
		//
		super.deActivate();
		//
		cproc.disable();
		//
		GW.disable();
	}

	/**
	 * 
	 */
	public void activate() {
		//
		super.activate();
		//
		if (GW == null) {
			GW = new GameWindow(this);
			cproc = new CommandProcessor(getGame().getPlayerSC());
		}
		//
		cproc.enable();
		//
		GW.enable();
		
	}

	/**
	 * 
	 */
	public void goToMainMenu() {
		application.setCurrentGameState("MainMenu");
	}

	/**
	 * 
	 * @return
	 */
	public Game getGame() {
		return application.getGame();
	}

}
