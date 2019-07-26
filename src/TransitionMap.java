import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TransitionMap {
	private Map<String, HashMap<Character, ArrayList<dataSet>>> transFunc = new HashMap<String, HashMap<Character, ArrayList<dataSet>>>();
	
	public void addTransition(String currState, char read, String nextStat, char write, boolean moveRight) {
		if(!transFunc.containsKey(currState)) {
			transFunc.put(currState, ((new HashMap<Character, ArrayList<dataSet>>())));
			transFunc.get(currState).put(read, (new ArrayList<dataSet>()));
			transFunc.get(currState).get(read).add((new dataSet(nextStat, write, moveRight)));
		}
		else if(!transFunc.get(currState).containsKey(read)) {
			transFunc.get(currState).put(read, (new ArrayList<dataSet>()));
			transFunc.get(currState).get(read).add((new dataSet(nextStat, write, moveRight)));
		}
		else
			transFunc.get(currState).get(read).add((new dataSet(nextStat, write, moveRight)));
	}
	
	public boolean hasNext(int index, String currStat, char read) {
		if(transFunc.containsKey(currStat) && transFunc.get(currStat).containsKey(read) 
				&& index<transFunc.get(currStat).get(read).size())
			return true;
		return false;
	}
	
	public dataSet getNData(int index, String currState, char read) {
		return transFunc.get(currState).get(read).get(index);
	}
}

class dataSet {  
    private String nextStat;
    private char write;
    private boolean moveRight;
    dataSet(String nextStat2, char write2, boolean moveRight2) {
        this.nextStat=nextStat2;
        this.write=write2;
        this.moveRight=moveRight2;
    }
    public String getNState() { return nextStat; }
    public char getNWrite() { return write; }
    public boolean getNMove() { return moveRight; }
}