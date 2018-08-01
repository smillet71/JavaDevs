package stm.dev.game.objects;

/**
 * 
 * @author smill
 *
 */
public class Link {

	// Links possibilities
	boolean data = false;
	boolean energy = false;
	boolean matter = false;
	boolean bots = false;
	
	// noeuds reliés
	Node n1 = null;
	Node n2 = null;
	
	/**
	 * Création d'un lien entre 2 noeuds
	 * @param _n1
	 * @param _n2
	 * @param _data
	 * @param _energy
	 * @param _matter
	 * @param _bots
	 */
	public Link(Node _n1, Node _n2, boolean _data, boolean _energy, boolean _matter, boolean _bots) {
		n1 = _n1;
		n2 = _n2;
		data = _data;
		energy = _energy;
		matter = _matter;
		bots = _bots;
	}
	
	// accès au 1ier noeud
	public Node getN1() { return n1; }
	// accès au 2nd noeud
	public Node getN2() { return n2; }

}
