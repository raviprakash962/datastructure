package linkedlist;

import linkedlist.CustomLinkedList.Node;

public class PalindromInLinkedList {

	private CustomLinkedList cll;

	PalindromInLinkedList(CustomLinkedList cll)
	{
		this.cll= cll;
	}

	public boolean isPalindrom()
	{
		Node currentHead= cll.getHead();
		Node middle=	cll.getMiddleElement();
		Node middleNext= middle.getNext();
		middle.setNext(null);
		
		//System.out.println(" middle element: "+ middle.getVal() );
		//System.out.println(" middleNext : "+ middleNext.getVal());

		Node previousNode= null;
		Node nextNode;
		while(middleNext!= null )
		{
			nextNode= middleNext.getNext();
			middleNext.setNext(previousNode);
			previousNode= middleNext;
			middleNext= nextNode;
		}

		Node reversed= previousNode;
		//System.out.println("reversed Value: "+ reversed.getVal());
		while( reversed!= null && currentHead!= null )
		{
			if(reversed.getVal()== currentHead.getVal()) {
				reversed= reversed.getNext();
				currentHead= currentHead.getNext();
				continue;
			}else {
				return false;
			}

		}
		return true;
	}

}
