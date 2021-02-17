package Ex2;

public class State {
	int[] left;
	int[] boat;
	boolean boatSide;
	int[] right;
	
	public State(int[] left, int[] boat, int[] right , boolean boatSide) {
		//define the state
			this.left = new int[2];
			this.left[0] = left[0];
			this.left[1] = left[1];
			this.boat = new int[2];
			this.boat[0] = boat[0];
			this.boat[1] = boat[1];
			this.right = new int[2];
			this.right[0] = right[0];
			this.right[1] = right[1];
			this.boatSide = boatSide;
		

	}
	

	
	public String toString() {
		String result = "";
		if(boatSide) {
			result = "\nState left bank: " + this.left[0] + " , " + this.left[1] + "\nState Boat: " + this.boat[0] + " , " + this.boat[1] + 
					"\nSide of boat: Left" + "\nState right bank: " + this.right[0] + " , " + this.right[1];
		}else {
			result = "\nState left bank: " + this.left[0] + " , " + this.left[1] + "\nState Boat: " + this.boat[0] + " , " + this.boat[1] + 
					"\nSide of boat: Right" + "\nState right bank: " + this.right[0] + " , " + this.right[1];
		}
		return result;
	}
}
@SuppressWarnings("serial")
class NodeFormatException extends Exception{
	
	NodeFormatException(){
		super("no valid input");
	}
	
	NodeFormatException(String s){
		super(s);
	}
}
