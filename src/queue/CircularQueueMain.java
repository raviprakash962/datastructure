package queue;

public class CircularQueueMain {
	
	public static void main(String args[])
	{
		CircularQueue queue= new CircularQueue(6);
		queue.enQueue(10);
		
		queue.enQueue(20);
		queue.enQueue(30);
		queue.enQueue(40);
		queue.enQueue(50);
		queue.enQueue(60);
		
		queue.deQueue();
		queue.deQueue();
		
		queue.enQueue(70);
		queue.deQueue();
		
		 int value= queue.remove();
		System.out.println(" remove() method called , deleted value : "+ value);
		int value1= queue.remove();
		System.out.println(" remove() method called , deleted value : "+ value1);
		int value2= queue.remove();
		System.out.println(" remove() method called , deleted value : "+ value2);
		int value3= queue.remove();
		System.out.println(" remove() method called , deleted value : "+ value3);
		int value4= queue.remove();
		System.out.println(" remove() method called , deleted value : "+ value4);
	}

}
