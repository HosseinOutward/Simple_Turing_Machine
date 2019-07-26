public class TuringMachine {
	//***************
	
	//***************

	public static void main(String[] args) {
		//***************
		MachineProcesses Machine = MachinesLibrary.Load();
		if (Machine.run())
			System.out.println("The input was Accepted.");
		else
			System.out.println("The input was Rejected.");
		//***************
	}
}
