package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module Senseur (partie physique)
 * @author smill
 *
 */
public class SensorModule extends Module {

	public SensorModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
