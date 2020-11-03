
public interface Queue {
	public int size();// return the number of items currently in the queue.
	public int front();// return the item at the head of the queue, but don't remove it
	                     // from the queue.
	
	public void enqueue(int item);// insert the new item into the tail of the queue.
	public int dequeue();// return and remove the item at the head of queue. 
	

}
