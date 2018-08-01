package stm.dev.game.objects;

import java.util.Hashtable;

/**
 * 
 * @author smill
 *
 */
public class Network {
	
	//
	Hashtable<String, Module> participants = null;

	/**
	 * Créer un réseau de modules
	 */
	public Network() {
		participants = new Hashtable<String, Module>();
	}
	
}
