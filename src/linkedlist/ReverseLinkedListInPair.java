package linkedlist;

import linkedlist.CustomLinkedList.Node;

public class ReverseLinkedListInPair {

	private CustomLinkedList<Integer>  customLinkedList;

	ReverseLinkedListInPair(CustomLinkedList obj)
	{
		this.customLinkedList= obj;
	}

	public Node reverseInPair()
	{
		Node current= customLinkedList.getHead();
		Node temp =null;
		Node newHead= null;
		while( current != null && current.getNext()!= null)
		{
			if( temp!= null)
			{
				temp.getNext().setNext(current.getNext());
			}
			temp=current.getNext();     
			current.setNext(temp.getNext());
			temp.setNext(current);

			if (newHead == null) {
				newHead = temp;
			}
			current=current.getNext();

		}     
		return newHead;
	}


}
