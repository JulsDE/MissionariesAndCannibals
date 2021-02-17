package Ex2;
import java.util.ArrayList;
public class SearchBDF extends Search {
	ArrayList<Node> queue;
	ArrayList<State> checkRedundancy;

	//store all the stuff and create the lists 
	public SearchBDF(Node root, Problem p) {
		super.root = root;
		super.problem = p;
		super.counter = root.id + 1;
		queue = new ArrayList<Node>();
		queue.add(root);
		checkRedundancy = new ArrayList<State>();
		checkRedundancy.add(root.state);
	}
	
	public Node search(Node node) {
		//check if the first node might be right
		if(node.state.left[0] == super.problem.goal.left[0] && node.state.left[1] == super.problem.goal.left[1] && 
				node.state.boat[0] == super.problem.goal.boat[0] && node.state.boat[1] == super.problem.goal.boat[1] &&
				node.state.right[0] == super.problem.goal.right[0] && node.state.right[1] == super.problem.goal.right[1] && 
				node.state.boatSide == super.problem.goal.boatSide) {
			return node;
		}
		else {
			//look which actions are possible and create a child node with every state and prepare a exit (node.id < 200) 
			//to avoid Stack Overflow
			if(node.id < 200) {
				Action a = new Action(node);
				a.getAction(super.problem);
				int counter = 0;
				for(int i = 0; i < a.list.size(); i++) {
					//check if the state is alreay existent and if yes, dont use it
					if(checkRedu(a.list.get(i)) == false) {
						//create children for the node and put them into the queue
						node.children.add(super.childNode(node, a.list.get(i)));
						queue.add(node.children.get(counter));
						counter++;
						//add the state to the redundancy list
						checkRedundancy.add(a.list.get(i));
					}
				}
				//remove the first entry of the list and call this function again with the new head of the queue
				queue.remove(0);
				Node fin = search(queue.get(0));
				return fin;
			}
			else {
				return null;
			}
		}
	}
	//check the given state if its already in the redundancy list
	public boolean checkRedu(State s) {
		for(int i = 0; i < checkRedundancy.size(); i++) {
			if(s.left[0] == checkRedundancy.get(i).left[0] && s.left[1] == checkRedundancy.get(i).left[1] && 
					s.boat[0] == checkRedundancy.get(i).boat[0] && s.boat[1] == checkRedundancy.get(i).boat[1] && 
					s.right[0] == checkRedundancy.get(i).right[0] && s.right[1] == checkRedundancy.get(i).right[1]
					&& s.boatSide == checkRedundancy.get(i).boatSide) {
				return true;
			}
			
		}
		return false;
	}
}
