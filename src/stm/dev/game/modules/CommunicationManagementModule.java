package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de gestion des communications 
 * @author smill
 *
 */
public class CommunicationManagementModule extends Module {

	public CommunicationManagementModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

	
}
