package stm.dev.util.automata;

import java.util.Vector;

/**
 * 
 * @author Stéphane
 *
 */
public class Automata {

	//
	private int iInitialState = -1;
	private AutomataState initialState = null;
	//
	private int iCurrentState = -1;
	private AutomataState currentState = null;
	//
	private int iLastState = -1;
	//
	private int iEndState = -1;
	private AutomataState endState = null;
	//
	private AutomataState[] states = null;
	//
	private AutomataTransition[][] transitions = null;
	//
	private int nbStates = 0;
	//
	private boolean ended = false;
	//
	private int itick = 0;
	//
	private boolean OUT = false;

	/**
	 * 
	 * @param nbState
	 */
	public Automata(int nbState) {
		//
		this.nbStates = nbState;
		states = new AutomataState[nbState];
		transitions = new AutomataTransition[nbState][nbState];
	}
	
	/**
	 * 
	 */
	public void initialize() {
		//
		for (AutomataState state : states) {
			state.initialize();
		}
		//
		iCurrentState = iInitialState;
		currentState = initialState;
		iLastState = -1;
		ended = false;
		itick = 0;
	}
	
	/**
	 * 
	 */
	public void out(String s) {
		if (OUT) {
			System.out.println(s);
		}
	}

	/**
	 * 
	 */
	public void tick() {
		//
		itick = itick+1;
		// automata end state allready reached
		if (ended) return;
		// enter new state
		if (iLastState != iCurrentState) {
			out(itick+"  * enter "+iCurrentState);
			currentState.enter();
			iLastState = iCurrentState;
		}
		// tick current state
		currentState.tick();
		out(itick+"  * tick "+iCurrentState);
		// automata end state reached
		if (currentState == endState) {
			currentState.leave();
			ended = true;
			return;
		}
		// general case, test transitions
		for (int i=0; i<nbStates; i++) {
			if (i == iCurrentState) continue;
			AutomataTransition trans = transitions[iCurrentState][i];
			out(itick+"  * "+iCurrentState+"-->"+i+" = "+trans);
			if ((trans != null)&&trans.test()) {
				currentState.leave();
				out(itick+"  * leave "+iLastState);
				currentState = states[i];
				iCurrentState = i;
				break;
			}
		}
	}
	
	/**
	 * 
	 */
	public boolean hasEnded() {
		return ended;
	}

	/**
	 * 
	 */
	public int getICurrentState() {
		return iCurrentState;
	}
	
	/**
	 * 
	 */
	public int getITick() {
		return itick;
	}
	
	/**
	 * 
	 */
	public void showOUT(boolean b) {
		OUT = b;
	}
	
	/**
	 * 
	 */
	public AutomataState getCurrentState() {
		return currentState;
	}
	
	/**
	 * 
	 */
	public void addState(int i, AutomataState state) {
		addState(i, state, false, false);
	}

	/**
	 * 
	 */
	public void addState(int i, AutomataState state, boolean initial, boolean end) {
		assert((i>=0)&&(i<nbStates));
		if (initial) assert(end == false);
		if (end) assert(initial == false);
		states[i] = state;
		if (initial) {
			assert(iEndState != i);
			iInitialState = i;
			iCurrentState = i;
			initialState = currentState = state;
		}
		if (end) {
			assert(iInitialState != i);
			iEndState = i;
			endState = state;
		}
	}

	/**
	 * 
	 */
	public void addTransition(int from, int to, AutomataTransition trans) {
		assert((from>=0)&&(from<nbStates));
		assert((to>=0)&&(to<nbStates));
		transitions[from][to] = trans;
	}

	/**
	 * 
	 */
	public void transition(int from, int to, AutomataTransition trans) {
		assert((from>=0)&&(from<nbStates));
		assert((to>=0)&&(to<nbStates));
		transitions[from][to] = trans;
	}

	/**
	 * 
	 */
	public boolean verifyReady() {
		out("initial state: "+(initialState != null));
		assert(initialState != null);
		out("current state: "+(currentState != null));
		assert(currentState != null);
		out("end state: "+(endState != null));
		assert(endState != null);
		for (int i=0; i<nbStates; i++) {
			out("state "+i+" defined: "+(states[i] != null));
			assert(states[i] != null);
		}
		for (int i=0; i<nbStates; i++) {
			if (i != iInitialState) {
				boolean r = reachable(i, iInitialState);
				out("reachable "+i+" from init "+iInitialState+": "+r);
				assert(r);
			}
		}
		for (int i=0; i<nbStates; i++) {
			if (i != iEndState) {
				boolean r = reachable(iEndState, i);
				out("reachable end "+iEndState+" from "+i+": "+r);
				assert(r);
			}
		}
		return true;
	}

	/**
	 * 
	 */
	public boolean reachable(int igoal, int ifrom) {
		//
		if (igoal == ifrom) return true;
		else {
			Vector<Integer> visited = new Vector<Integer>();
			visited.add(ifrom);
			return reachable(igoal, ifrom, visited, "");
		}
	}
	/**
	 * 
	 */
	private boolean reachable(int igoal, int ifrom, Vector<Integer> visited, String path) {
		//
		String npath = new String(path+";"+ifrom);
		visited.add(ifrom);
		//
		if (transitions[ifrom][igoal] != null) {
			out("\npath: "+npath+";"+igoal);
			return true;
		}
		else {
			for (int i=0; i<nbStates; i++) {
				if ((!visited.contains(i)) && (i != igoal) && (transitions[ifrom][i] != null) ) {
					return reachable(igoal, i, visited, npath);
				}
			}
		}
		//
		return false;	
	}

}
