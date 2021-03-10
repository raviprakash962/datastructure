package queue;

public class QueueByArrayMain {
	
	public static void main(String args[])
	{
		QueueByArray queue= new QueueByArray(6);
		
		System.out.println(" Checking queue is empty : "+queue.isQueueEmpty());
		queue.enQueue(10);
		System.out.println(" Checking queue is full:  "+queue.isQueueFull());
		
		queue.printQueue();
		
		queue.deQueue();
		
		//queue.printQueue();
		
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		queue.enQueue(70);
		queue.enQueue(80);
		
		queue.printQueue();
		queue.enQueue(90);
		
		
		 
	}

}
