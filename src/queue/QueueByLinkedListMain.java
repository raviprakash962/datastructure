package queue;

public class QueueByLinkedListMain {
	
	public static void main(String args[])
	{
		QueueByLinkedlist queue= new QueueByLinkedlist();
		
		System.out.println(queue.isQueueEmpty());
		
		queue.printQueue();
		
		queue.enQueue(10);
		queue.enQueue(20);
		queue.enQueue(30);
		
		queue.printQueue();
		System.out.println(queue.peek());
		System.out.println(queue.deQueue());
		queue.printQueue();
		
		
	}

}
