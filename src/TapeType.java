import java.util.Stack;

public class TapeType {
	//***************
	private Stack<Character> stackLeft= new Stack<Character>(), stackRight = new Stack<Character>();
	
	TapeType(String inputStr) {
		for(int i=inputStr.length()-1; i>=0; i--)
			stackRight.push(inputStr.charAt(i));
	}
	
	public char headRead() {
		if(stackRight.empty())
			return ' ';
		return stackRight.peek();
	}
	
	public void headWriteMove(char write, boolean moveRight) {
		if(moveRight)
			headWriteMoveR(write);
		else
			headWriteMoveL(write);
	}
	
	private void headWriteMoveR(char write) {
		pop(stackRight);
		stackLeft.push(write);
	}
	
	private void headWriteMoveL(char write) {
		pop(stackRight);
		stackRight.push(write);
		stackRight.push(pop(stackLeft));
	}
	
	private char pop(Stack<Character> stack) {
		if(stack.empty())
			return ' ';
		return stack.pop();
	}
	//***************
}