package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de gestion 
 * @author smill
 *
 */
public class ProcessingModule extends Module {

	public ProcessingModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
