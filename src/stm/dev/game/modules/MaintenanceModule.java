package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de gestion de la maintenance
 * @author smill
 *
 */
public class MaintenanceModule extends Module {

	public MaintenanceModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, true);
	}

}
