package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de navigation
 * @author smill
 *
 */
public class NavigationModule extends Module {

	public NavigationModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
