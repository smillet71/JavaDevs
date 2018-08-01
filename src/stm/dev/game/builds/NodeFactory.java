package stm.dev.game.builds;

import stm.dev.game.modules.BotStationModule;
import stm.dev.game.modules.CargoManagementModule;
import stm.dev.game.modules.CargoModule;
import stm.dev.game.modules.CommandModule;
import stm.dev.game.modules.CommunicationManagementModule;
import stm.dev.game.modules.CommunicationModule;
import stm.dev.game.modules.EngineModule;
import stm.dev.game.modules.GeneratorModule;
import stm.dev.game.modules.MaintenanceModule;
import stm.dev.game.modules.ProcessingModule;
import stm.dev.game.modules.NavigationModule;
import stm.dev.game.modules.Printer3DModule;
import stm.dev.game.modules.SensorManagementModule;
import stm.dev.game.modules.SensorModule;
import stm.dev.game.modules.TacticalModule;
import stm.dev.game.modules.ThrustersModule;
import stm.dev.game.objects.Node;
import stm.dev.util.Volume;

/**
 * 
 * @author smill
 *
 */
public class NodeFactory {
	
	/**
	 * 
	 * @param radius
	 * @param struct
	 * @param armor
	 * @param shield
	 * @return
	 */
	public static Node buildSphericalNode(String name, int radius, short struct, short armor, short shield) {
		var node = new Node(name);
		node.setVolume(Volume.buildSphere(radius));
		node.initializeStructureArmorShield(struct, armor,shield);
		return node;
	}

	/**
	 * 
	 * @param radius
	 * @param struct
	 * @param armor
	 * @param shield
	 * @return
	 */
	public static Node buildCubeNode(String name, int length, int width, int height, short struct, short armor, short shield) {
		var node = new Node(name);
		node.setVolume(Volume.buildCube(length, width, height));
		node.initializeStructureArmorShield(struct, armor,shield);
		return node;
	}

	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Node buildMainEngineNode(String name) {
		//
		short struct = 5;
		short armor = 1;
		short shield = 0;
		//
		var n = buildCubeNode(name, 25, 10, 10, struct, armor, shield);
		//
		var em1 = new EngineModule(n);
		n.addModule(name+"_E_1", em1);
		//
		var em2 = new EngineModule(n);
		n.addModule(name+"_E_2", em2);
		//
		var g1 = new GeneratorModule(n);
		n.addModule(name+"_G_1", g1);
		//
		var g2 = new GeneratorModule(n);
		n.addModule(name+"_G_2", g2);
		//
		var m = new MaintenanceModule(n);
		n.addModule(name+"_M", m);
		//
		var mgmt = new ProcessingModule(n);
		n.addModule(name+"_MGMT", mgmt);
		//
		return n;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Node buildCargoAxisNode(String name) {
		//
		short struct = 5;
		short armor = 1;
		short shield = 0;
		//
		var n = buildCubeNode(name, 75, 5, 5, struct, armor, shield);
		//
		var m = new MaintenanceModule(n);
		n.addModule(name+"_MAINT", m);
		//
		var cargo_mgmt = new CargoManagementModule(n);
		n.addModule(name+"_CARGO_MGMT", cargo_mgmt);
		//
		var mgmt = new ProcessingModule(n);
		n.addModule(name+"_MGMT", mgmt);
		
		return n;
	}
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Node buildCargoNode(String name) {
		//
		short struct = 5;
		short armor = 1;
		short shield = 0;
		// Node module 15, 5, 5
		var n = buildCubeNode(name, 15, 15, 15, struct, armor, shield);
		//
		for (int j=1; j<=9; j++) {
			var moduleName = name+"_"+j;
			var cm1 = new CargoModule(n);
			n.addModule(moduleName, cm1);
		}
		//
		return n;
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static Node buildCargoSupportNode(String name) {
		//
		short struct = 5;
		short armor = 1;
		short shield = 0;
		// Node module 15, 5, 5
		var n = buildSphericalNode(name, 10, struct, armor, shield);
		//
		var m = new MaintenanceModule(n);
		n.addModule(name+"_MAINT", m);
		//
		var rcs = new ThrustersModule(n);
		n.addModule(name+"_RCS", rcs);
		//
		var s = new SensorModule(n);
		n.addModule(name+"_S", s);
		//
		var c = new CommunicationModule(n);
		n.addModule(name+"_C", c);
		//
		var p = new Printer3DModule(n);
		n.addModule(name+"_P3D", p);
		//
		var b = new BotStationModule(n);
		n.addModule(name+"_BOTS", b);
		//
		var g = new GeneratorModule(n);
		n.addModule(name+"_G", g);
		//
		return n;
	}

	/**
	 * 
	 * @param string
	 * @return
	 */
	public static Node buildCargoCommandNode(String name) {
		//
		short struct = 5;
		short armor = 1;
		short shield = 0;
		// Node module 15, 5, 5
		var n = buildSphericalNode(name, 10, struct, armor, shield);
		//
		var s1 = new SensorModule(n);
		n.addModule(name+"_S1", s1);
		//
		var s2 = new SensorModule(n);
		n.addModule(name+"_S2", s2);
		//
		var c = new CommunicationModule(n);
		n.addModule(name+"_C", c);
		//
		var nav = new NavigationModule(n);
		n.addModule(name+"_NAV", nav);
		//
		var tac = new TacticalModule(n);
		n.addModule(name+"_TAC", tac);
		//
		var cmd = new CommandModule(n);
		n.addModule(name+"_CMD", cmd);
		//
		var mgmt = new ProcessingModule(n);
		n.addModule(name+"_MGMT", mgmt);
		//
		var commgmt = new CommunicationManagementModule(n);
		n.addModule(name+"_COMMS", commgmt);
		//
		var sensorgmt = new SensorManagementModule(n);
		n.addModule(name+"_SENSORS", sensorgmt);
		//
		return n;
	}

}
