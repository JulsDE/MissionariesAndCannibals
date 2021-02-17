package Ex2;
import java.util.ArrayList;
public class app {

	public static void main(String[] args) {
		//initial state
		
		int[] left = {3, 3};
		int[] boat = {0, 0};
		int[] right = {0, 0};
		State s = new State(left, boat, right, true);
		//root node with id 0 and initial state
		Node node = new Node(0, s);
		Problem p = new Problem();
		//set Problem for missionary cannibal problem
		p.setGoalMC();
		//create search
		SearchBDF search = new SearchBDF(node, p);
		//store the goal node into the fin variable
		Node fin = search.search(node);
		//get a String to print out the pathing
		Node tmp = fin;
		int pathcosts = 0;
		ArrayList<Node> path = new ArrayList<Node>();
		while(tmp.id != 0) {
			path.add(tmp);
			tmp = tmp.parent;
			pathcosts++;
		}
		path.add(tmp);
		pathcosts++;
		//print out the results
		System.out.println("Final Node: " + fin);
		System.out.println("\nPathcosts: " + pathcosts);
		System.out.println("Path: ");
		for(int i = path.size() - 1; i >= 0; i--) {
			System.out.println(path.get(i));
		}
		

		
		/*
		Action a = new Action(node);
		a.checkList(a.getAction(), p);
		System.out.println(node);
		System.out.println(a.list);
		*/
		
		
		
	}

}
/*
class MyList {
	class Node {
		int value;
		Node next;
	}
	
	Node head;
	
	public void add(int newValue) {
		Node newNode = new Node();
		newNode.value = newValue;
		newNode.next = head;
		head = newNode;
	}
	@Override
	public String toString() {
		Node tmp = head;
		String result = "[ ";
		while (tmp != null) {
			result += tmp.value + " - ";
			tmp = tmp.next;
		}
		result += " ]";
		return result;
	}
}*/