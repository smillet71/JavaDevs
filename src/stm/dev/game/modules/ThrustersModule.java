package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de propulsion secondaire (rotation)
 * @author smill
 *
 */
public class ThrustersModule extends Module {

	/**
	 * 
	 * @param n
	 */
	public ThrustersModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
