package stm.dev.game.modules;


import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Module de g�n�ration d'�nergie
 * @author smill
 *
 */
public class GeneratorModule extends Module {

	public GeneratorModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
