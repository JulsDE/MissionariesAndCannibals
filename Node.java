package Ex2;
import java.util.ArrayList;

public class Node {
	//Node hold an id, a state, a reference to parent node and a list of his children
	int id;
	State state;
	Node parent;
	ArrayList<Node> children;
	
	public Node() {
		
	}
	public Node(int id) {
		this.id = id;
		children = new ArrayList<Node>();
	}
	public Node(int id, State s) {
		this.id = id;
		this.state = s;
		children = new ArrayList<Node>();
	}
	//getter and setter
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	public void setParent(Node n) {
		this.parent = n;
	}
	public Node getParent() {
		return this.parent;
	}
	
	@Override
	public String toString() {
		return "\nId: " + id + state ;
	}
	
}

