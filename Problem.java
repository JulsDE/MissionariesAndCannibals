package Ex2;

public class Problem {
	State goal; 
	
	//set the goal state for the canni/missionary problem
	public void setGoalMC() {
		int[] left = {0, 0};
		int[] boat = {0, 0};
		boolean boatSide = false;
		int[] right = {3, 3};
		goal = new State(left, boat, right, boatSide);
	}
	
	// a method to check if the state is legal
	public boolean isRightMC(State state) {
		//if more  or less than 0 or 1 missionary/cannibal are on the boat
		if(state.left[0] > 0 && state.right[0] > 0) {
			if(state.left[0] <= 3 && state.left[0] >= 0 && state.left[1] <= 3 && state.left[1] >= 0 && state.right[0] <= 3 && state.right[0] >= 0 &&
					state.boat[0] >= 0 && state.boat[0] <= 2 && state.boat[1] >= 0 && state.boat[1] <= 2 && state.boat[0] + state.boat[1] <= 2 &&
					state.right[1] <= 3 && state.right[1] >= 0 && state.left[0] >= state.left[1] && state.right[0] >= state.right[1]) {
				return true;
			}
			else {
				return false;
			}
		}
		//ifright bank has zero missionaries
		else if(state.left[0] > 0 && state.right[0] == 0){
			if(state.left[0] <= 3 && state.left[0] >= 0 && state.left[1] <= 3 && state.left[1] >= 0 && state.right[0] <= 3 && state.right[0] >= 0 &&
					state.boat[0] >= 0 && state.boat[0] <= 2 && state.boat[1] >= 0 && state.boat[1] <= 2 && state.boat[0] + state.boat[1] <= 2 &&
					state.right[1] <= 3 && state.right[1] >= 0 && state.left[0] >= state.left[1]) {
				return true;
			}else {
				return false;
			}
			//if left bank has 0 missionaries
		}else if(state.left[0] == 0 || state.right[0] > 0) {
			if(state.left[0] <= 3 && state.left[0] >= 0 && state.left[1] <= 3 && state.left[1] >= 0 && state.right[0] <= 3 && state.right[0] >= 0 &&
					state.boat[0] >= 0 && state.boat[0] <= 2 && state.boat[1] >= 0 && state.boat[1] <= 2 && state.boat[0] + state.boat[1] <= 2 &&
					state.right[1] <= 3 && state.right[1] >= 0 && state.right[0] >= state.right[1]) {
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}

}
