package stm.dev.game.modules;

import stm.dev.game.objects.Module;
import stm.dev.game.objects.Node;

/**
 * Syst�me de gestion de la cargaison
 * @author smill
 *
 */
public class CargoManagementModule extends Module {

	/**
	 * 
	 * @param n
	 */
	public CargoManagementModule(Node n) {
		super(n);
		setConnectionNeeds(true, true, false, false);
	}

}
