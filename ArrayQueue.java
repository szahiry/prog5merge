
public class ArrayQueue implements Queue {
	protected int capacity;// it is the array capacity.
	public static final int CAPACITY = 1000;// The default array capacity.
	
	public int[]Q;// The current array holds the queue
	protected int head; //the array index that point to the head item.
	protected int tail; // the array index that point to the tail item.
	
	protected int size; // the number of item in the queue.
	
	public ArrayQueue() {
		capacity = CAPACITY;
		Q = new int[capacity];
		head = -1;
		tail = -1;
		size = 0;
		
	}
	
	public ArrayQueue(int capacity) {
		if(capacity <= 0)
			return;
		this.capacity = capacity;
		Q = new int [capacity];
		head = -1;
		tail = -1;
		size = 0;
		
	}
	
	public int size() {
		return size;
	}
	
	public void enqueue(int item) {
		if(size == capacity)
			return;
		if(size == 0) {
		Q[0] = item;
		head = 0;
		tail = 0;
		
		}
		else {
			tail = (tail + 1) % capacity;
			Q[tail] = item;
		}
		size ++;
	}
	
	public int dequeue() {
		if(size == 0)
			return -1;
		int ret = Q[head];
		Q[head] = 0;
		
		if(size == 1) {
			head = -1;
			tail = -1;
		}
		else
			head = (head + 1) % capacity;
		
		size --;
		return ret;
	}

	@Override
	public int front() {
		if(size == 0)
			return -1;
		return Q[head];
	}


	
	
	
	
}

