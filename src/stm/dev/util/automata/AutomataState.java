package stm.dev.util.automata;

/**
 * 
 * @author Stéphane
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
