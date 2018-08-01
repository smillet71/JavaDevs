package stm.dev.game.states;

import stm.dev.game.Application;
import stm.dev.game.GameState;

public class NewGameState extends GameState {
	

	/**
	 * 
	 * @param _application
	 */
	public NewGameState(String _name, Application _application) {
		super(_name, _application);
	}

	/**
	 * 
	 */
	public void deActivate() {
		//
		super.deActivate();
		//
	}

	/**
	 * 
	 */
	public void activate() {
		//
		super.activate();
		//
		createNewGame();

	}

	/**
	 * 
	 */
	private void createNewGame() {
		//
		application.createNewGame();
		//
		application.setCurrentGameState("Game");
	}
}
