package queue;

public class QueueByArray {
 private int arr[];
 private int topOfQueue;
 private int beginOfQueue;
 
 public QueueByArray(int size)
 {
	this.arr= new int[size];
	 this.topOfQueue=-1;
	 this.beginOfQueue=-1;
	 System.out.println(" Empty Queue created with size "+size);
 }
 
 public boolean isQueueFull()
 {
	 return topOfQueue==arr.length-1?true:false;
 }
 
 public boolean isQueueEmpty()
 {
	return topOfQueue==-1?true:false;
 }
 
 public int peek()
 {
	 if(!isQueueEmpty())
	 {
		 return arr[beginOfQueue];
	 }
	 return Integer.MIN_VALUE;
 }
 
 public void delete()
 {
	 arr=null;
	 System.out.println("Queue Deleted Successfully!!!");
 }
 
 public void enQueue(int value)
 {
	 if(isQueueFull())
	 {
		 throw new RuntimeException("Queue OverFlow error!!");
	 }else if(isQueueEmpty())
	 {
		 //first Time entry if queue is empty then we have to initiate the begin index.
		 beginOfQueue=0;
		 topOfQueue++;
		 arr[topOfQueue]=value;
		 System.out.println( value+" inserted SuccessFully in queue ");
	 }else {
		 //if queue is not empty and we adding the value .
		 topOfQueue++;
		 arr[topOfQueue]=value;
		 System.out.println(value+" inserted successfully in queue");
	 }
 }
 
 public void deQueue()
 {
	 if(isQueueEmpty())
	 {
		 throw new RuntimeException(" Queue is empty !!");
	 }
	 else {
		 System.out.println(" Dequeing the value from Queue"+ arr[beginOfQueue]);
		 arr[beginOfQueue]=Integer.MIN_VALUE;
		 beginOfQueue++;
		 if(beginOfQueue> topOfQueue) {
			 // if last element are removed and then only this condition satisfy and we initilize the value with -1;
			 beginOfQueue=topOfQueue=-1;
		 }
	 }
 }
 
 public void printQueue()
 {
	 if(isQueueEmpty())
	 {
		 throw new RuntimeException(" Queue is empty !!!");
	 }
	 else
	 {
		 for( int i=beginOfQueue;i<=topOfQueue;i++)
		 {
			 System.out.print(arr[i]);
			 if(i!=topOfQueue)
			 {
				 System.out.print(" ");
			 }
		 }
		 System.out.println("\n");
	 }
 }
}
