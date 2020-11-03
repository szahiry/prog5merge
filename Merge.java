import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Merge {
public static void main(String[] args) throws FileNotFoundException {
		
		ListQueue queue = new ListQueue();
		File ArrayFile[] = createFileArray(args);
		//String[] newFile = {"./data1.txt","data2.txt","data3.txt"};
		//File ArrayFile[] = createFileArray(newFile);
		checkQueue(ArrayFile);
		//System.out.println("just checking");
	}//end main class
public static File[] createFileArray(String[]args) {
	File[] Q = new File[args.length];
	for(int x = 0; x < args.length; x++){
		File file = new File(args[x]);
		Q[x] = file;
	}
	return Q;
}

public static void checkQueue(File ArrayFile[]) throws FileNotFoundException {
    
	ArrayQueue[] queue = new ArrayQueue[ArrayFile.length];
	for(int i = 0; i < ArrayFile.length; i++) {
		ArrayQueue F1 = new ArrayQueue(10);
		Scanner kb = new Scanner(ArrayFile[i]);
		
		int x = 0;
		while(kb.hasNext() && x < 10 ) {
			int y = Integer.parseInt(kb.nextLine());
			F1.enqueue(y);
			x++;
		}
		queue[i] = F1;
	}
	
	ListQueue queue1 = new ListQueue();
	boolean isNotEmpty = checkIfQueueEmpty(queue);
	
	while(isNotEmpty) {
		for(int i = 0; i < queue.length; i++) {
			int curNum = queue[i].front();
			
			ArrayQueue curQueue = queue[i];// keep the track of the current queue we are grabbing. (curQueue present Q).
			int smallestNum = curNum;// assuming this is the smallest number. (samllestNum present m).
			int index = 0;
			for(int j = i +1; j < queue.length; j++) {
				int nextNum = queue[j].front();
				if(nextNum < smallestNum) {
					smallestNum = nextNum;
					curQueue = queue[j];
					index = j;
					
				}
			}
			if(index != 0) {
				queue [index] = queue[i];
				queue[i] = curQueue;
			}
		}
		for(int x = 0; x < queue.length; x++) {
			while(queue[x].size > 0) {
				queue1.enqueue(queue[x].dequeue());
			}
			
		}
		
		isNotEmpty = checkIfQueueEmpty(queue);// last line of the while loop.
	}
	
	while(queue1.size > 0) {
		System.out.println(queue1.dequeue());
	}
	
	}
private static boolean checkIfQueueEmpty(ArrayQueue[] queue) {
	boolean notEmpty = false;
	for(int i = 0; i < queue.length; i++) {
		if(queue[i].size() > 0) {
			notEmpty = true;
		}
	}
	return notEmpty;
	}


}
