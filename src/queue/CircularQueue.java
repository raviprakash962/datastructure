package queue;

import java.util.NoSuchElementException;

public class CircularQueue{
	
	 private int arr[];
	 private int topOfQueue;
	 private int size;
	 private int start;
	 
	 public CircularQueue(int size)
	 {
		 this.arr= new int[size];
		 this.size=size;
		 this.topOfQueue=-1;
		 start=-1;
		 System.out.println("Empty Queue of size "+ size +" created successfully !");
	 }
	 
	 public void enQueue(int value)
	 {
		 if(arr==null)
		 {
			 System.out.println(" Queue is not creted yet , Please craete a queue first");
			 return;
		 }else if(isQueueFull())
		 {
			 System.out.println(" \n Queue OverFlow error!!");
			 return;
			 
		 }else {
			 initializeStartOfArray();
			 if(topOfQueue+1==size)
			 {
				 //if top is already at last cell of array , then need to initaite it to first cell.
				 topOfQueue=0;
			 }else {
				 topOfQueue++;
			 }
			 arr[topOfQueue]=value;
			 System.out.println(" \n Successfully inserted value"+ value + " in queue.");
		 }
	 }

	 public void deQueue()
	 {
		 if(isEmpty())
		 {
			 System.out.println(" Queue is empty, UnderFlow error ");
			 return;
		 }
		 System.out.println(" Deleting from queue "+ arr[start]);
		 arr[start]=Integer.MIN_VALUE;
		 if(start==topOfQueue)
		 {
			 //only one element in queue 
			 start= topOfQueue=-1;
			 
		 }else if(start+1==size)
		 {
			 start=0;
			 
		 }else { 
		 start++;
		 } 
	 }
	public boolean isQueueFull() {
		if(topOfQueue+1==start) {
			return true;
		}
		else if((start==0) && (topOfQueue+1==size))
		{
			return true;
				}
			return false;	
	}
	
	public boolean isEmpty()
	{
		if(topOfQueue==-1)
		{
			return true;
		}
		return false;
		
	}

	private void initializeStartOfArray() {
		if(start==-1)
		{
			start=0;
		}
		
	}
	
	public int peek()
	{
		if(isEmpty())
		{
			System.out.println(" Queue is empty!!!");
			return Integer.MIN_VALUE;
		}
		return arr[start];
	}
	
	public void delete()
	{
		System.out.println(" Deleting the queue !!!");
		arr=  null;
		
	}

	public void print()
	{
		System.out.println("\nQueue ");
		for(int i=0;i<size;i++)
		{
			System.out.println(arr[i]+" ");
		}
		System.out.println("\n start "+ start);
		System.out.println("\n End "+topOfQueue);
	}
	
	public int remove()
	{
			  int value=peek();
			  arr[start]=Integer.MIN_VALUE;
			  if(start==topOfQueue)
				 {
					 //only one element in queue 
					 start= topOfQueue=-1;	 
				 }else if(start+1==size)
				 {
					 start=0;
					 
				 }else { 
				 start++;
				 }
			  if(value!=Integer.MIN_VALUE)
			  {
				  
			  return value;
			  }
			  else {
				  throw new NoSuchElementException();
		 }
	}
		 
		
}
