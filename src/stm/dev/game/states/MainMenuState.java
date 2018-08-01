package stm.dev.game.states;

import stm.dev.game.Application;
import stm.dev.game.GameState;
import stm.dev.gui.MainMenu;

public class MainMenuState extends GameState {

	//
	private String[] choices = {"New Game", "Load Game", "Continue Game", "Save Game", "Game Options", "Exit Game"};

	//
	private boolean[] enabled = {true, true, false, false, true, true};

	//
	private MainMenu MM = null;

	/**
	 * 
	 * @param _name
	 * @param _appli
	 */
	public MainMenuState(String _name, Application _appli) {
		//
		super(_name, _appli);
		//
		MM = new MainMenu(this);
	}

	/**
	 * 
	 * @return
	 */
	public String[] getChoices()
	{
		return choices;
	}

	/**
	 * 
	 * @return
	 */
	public boolean[] getEnabled()
	{
		return enabled;
	}

	/**
	 * 
	 */
	public void deActivate() {
		//
		super.deActivate();
		//
		MM.disable();
	}

	/**
	 * 
	 */
	public void activate() {
		//
		super.activate();
		//
		boolean b = application.isGameCreated();
		//
		if (b) {
			enabled[2] = true;
			enabled[3] = true;
		}
		//
		MM.enable();
	}

	/**
	 * 
	 * @param command
	 */
	public void action(String command) {
		//
		int icommand = 0;
		//
		for (int i=0; i<choices.length; i++) {
			if (command.equals(choices[i])) {
				icommand = i;
				break;
			}
		}
		//
		switch(icommand) {
		case 0 : //"New Game"
			boolean doIt = true;
			if (application.isGameCreated()) {
				doIt = MM.confirmAction("Current Game will be lost. Continue anyway ?");
			}
			if (doIt) application.setCurrentGameState("New Game");
			break;
		case 1 : //"Load Game"
			loadGame();
			break;
		case 2 : //"Continue Game"
			application.setCurrentGameState("Game");
			break;
		case 3 : //"Save Game"
			saveGame();
			break;
		case 4 : //"Game Options"
			goToOptionsState();
			break;
		case 5 : //"Exit Game"
			Application.exit();
			break;
		}
	}

	/**
	 * 
	 */
	private void goToOptionsState() {
		
	}
	
	/**
	 * 
	 */
	private void loadGame() {
		
	}
	
	/**
	 * 
	 */
	private void saveGame() {
		
	}
}
