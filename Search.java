package Ex2;

public class Search {
	Node root;
	Problem problem;
	int counter;
	
	public Search() {}
	//store the root node and the problem
	public Search(Node root, Problem p) {
		this.root = root;
		this.problem = p;
		this.counter = root.id + 1;
	}
	//create a childnode
	public Node childNode(Node parent, State s) {
		Node newNode = new Node(counter, s);
		//this is the id
		counter++;
		//set state and connect to parent
		newNode.state = s;
		newNode.parent = parent;
		return newNode;
	}
}
