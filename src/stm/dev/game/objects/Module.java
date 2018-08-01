package stm.dev.game.objects;

/**
 * 
 * @author smill
 *
 */
public class Module implements CommandProcessorInterface {
	
	//
	private boolean dataConnection = false;
	private boolean energyConnection = false;
	private boolean matterConnection = false;
	private boolean botsConnection = false;

	// parent node
	Node node = null;
	
	/**
	 * Création d'un module
	 * @param n parent node
	 */
	public Module(Node n) {
		node = n;
	}

	// accès à la liste des commandes
	@Override
	public String[] getCommandList() {
		// TODO Auto-generated method stub
		return null;
	}

	// accès à une commande
	@Override
	public Command getCommand(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param _data
	 */
	public void setConnectionNeeds(boolean _data, boolean _energy, boolean _matter, boolean _bots) {
		dataConnection = _data;
		energyConnection = _energy;
		matterConnection = _matter;
		botsConnection = _bots;
	}

	/**
	 * 
	 * @return
	 */
	public boolean needsDataConnection() {
		return dataConnection;
	}

	/**
	 * 
	 * @return
	 */
	public boolean needsEnergyConnection() {
		return energyConnection;
	}

	/**
	 * 
	 * @return
	 */
	public boolean needsMatterConnection() {
		return matterConnection;
	}

	/**
	 * 
	 * @return
	 */
	public boolean needsBotsConnection() {
		return botsConnection;
	}
}
