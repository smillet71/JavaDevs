package stm.dev.util.automata;

/**
 * 
 * @author Stéphane
 *
 */
public class AutomataTest {
	
	//
	public static class State implements AutomataState {
		@Override
		public void initialize() {
		}
		@Override
		public void enter() {
		}
		@Override
		public void tick() {
		}
		@Override
		public void leave() {
		}
	}
	
	//
	public static class Transition implements AutomataTransition {
		private int N = 0;
		private int n = 0;
		public Transition() { }
		public Transition(int N) { this.N = N; }
		@Override
		public boolean test() {
			n=n+1;
			if (n>=N) return true;
			else return false;
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//
		Automata A = new Automata(8);
		A.showOUT(true);
		//
		State S0 = new State();
		State S1 = new State();
		State S2 = new State();
		State S3 = new State();
		State S4 = new State();
		State S5 = new State();
		State S6 = new State();
		State S7 = new State();
		//
		A.addState(0, S0, true, false);
		A.addState(1, S1);
		A.addState(2, S2);
		A.addState(3, S3);
		A.addState(4, S4, false, true);
		A.addState(5, S5);
		A.addState(6, S6);
		A.addState(7, S7);
		//
		A.addTransition(0, 1, new Transition());
		A.addTransition(1, 7, new Transition());
		A.addTransition(7, 2, new Transition());
		A.addTransition(1, 2, new Transition(2));
		A.addTransition(2, 3, new Transition(3));
		A.addTransition(3, 4, new Transition());
		A.addTransition(2, 5, new Transition(4));
		A.addTransition(6, 4, new Transition(2));
		
		//
		A.verifyReady();
		
		//
		A.initialize();
		System.out.println("test - iCurrentState = "+A.getICurrentState());
		while (!A.hasEnded()) {
			A.tick();
			System.out.println("test - iCurrentState = "+A.getICurrentState());
		}
		
	}

}
