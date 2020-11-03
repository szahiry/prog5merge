public class Node {
	
		private int element;// you can add any other fields that you need to save in a node.
		
		private Node next;// referencing to the next node in the link list
		
		public Node(int element, Node next) { // Constructor 
			this.element = element;
			this.next = next;
		}
		
		public int getElement() {
			return element;
		}
		
		public Node getNext() {
			return next;
		}
		public void setElement(int element) {
			this.element = element;
		}
		public void setNext(Node next) {
			this.next = next;
		}

}
