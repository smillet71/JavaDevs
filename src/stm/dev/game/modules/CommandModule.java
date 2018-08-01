package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de commandement
 * @author smill
 *
 */
public class CommandModule extends Module {

	public CommandModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
