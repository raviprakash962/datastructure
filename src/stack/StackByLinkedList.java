package stack;

import java.util.LinkedList;
import java.util.List;

import linkedlist.SingleLinkedList;

public class StackByLinkedList {
	
	/*private LinkedList list;
	
	public StackByLinkedList()
	{
		list= new LinkedList();
	}
	
	public void push(int value)
	{
		list.add(value);
	}
	
	public int pop()
	{
		return (int)list.getLast();
	}
	
	public boolean isEmpty()
	{
		 return list.size()==0? true:false;
	}
	
	public int peek()
	{
		return (int) list.getLast();
	}
	*/
	
	SingleLinkedList list;
	
	public StackByLinkedList()
	{
		list= new SingleLinkedList();
	}
	
	public boolean isEmpty()
	{
		if(list.getHead()==null)
		{
			return true;
		}
		return false;
	}

	public void push(int value)
	{
		if(list.getHead()==null)
		{
			list.createSingleLinkedList(value);
		}else
			list.insertIntoLinkedList(value, 0);
	}
	
	public int pop()
	{
		int value=-0;
		if(isEmpty())
		{
			System.out.println("Stack uNder Flow");
		}
		else
		{
			value= list.getHead().getValue();
			list.deleteNode(0);
		}
		return value;
	}
	
	public int peek()
	{
		if(!isEmpty())
		{
			return list.getHead().getValue();
		}else
		{
			System.out.println(" Stack is empty !!!!");
		}
		return -1;
	}
	
	public void deleteStack()
	{
		list.deleteList();
	}
}
