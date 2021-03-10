package linkedlist;

import node.DoubleNode;

public class DoubleCircularLinkedList {
	private DoubleNode head;
	private DoubleNode tail;
	
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
public DoubleNode getHead() {
		return head;
	}

	public void setHead(DoubleNode head) {
		this.head = head;
	}

	public DoubleNode getTail() {
		return tail;
	}

	public void setTail(DoubleNode tail) {
		this.tail = tail;
	}

public DoubleNode createLinkedList(int value)
{
	head= new DoubleNode();
	 DoubleNode node= new DoubleNode();
	 node.setValue(value);
	 node.setNext(node);
	 node.setPrev(node);
	 head= node;
	 tail=node;
	 size=1;
	 return head;
}
public boolean existDoubleLinkedlist()
{
	return head!=null;
}
public void insert(int value, int location) {
	DoubleNode node= new DoubleNode();
	node.setValue(value);
	if(!existDoubleLinkedlist())
	{
		System.out.println(" Linked List does not exists!!!");
		return;
	}
	else if(location==0)
	{
		node.setNext(head);
		node.setPrev(tail);
		head.setPrev(node);
		tail.setNext(node);
		head= node;
	}else if(location >=size)
	{
		node.setNext(head);
		node.setPrev(tail);
		head.setPrev(node);
		tail.setNext(node);
		tail=node;
	}else {
		DoubleNode temp= head;
		for(int i=0;i<location-1;i++)
		{
			temp= temp.getNext();
		}
		node.setPrev(temp);
		node.setNext(temp.getNext());
		temp.setNext(node);
		node.getNext().setPrev(node);
		
	}
	size++;
	
}

//traverse Linkedlist
public void traverseLinkedList()
{
	if(existDoubleLinkedlist())
	{
		DoubleNode temp= head;
		for(int i=0;i<size;i++)
		{
			System.out.print(temp.getValue());
			if(i!=size-1) {
				System.out.print("->");
			}
			temp= temp.getNext();
		}
		System.out.println("\n");
	}else {
		System.out.println(" LinkedList does not exit!!!");
	}
}

//traverse in reverse order
public void traverseReverseOrder()
{
	if(existDoubleLinkedlist())
	{
		DoubleNode temp= tail;
		for(int i=0;i<size;i++)
		{
			System.out.print(temp.getValue());
			if(i!=size-1)
			{
				System.out.print("->");
			}
			temp=temp.getPrev();
		}
		System.out.println("\n");
	}else
	{
		System.out.println(" Linked List does not exists");
	}
}

//Delete of node

public void deleteNode(int location)
{
	if(!existDoubleLinkedlist())
	{
		System.out.println("Linked List does not exists !!!!");
		return;
	}
	else if(location==0)
	{
		if(getSize()==1)
		{
			head.setNext(null);
			head.setPrev(null);
			head=tail=null;
			setSize(getSize()-1);
			return;
		}else
		{
			head=head.getNext();
			head.setPrev(null);
			tail.setNext(head);
			setSize(getSize()-1);
		}
	}
	else if(location>=size)
	{
		if(getSize()==1)
		{
			head.setNext(null);
			head.setPrev(null);
			head=tail=null;
			setSize(getSize()-1);
			return;
		}else {
			tail=tail.getPrev();
			tail.setNext(head);
			head.setPrev(tail);
			setSize(getSize()-1);
		}
	}else {
		DoubleNode temp=head;
		for(int i=0;i<location-1;i++)
		{
			temp=temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
		temp.getNext().setPrev(temp);
		setSize(getSize()-1);
	}
}

public void delete()
{
	if(existDoubleLinkedlist())
	{
		if(tail==null)
		{
			System.out.println(" LinkedList deleted ");
			return;
		}
		else
		{
			head.setPrev(null);
			head.setNext(null);
			head=tail=null;
			System.out.println(" Double Linked List deleted Successfully ");
		}
	}
}
}
