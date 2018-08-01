package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Station de mise à disposition de bots pour la maintenance d'un vaisseau
 * @author smill
 *
 */
public class BotStationModule extends Module {

	/**
	 * 
	 * @param n
	 */
	public BotStationModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, true);
	}

}
