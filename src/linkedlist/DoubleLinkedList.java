package linkedlist;

import node.DoubleNode;

public class DoubleLinkedList {

	private int size;

	private DoubleNode head;
	private DoubleNode tail;

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}


	public DoubleNode createDoubleLinkedList(int value)
	{
		head= new DoubleNode();
		DoubleNode node= new DoubleNode();
		node.setValue(value);
		node.setNext(null);
		node.setPrev(null);
		head= node;
		tail=node;
		size=1;
		return head;
	}

	public boolean existDoubleLinkedList()
	{
		return head!=null;
	}


	public void insert(int location, int value)
	{
		DoubleNode node= new DoubleNode();
		node.setValue(value);
		if(!existDoubleLinkedList())
		{
			System.out.println(" LinkedList not exists!!!");
		}
		else if(location==0)
		{
			node.setNext(head);
			node.setPrev(null);
			head.setPrev(node);
			head=node;	
		}
		else if( location>=getSize())
		{
			node.setNext(null);
			tail.setNext(node);
			node.setPrev(tail);
			tail=node;

		}
		else {
			//insert at defined position 
			DoubleNode temp= head;
			int index=0;
			while(index<location-1)
			{
				temp= temp.getNext();
				index++;
			}
			node.setPrev(temp);
			node.setNext(temp.getNext());
			temp.setNext(node);
			node.getNext().setPrev(node);
		}
		setSize(getSize()+1);
	}

	//traverse the double linkedlist  from head to last 
	public void traverseForward()
	{
		if(!existDoubleLinkedList())
		{
			System.out.println(" Linked List does not exists !!!");
		}else
		{
			DoubleNode temp= head;
			for(int i=0;i<getSize();i++)
			{
				System.out.print(temp.getValue());
				if(i!=size-1)
				{
					System.out.print("->");
				}
				temp= temp.getNext();
			}
			System.out.println("\n");
		}

	}

	public void traverseReverseOrder()
	{
		if(existDoubleLinkedList())
		{
			DoubleNode temp=tail;
			for(int i=0;i<size;i++)
			{
				System.out.print(temp.getValue());
				if(i!=size-1)
				{
					System.out.print("->");
				}
				temp=temp.getPrev();
			}
		}else
		{
			System.out.println(" Linkedlist does Not exists !!!");
		}
		System.out.println("\n");
	}
	public void deleteLinkedList()
	{
		System.out.println("\n Deleting linkedList !! ");
		DoubleNode temp= head;
		for(int i=0;i<size;i++)
		{
			temp.setPrev(null);
			temp= temp.getNext();

		}
		head= null;
		tail=null;
		System.out.println(" LinkedList deleted Successfully  ");
	}
//search node
	public boolean search(int value)
	{
		if(existDoubleLinkedList())
		{
			DoubleNode temp= head;
			for(int i=0;i<size;i++)
			{
				if(temp.getValue()==value)
				{
					System.out.println(value+ "found at position "+ i);
					return true;
				}
				temp= temp.getNext();
			}
		}
		System.out.println(" Not Found !!!");
		return false;
	}
	
	//delete Node having agiven value 
	public void deleteNode(int position)
	{
		if(!existDoubleLinkedList())
		{
			System.out.println(" Linked List does not exists ");
		}
	
	else if( position==0)
	{
		if(getSize()==1)
		{
			head=tail=null;
			setSize(getSize()-1);
			return;
		}
		else {
			head= head.getNext();
		head.setPrev(null);
		setSize(getSize()-1);
		}
	}else if(position>=getSize())
	{
		DoubleNode temp= tail.getPrev();
		if(temp==head)
		{
			tail=head=null;
			setSize(getSize()-1);
			return;
		}
		temp.setNext(null);
		tail=temp;
		setSize(getSize()-1);
	}else
	{
		DoubleNode temp= head;
		int index=0;
		while(index< position-1)
		{
			temp=temp.getNext();
			index++;
		}
		temp.setNext(temp.getNext().getNext());
		temp.getNext().setPrev(temp);
		setSize(getSize()-1);
		
	}
	}
}
