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
		//energyNetworks = buildNetworks((Link l) -> l.energy, (Module m) -> m.needsEnergyConnection(), () -> new Network());
		//dataNetworks = buildNetworks((Link l) -> l.data, (Module m) -> m.needsDataConnection(), () -> new Network());
		matterNetworks = buildNetworks((Link l) -> l.matter, (Module m) -> m.needsMatterConnection(), () -> new Network());
		//botsNetworks = buildNetworks((Link l) -> l.bots, (Module m) -> m.needsBotsConnection(), () -> new Network());
	}

	// Filtrage des modules
	protected interface LinkFilterFunction {
		public boolean filter(Link m);
	}

	// Filtrage des modules
	protected interface ModuleFilterFunction {
		public boolean filter(Module m);
	}

	// Création d'un réseau
	protected interface NetworkBuilder {
		public Network create();
	}

	/**
	 * 
	 * @param f
	 * @param nb
	 * @return
	 */
	public Vector<Network> buildNetworks(LinkFilterFunction f1, ModuleFilterFunction f2, NetworkBuilder nb) {
		//
		Vector<Network> networks = new Vector<Network>();

		//
		Vector<Node> input = new Vector<Node>();
		input.addAll(nodes.values());
		//
		while(input.size()>0) {
			//
			Network net = nb.create();
			networks.add(net);
			Node n = input.firstElement();
			System.out.println("# new network: ");
			System.out.println("\t> node: "+n.getNodeName());
			input.remove(n);
			//
			add2network(n, input, f1, f2, nb, net);
			//
			if (net.getParticipantsNumber()>0) {
				net.addNode(n, f2);
				System.out.println(" > network added ! ");
			}
			else {
				System.out.println(" > network removed ! ");		
			}

		}

		//
		return networks;
	}

	/**
	 * 
	 * @param firstElement
	 * @param input
	 * @param f1
	 * @param f2
	 * @param nb
	 * @param net
	 */
	private void add2network(Node firstElement, Vector<Node> input, LinkFilterFunction f1, ModuleFilterFunction f2,
			NetworkBuilder nb, Network net) 
	{
		for (Link link : firstElement.getLinks()) {
			if (f1.filter(link)) {
				Node nextNode = (link.n1 == firstElement)?link.n2:link.n1;
				if (input.contains(nextNode)) {
					System.out.println("\t> node: "+nextNode.getNodeName());
					input.remove(nextNode);
					net.addNode(nextNode, f2);
					add2network(nextNode, input, f1, f2, nb, net);
				}
			}
		}
	}
}
