package linkedlist;

import node.SingleNode;

public class SingleCircularLinkedList {

	private SingleNode head;
	private SingleNode tail;

	private int size;

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
	public boolean exitLinkedList()
	{
		return head!=null;
	}
	public void insert(int value, int position)
	{
		SingleNode node= new SingleNode();
		node.setValue(value);
		System.out.println("inserting new Node at Location "+position);
		if(!exitLinkedList())
		{
			System.out.println(" LinkedLIst does not exists ");
			return;
		}else if(position ==0)
		{
			node.setNext(head);
			head=node;
			tail.setNext(node);
		}else if(position >=getSize())
		{
			tail.setNext(node);
			tail=node;
			tail.setNext(head);// circular Linked List need to point head.
		}else
		{
			SingleNode temp= head;
			int index=0;
			while(index<position-1)
			{
				temp=temp.getNext();
				index++;
			}
			node.setNext(temp.getNext());
			temp.setNext(node);
		}
		size++;
	}

	//traverse 
	public void traverse()
	{
		if(exitLinkedList())
		{ 
			SingleNode temp =head;
			System.out.println("printing linkedlist");
			for(int i=0;i<size;i++)
			{
				System.out.print(temp.getValue());
				if(i!=size-1)
				{
					System.out.print("->");
				}
				temp=temp.getNext();
			}
			System.out.println("\n");
		}
		else
		{
			System.out.println(" LinkedList does not exists !!!");
		}
	}

	public void delete()
	{
		System.out.println(" Dleting Linked List !!");
		head=null;
		if(tail==null)
		{
			System.out.println(" Linked List lready deleted , nothing to delete ");
			return;
		}else
		{
			tail.setNext(null);
			tail=null;
			System.out.println(" LinkedlIst deleted Successfully");
		}
	}

	public boolean search(int value)
	{
		if(exitLinkedList())	
		{
			SingleNode temp=head;
			for(int i=0;i<size;i++)
			{
				if(temp.getValue()==value)
				{
					System.out.println(value+ " found at postion "+ i);
					return true;
				}
				temp= temp.getNext();
			}

		}
		System.out.println(" Not Found !!!");
		return false;
	}

public void deleteNode(int position)
{
	if(!exitLinkedList())
	{
		System.out.println(" Linkedlist does not avilable.");
	}
	else if(position==0)
	{
		head= head.getNext();
		tail.setNext(head);
		setSize(getSize()-1);
		if(getSize()==0)
		{
			tail=null;
		}
	}
	else if(position >=getSize())
	{
		SingleNode temp= head;
		for(int i=0;i<size;i++)
		{
			temp= temp.getNext();
		}
		if(temp==head)
		{
			tail=head=null;
			setSize(getSize()-1);
			return ;
		}
		temp.setNext(head);
		tail=temp;
		setSize(getSize()-1);
	}else
	{
		SingleNode temp=head;
		for(int i=0;i<position-1;i++)
		{
			temp=temp.getNext();
		}
		temp.setNext(temp.getNext().getNext());
		setSize(getSize()-1); 
	}
}
}
