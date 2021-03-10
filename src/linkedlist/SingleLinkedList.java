package linkedlist;

import node.SingleNode;

public class SingleLinkedList {

	private SingleNode head;
	private SingleNode tail;
	
	// size of list
	private int size;
	
	public SingleNode createSingleLinkedList(int nodeValue)
	{
		head= new SingleNode();
		SingleNode node=new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head= node;
		tail =node;
		size=1;
		return head;
	}
	public boolean existsLinkedList()
	{// if head is not null then return true else return false
		return head!=null;
	}
	
	public void insertIntoLinkedList(int nodeValue, int location)
	{
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if(!existsLinkedList())
		{
			System.out.print(" The linkedList does not  exists!!");
			return;
		}
		else if(location ==0)
		{
			// insert at first position 
			node.setNext(head);
			head= node;
		}
		else if( location >= size) {
			//insert at last position
			node.setNext(null);
			tail.setNext(node);
			tail=node;
		}
		else {
			//insert at specific position 
			SingleNode temp= head;
			int index=0;
			while(index<location-1)
			{
				temp=temp.getNext();
				index++;
			}
			 // tempNode contain the node after which we have to insert the new node;
			//nextNodeReference is the reference of next node so that we can merge later otherwise we will lost the linkedlist.
			SingleNode nextNodeReference= temp.getNext();
			temp.setNext(node);
			node.setNext(nextNodeReference);
			
		}
		setSize(getSize()+1);
	}
	
	// Traverse linkedList
	public void traverseLinkedList()
	{
		if(existsLinkedList())
		{
		 SingleNode tmp= head;
		 for(int i=0;i<getSize();i++)
		 {
			 System.out.print(tmp.getValue());
			 if(i!=getSize()-1)
			 {
				 System.out.print(" -> ");
			 }
			 tmp=tmp.getNext();
		 }
		}else
		{
			System.out.println("LinkedList does not exists.");
		}System.out.println("\n");
	}
	
	//Delete entire LinkedList
	public void deleteList()
	{
		System.out.println(" \n Deleting linked list ");
		head=null; tail =null;
		System.out.println(" linked list deleted successfully ");
	}
	
	//search a node in linkedList
	public boolean search(int nodeValue)
	{
		if(existsLinkedList())
		{
			SingleNode temp=head;
			for(int i=0;i<getSize();i++)
			{
				if(temp.getValue()== nodeValue)
				{
					System.out.println("found the Node at position "+ i);
					return true;
				}
				temp= temp.getNext();
			}
		}
			System.out.println(" not found !!!");
			return false;
		
	}
	
	//Delete a Node having the value
	public void deleteNode(int location)
	{
		if(!existsLinkedList())
		{
		   System.out.println(" LinkedList does not exists !");
		   return;
		}
		else if(location == 0)
		{
			head=head.getNext();
			setSize(getSize()-1);
			if(getSize()== 0)
			{
				tail=null;
			}
		}else if(location>=getSize()) {
			// if location is not in range or equal then delete the last node.
			SingleNode temp=head;
			for(int i=0;i<getSize()-1;i++)
			{
				temp= temp.getNext();
			}
			if(temp==head)
			{
				// if this is the only elements in the list.
				tail=head=null;
				setSize(getSize()-1);
				return;
			}
			temp.setNext(null);
			tail=temp;
			setSize(getSize()-1);
			
		}
		else
			//if any inside node be deleted 
		{
			SingleNode temp= head;
			for(int i=0;i<location-1;i++)
			{
				temp= temp.getNext();
			}
			temp.setNext(temp.getNext().getNext());
			setSize(getSize()-1);
		}
	}

	public SingleNode getHead() {
		return head;
	}

	public void setHead(SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return tail;
	}

	public void setTail(SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}
