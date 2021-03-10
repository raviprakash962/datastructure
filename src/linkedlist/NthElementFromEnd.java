package linkedlist;

import linkedlist.CustomLinkedList.Node;
import linkedlist.CustomLinkedList;

public class NthElementFromEnd {
	
	public Node NthElement(Node head, int index)
	{
		
		if( head==null || head.getNext()==null )
		{
			return head;
		}
		 if( index <= 0)
		 {
			 throw new RuntimeException("invalid index");
		 }
		Node first= head;
		Node slow= head;
		for( int i=0; i< index; i++)
		{
			first= first.getNext();
		}while(first!= null)
		{
			slow= slow.getNext();
			first= first.getNext();
		}
		return slow;
	}

}
