package Ex2;
import java.util.ArrayList;
public class Action {
	Node node;
	ArrayList<State> list;
	
	public Action(Node n) {
		this.node = n;
	}
	//a function that calls a function depending on whichh side the boat is ( true = left, false = right )
	public ArrayList<State> getAction(Problem p) {
		if(node.state.boatSide) {
			potActionsLeft(p);
			return list;
			
		}else if(!node.state.boatSide){
			potActionsRight(p);
			return list;
		}else {
			return null;
		}
	}
	
	//create the list of all possible actions on the left side
	public void potActionsLeft(Problem p) {
		list = new ArrayList<State>();
		State copy = copyState(node.state);
		//if someones on the boat unload the boat first
		if(copy.boat[0] == 1 && copy.boat[1] == 0) {
			copy.boat[0]--;
			copy.left[0]++;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}		
		}
		if(copy.boat[0] == 1 && copy.boat[1] == 1) {
			copy.boat[0]--;
			copy.left[0]++;
			copy.boat[1]--;
			copy.left[1]++;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}
		}
		if(copy.boat[0] == 2 && copy.boat[1] == 0) {
			copy.boat[0] -= 2;
			copy.left[0] += 2;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}	
			
		}

		if(copy.boat[0] == 0 && copy.boat[1] == 1) {
			copy.boat[1]--;
			copy.left[1]++;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}
		}
		if(copy.boat[0] == 0 && copy.boat[1] == 2) {
			copy.boat[1] -= 2;
			copy.left[1] += 2;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}
			
		}
		//load the boat (1,0 ; 1,1; 0,1; 0,2; 2,0)
		copy.left[0]--;
		copy.boat[0]++;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.left[1]--;
		copy.boat[1]++;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.left[0]++;
		copy.boat[0]--;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.left[1]--;
		copy.boat[1]++;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.left[1] += 2;
		copy.boat[1] -= 2;
		copy.left[0] -= 2;
		copy.boat[0] += 2;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		
	}
	//same with the right side
	public void potActionsRight(Problem p){
		list = new ArrayList<State>();
		State copy = copyState(node.state);
		//if someones on the boat
		if(copy.boat[0] == 1 && copy.boat[1] == 0) {
			copy.boat[0]--;
			copy.right[0]++;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}
		}
		if(copy.boat[0] == 1 && copy.boat[1] == 1) {
			copy.boat[0]--;
			copy.right[0]++;
			copy.boat[1]--;
			copy.right[1]++;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}		
		}
		if(copy.boat[0] == 2 && copy.boat[1] == 0) {
			copy.boat[0] -= 2;
			copy.right[0] += 2;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}		
			
		}if(copy.boat[0] == 0 && copy.boat[1] == 1) {
			copy.boat[1]--;
			copy.right[1]++;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}
		}
		if(copy.boat[0] == 0 && copy.boat[1] == 2) {
			copy.boat[1] -= 2;
			copy.right[1] += 2;
			if(p.isRightMC(copy)) {
				list.add(new State(copy.left, copy.boat, copy.right, copy.boatSide));
			}		}
		copy.right[0]--;
		copy.boat[0]++;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.right[1]--;
		copy.boat[1]++;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.right[0]++;
		copy.boat[0]--;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.right[1]--;
		copy.boat[1]++;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
		copy.right[1] += 2;
		copy.boat[1] -= 2;
		copy.right[0] -= 2;
		copy.boat[0] += 2;
		if(p.isRightMC(copy)) {
			list.add(new State(copy.left, copy.boat, copy.right, !copy.boatSide));
		}
	}
	//check if the list has illegal states (i think i dont need this anymore but im not sure and its getting kinda late now )
	//so i dont really want to delete right now
	public void checkList(ArrayList<State> s, Problem p) {
		for(int i = 0; i < s.size(); i++) {
			if(!p.isRightMC(s.get(i))) {
				s.remove(i);
				i = 0;
			}
		}
	}
	//create a copy of a node
	public Node copyNode(Node n) {
			return new NodeMC(n.id + 1, n.state);
	}
	//create a copy of a state
	public State copyState(State s) {
		return new State(node.state.left, node.state.boat, node.state.right, node.state.boatSide);
		
	}
}
