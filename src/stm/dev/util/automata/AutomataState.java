package stm.dev.util.automata;

/**
 * 
 * @author St�phane
 *
 */
public interface AutomataState {
	
	/**
	 * 
	 */
	public  void initialize();
	
	/**
	 * 
	 */
	public  void enter();

	/**
	 * 
	 */
	public  void tick();
	
	/**
	 * 
	 */
	public  void leave();
		

}
