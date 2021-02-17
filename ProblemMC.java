package Ex2;

public class ProblemMC extends Problem {
	
	public ProblemMC() {
		int[] left = {0, 0};
		int[] boat = {0, 0};
		boolean boatSide = false;
		int[] right = {3, 3};
		super.goal = new State(left, boat, right, boatSide);
		
	}
	
	public boolean isRight(State state) {
		if(state.left[0] > 3 || state.left[1] > 3 || state.left[0] < 0 || state.left[1] < 0 || state.right[0] > 3 || state.right[1] > 3 
				|| state.right[0] < 0 || state.right[1] < 0) {
			return false;
		} //if more cannibals than missionaries on one side
		else if(state.left[0] < state.left[1] || state.right[0] < state.right[1]) {
			return false;
		}//if more  or less than 0 or 1 missionary/cannibal are on the boat
		else if ((state.boat[0] < 0 && state.boat[0] > 2) || (state.boat[1] < 0 && state.boat[1] > 2) || (state.boat[0] + state.boat[1] > 2)) {
			return false;
		}
		else {
			return true;
		}
	}
}
