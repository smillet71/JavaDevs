package stm.dev.game.objects;

import java.util.Hashtable;
import java.util.Vector;

import stm.dev.game.objects.Ship.ModuleFilterFunction;

/**
 * 
 * @author smill
 *
 */
public class Network {
	
	//
	Vector<Node> nodes = null;
	
	//
	Vector<Module> participants = null;

	/**
	 * Créer un réseau de modules
	 */
	public Network() {
		nodes = new Vector<Node>();
		participants = new Vector<Module>();
	}
	
	/**
	 * 
	 * @param n
	 */
	public void addNode(Node n, Ship.ModuleFilterFunction f2) {
		nodes.add(n);
		for (Module m : n.getModules()) {
			if (f2.filter(m)) {
				System.out.println("\t\t> module: "+m.getClass().getName()+" --> "+m);
				participants.add(m);
			}
		}
	}

	public int getParticipantsNumber() {
		return participants.size();
	}
	
}
