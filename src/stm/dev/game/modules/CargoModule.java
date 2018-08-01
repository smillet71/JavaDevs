package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module correspondant à un conteneur
 * @author smill
 *
 */
public class CargoModule extends Module {

	public CargoModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, true, false);
	}

}
