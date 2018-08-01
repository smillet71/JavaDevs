package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de communication (moyens physiques)
 * @author smill
 *
 */
public class CommunicationModule extends Module {

	public CommunicationModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

	
}
