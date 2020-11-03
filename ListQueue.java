//import org.w3c.dom.Node;

public class ListQueue implements Queue {
	protected Node head; // pointing to the head of the list.
	protected Node tail; // pointing to the tail of the list.
	protected int size; // the numbers of the item in the list.
	
	public ListQueue() {
		head = null;
		tail = null;
		size = 0;
		
	}
	
	public int size() {
		return size;
		
	}
	
	public int front() {
		if(size == 0)
			return -1;
		return head.getElement();
	}
	
	public void enqueue(int item) {
		if(item < 0)
			return;
		Node newNode = new Node(item, null);
		
		if(size == 0) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.setNext(newNode);
			tail = newNode;
		}
		size ++;
	}
	
	public int dequeue() {
		if(size == 0)
			return -1;
		
		int ret = head.getElement();
		
		if(size == 1) {
			head = null;
			tail = null;
		}
		else {
			Node oldHead = head;
			head = head.getNext();
			oldHead.setNext(null);
		}
		size --;
		return ret;
	}
	

}
