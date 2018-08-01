//
package stm.dev.game.objects;

import java.util.Hashtable;
import java.util.Vector;

public class Ship extends GameObject implements CommandProcessorInterface {
	
	// Liste des noeuds
	private Hashtable<String, Node> nodes = null;
	
	// Réseaux d'énergie
	Vector<Network> energyNetworks = null;
	
	// Réseaux de données
	Vector<Network> dataNetworks = null;
	
	// Réseaux de matière
	Vector<Network> matterNetworks = null;
	
	// Réseaux de circulation de robots
	Vector<Network> botsNetworks = null;
	
	/**
	 * Constructeur
	 * @param gworld
	 */
	public Ship(GameWorld gworld) {
		super(gworld);
		nodes = new Hashtable<String, Node>();
	}
	
	/**
	 * Ajouter un noeud avec delta position par rapport à 0,0,0
	 * @param n
	 */
	public void addNode(Node n, int dx, int dy, int dz) {
		nodes.put(n.getNodeName(), n);
		int[] dpos = {dx, dy, dz};
		n.getVolume().setDPos(dpos);
	}

	/**
	 * Liste des commandes accessibles
	 */
	@Override
	public String[] getCommandList() {
		return null;
	}

	/**
	 * Accès à une commande particulière
	 */
	@Override
	public Command getCommand(String name) {
		return null;
	}
	
	/**
	 * Relier 2 noeuds
	 * 
	 * @param n1
	 * @param n2
	 * @param _data
	 * @param _energy
	 * @param _matter
	 * @param _bots
	 * @return
	 */
	public Link connectNodes(Node n1, Node n2, boolean _data, boolean _energy, boolean _matter, boolean _bots) {
		var link = new Link(n1, n2, _data, _energy, _matter, _bots);
		n1.connectTo(n2.getNodeName(), link);
		n2.connectTo(n1.getNodeName(), link);
		return link;
	}
	
	/**
	 * Créer les réseaux de données, énergie, matière, bots
	 */
	public void buildAllNetworks() {
		energyNetworks = buildNetworks();
		dataNetworks = buildNetworks();
		matterNetworks = buildNetworks();
		botsNetworks = buildNetworks();
	}

	public Vector<Network> buildNetworks() {
		//
		Vector<Network> networks = new Vector<Network>();
		//
		return networks;
	}
}
