package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module d'impression 3D de pièces détachées
 * @author smill
 *
 */
public class Printer3DModule extends Module {

	public Printer3DModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, true, false);
	}

}
