package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de propulsion principale
 * @author smill
 *
 */
public class EngineModule extends Module {

	public EngineModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
