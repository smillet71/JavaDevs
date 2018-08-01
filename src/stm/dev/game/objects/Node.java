package stm.dev.game.objects;

import java.util.Hashtable;

import stm.dev.util.Parameter;
import stm.dev.util.Volume;

/**
 * 
 * @author smill
 *
 */
public class Node implements CommandProcessorInterface {
	
	// paramètres relatifs à la protection du noeud
	private Parameter<Short> structure = null;
	private Parameter<Short> armor = null;
	private Parameter<Short> shield = null;
	
	// liste des liaisons avec d'autres noeuds
	private Hashtable<String, Link> links = null;
	
	// définition de volume du noeud
	private Volume volume = null;
	
	// liste des modules contenus par le noeud
	private Hashtable<String, Module> modules = null;
	
	// identifiant du noeud
	private String nodeName = null;
	
	// Constructeur
	public Node(String name) {
		setNodeName(name);
		modules = new Hashtable<String, Module>();
		links = new Hashtable<String, Link>();
	}
	
	// ajouter un module
	public void addModule(String moduleID, Module mod) {
		assert(modules.get(moduleID) == null);
		assert(mod != null);
		modules.put(moduleID,  mod);
	}
	
	// ajouter un lien vers un autre noeud
	public void addLink(String toNodeName, Link link) {
		assert(modules.get(toNodeName) == null);
		assert(link != null);
		assert((link.getN1() == this)||(link.getN2() == this));
		links.put(toNodeName, link);
	}
	
	// liste des commandes
	@Override
	public String[] getCommandList() {
		// TODO Auto-generated method stub
		return null;
	}

	// accès à une commande particulière
	@Override
	public Command getCommand(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	// initialiser les caractéristiques physiques du noeud
	public void initializeStructureArmorShield(short _struct, short _armor, short _shield) {
		//
		structure = new Parameter<Short>();
		armor = new Parameter<Short>();
		shield = new Parameter<Short>();
		//
		structure.setOrgAndValue(_struct);
		armor.setOrgAndValue(_armor);
		shield.setOrgAndValue(_shield);
	}

	// accès au volume du noeud
	public Volume getVolume() {
		return volume;
	}

	// accès au nom du noeud
	public String getNodeName() {
		return nodeName;
	}

	// fixer le nom du noeud
	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	// fixer le volume du noeud
	public void setVolume(Volume v) {
		volume = v;		
	}

	// relier ce noeud à un autre noeud
	public void connectTo(String _n, Link link) {
		assert(links.get(_n) == null);
		assert(_n instanceof String);
		links.put(_n, link);
	}
}
