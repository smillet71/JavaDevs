package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de gestion des Senseurs 
 * @author smill
 *
 */
public class SensorManagementModule extends Module {

	public SensorManagementModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
