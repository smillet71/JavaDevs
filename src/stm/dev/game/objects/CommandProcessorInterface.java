package stm.dev.game.objects;

public interface CommandProcessorInterface {

	//
	String[] getCommandList();
	
	//
	Command getCommand(String name);
	
}
