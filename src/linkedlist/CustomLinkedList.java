package linkedlist;

public class CustomLinkedList<T> {

	private Node<T> head;
	
	public Node getHead()
	{
		 return this.head;
	}


	public void insert(T data)
	{
		Node<T> newNode= new Node<T>(data);
		if( head==null)
		{
			head= newNode;
			return;
		}else {
			Node current= head;
			while( current.getNext() !=  null)
			{
				current= current.getNext();
			}
			current.setNext(newNode); 
		}


	}
	public void insertAtStart (T data)
	{
		Node<T> newNode= new Node<T>(data);

		if( head== null)
		{
			head= newNode;
			return;
		}else {
			newNode.setNext(head);
			head= newNode;
		}

	}

	public void insertAtIndex(int index, T data) 
	{
		if(index < 0)
		{
			throw new RuntimeException("Invalid index");
		}else if( index==0)
		{
			insertAtStart(data);
		}
		else {
			Node newNode= new Node(data);
			Node current= head;
			for( int i=0; i< index-1; i++)
			{
				current = current.getNext();
			}
			newNode.setNext(current.getNext());
			current.setNext(newNode);
		}
	}

	public void deletFromIndex(int index)
	{
		if(index < 0 || head==null)
		{
			throw new RuntimeException("Invalid index");
		}
		else if( index==0)
		{
			head= head.getNext();
			return;
		}else {
			Node current = head;
			for(int i=0; i<index-1; i++)
			{
				current = current.getNext();
			}
			if( current.next.next== null) {
				current.setNext(null);
			}else {
				current.setNext(current.getNext().getNext());
			}


		}
	}
	
	public T get(int index)
	{
		int sizeOfList= size();
	  if(head== null)
	  {
		  throw new RuntimeException("LinkedList is Empty.");
	  }else if( index < 0  || index >= sizeOfList)
	  {
		  throw new RuntimeException(" Invalid Index.");
	  }
		  Node current = head;
		  for(int i=0; i< index && current!= null; i++)
		  {
			  current = current.getNext();
		  }
		  
	  return (T) current.getVal();
	}

	public void reverse()
	{
		if(head==null || head.getNext()==null)
		{
			return ;
		}
		else {
			Node previous= null;
			Node nextNode;
			Node current = head;
			while( current != null)
			{
				nextNode= current.getNext();
				current.setNext(previous);
				previous= current;
				current = nextNode;

			}
			head= previous;

		}

	}

	public Node getMiddleElement()
	{
		if( head==null || head.getNext()==null)
		{
			return head;
		}
		Node slow= head;
		Node fast= head;

		while(fast.getNext()!=null)
		{
			if( fast!= null && fast.getNext()!=null) {
				slow= slow.getNext();
				fast= fast.getNext().getNext();
			}
		}
		return slow;
	}

	public int size() {
		int counter=0;
		if( head==null)
		{
			return 0;
		}else {
			Node current = head;
			while( current!= null)
			{
				counter++;
				current= current.getNext();
			}
		}
		return counter;

	}

	public void showData()
	{
		Node current = head;
		if(current==null)
		{
			System.out.println(" list is empty !! ");
			return;
		}
		else {while(current!= null) {
			System.out.println(current.getVal()+"  ");
			current = current.getNext();
		}

		}
	}


	public static class Node<T>{
		private T val;
		private Node next;

		Node(T val)
		{
			this.val= val;
			this.next= null;
		}
		Node()
		{
			
		}

		public T getVal()
		{
			return this.val;
		}

		public Node getNext()
		{
			return this.next;
		}
		public void setNext(Node next)
		{
			this.next= next;

		}
		public void setVal(T val)
		{
			this.val= val;
		}
	}

}
