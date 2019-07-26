public class MachinesLibrary {
	public static  MachineProcesses Load() {
		MachineProcesses TempTM = new MachineProcesses();
		
		//*****************
		String[] tempFinalState = {"q3"};
		TempTM.initialState = "q0";
		//Transition function example:  f(q0, r) = (q1, w, R) --> TempTM.addTransition(q0, r, q1, w, true)
		//true is for right
		TempTM.transFunc.addTransition("q0", '0', "q1", ' ', true);
		TempTM.transFunc.addTransition("q0", ' ', "q3", ' ', false);
		TempTM.transFunc.addTransition("q0", 'x', "q4", 'x', true);
		TempTM.transFunc.addTransition("q1", '0', "q1", '0', true);
		TempTM.transFunc.addTransition("q1", 'x', "q1", 'x', true);
		TempTM.transFunc.addTransition("q1", '1', "q2", 'x', false);
		TempTM.transFunc.addTransition("q2", '0', "q2", '0', false);
		TempTM.transFunc.addTransition("q2", 'x', "q2", 'x', false);
		TempTM.transFunc.addTransition("q2", ' ', "q0", ' ', true);
		TempTM.transFunc.addTransition("q4", 'x', "q4", 'x', true);
		TempTM.transFunc.addTransition("q4", ' ', "q3", ' ', false);
		//*****************
		
		for (int i=0; i<tempFinalState.length; i++)
			TempTM.finalState.add(tempFinalState[i]);
		return TempTM;
	}
}
