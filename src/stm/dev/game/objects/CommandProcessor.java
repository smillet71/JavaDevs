package stm.dev.game.objects;

public class CommandProcessor {
	
	private boolean enabled = false;

	public CommandProcessor(CommandProcessorInterface cpi) {
		
	}

	public void analyseCommand(String text) {
		//
		if (!enabled) return ;
		//
	}
	
	public void enable() {
		enabled = true;
	}
	public void disable() {
		enabled = false;
	}
	
}
