package stm.dev.game.builds;

import stm.dev.game.objects.GameWorld;
import stm.dev.game.objects.Ship;

public class ShipFactory {

	/**
	 * Créer un cargo
	 */
	public static Ship buildCargoShip(GameWorld world) {
		//
		var ship = new Ship(world);
		// Axis (75x5x5)
		var axis = NodeFactory.buildCargoAxisNode("AXIS");
		ship.addNode(axis, 0, 0, 0);
		// Engine (25x10x10)
		var engine = NodeFactory.buildMainEngineNode("ENG");
		ship.addNode(engine, (int)(-axis.getVolume().getLength()/2-20-engine.getVolume().getLength()/2), 0, 0);
		// cargo modules (15x5x5)
		var c01 = NodeFactory.buildCargoNode("C01"); ship.addNode(c01, -28, -15, 0);
		var c02 = NodeFactory.buildCargoNode("C02"); ship.addNode(c02, -10, -15, 0);
		var c03 = NodeFactory.buildCargoNode("C03"); ship.addNode(c03, -28, 15, 0);
		var c04 = NodeFactory.buildCargoNode("C04"); ship.addNode(c04, -10, 15, 0);
		var c11 = NodeFactory.buildCargoNode("C11"); ship.addNode(c11, 28, -15, 0);
		var c12 = NodeFactory.buildCargoNode("C12"); ship.addNode(c12, 10, -15, 0);
		var c13 = NodeFactory.buildCargoNode("C13"); ship.addNode(c13, 28, 15, 0);
		var c14 = NodeFactory.buildCargoNode("C14"); ship.addNode(c14, 10, 15, 0);
		// service module (Sphere r=10)
		var support1 = NodeFactory.buildCargoSupportNode("SUP1"); 
		ship.addNode(support1, axis.getVolume().getLength()/2+10, 0, 0);
		var support2 = NodeFactory.buildCargoSupportNode("SUP2"); 
		ship.addNode(support2, -axis.getVolume().getLength()/2-10, 0, 0);
		// command module (Sphere r=10)
		var cmd = NodeFactory.buildCargoCommandNode("CMD"); 
		ship.addNode(cmd, axis.getVolume().getLength()/2+30, 0, 0);
		// connection between Axis and Cargo nodes
		ship.connectNodes(axis, c01, true, true, true, true);
		ship.connectNodes(axis, c02, true, true, true, true);
		ship.connectNodes(axis, c03, true, true, true, true);
		ship.connectNodes(axis, c04, true, true, true, true);
		ship.connectNodes(axis, c11, true, true, true, true);
		ship.connectNodes(axis, c12, true, true, true, true);
		ship.connectNodes(axis, c13, true, true, true, true);
		ship.connectNodes(axis, c14, true, true, true, true);
		// connection between Axis support nodes
		ship.connectNodes(axis, support1, true, true, true, true);
		ship.connectNodes(axis, support2, true, true, true, true);
		// connection between support node 1 and command node
		ship.connectNodes(cmd, support1, true, true, true, true);
		// connection between Axis support nodes
		ship.connectNodes(engine, support2, true, true, true, true);
		//
		ship.buildAllNetworks();
		//
		return ship;
	}
	
	public static void main(String[] args) {
		buildCargoShip(null);
	}
}
