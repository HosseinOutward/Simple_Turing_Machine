import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MachineProcesses {
	public Set<String> finalState = new HashSet<String>();
	public String initialState;
	public TransitionMap transFunc = new TransitionMap();
	

	public boolean run() {
		TapeType tape = new TapeType(getInput());
		return acceptor(initialState, tape);
	}
	
	public boolean acceptor(String currState, TapeType tape) {
		if(finalState.contains(currState))
			return true;
		int index = 0;
		while(transFunc.hasNext(index, currState, tape.headRead())) {
			dataSet tempSet = transFunc.getNData(index, currState, tape.headRead());
			if(acceptor(tempSet.getNState(), transTape(tape, tempSet.getNWrite(), tempSet.getNMove())))
				return true;
			index++;
		}
		return false;
	}
	
	public TapeType transTape(TapeType tape, char write, boolean moveRight) {
		tape.headWriteMove(write, moveRight);
		return tape;
	}
	
	private static String getInput() {
		@SuppressWarnings("resource")
		Scanner scan= new Scanner(System.in);
		System.out.println("Input the String:");
		return scan.nextLine();
	}
}
