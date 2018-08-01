package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de gestion Tactique
 * @author smill
 *
 */
public class TacticalModule extends Module {

	public TacticalModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
