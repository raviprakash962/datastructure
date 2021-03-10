package linkedlist;

import linkedlist.CustomLinkedList.Node;
import linkedlist.CustomLinkedList;

public class IntersectionOfList<T> {

	public Node findIntersectionNode(CustomLinkedList<T> cll, CustomLinkedList<T> cllObj)
	{
		int lengthOfList1=cll.size();
		int lengthOfList2=cllObj.size();

		Node list1= cll.getHead();
		Node list2= cllObj.getHead();

		if( list1==null || list2== null)
		{
			return new Node();
		}
		int diff=0;

		if(lengthOfList1 > lengthOfList2){
			diff = lengthOfList1-lengthOfList2;
			int i=0;
			while(i<diff){
				list1 = list1.getNext();
				i++;
			}
		}else{
			diff = lengthOfList2-lengthOfList1;
			int i=0;
			while(i<diff){
				list2 = list2.getNext();
				i++;
			}
		}
		while(list1!= null && list2!= null)
		{
			if( list1.getVal()== list2.getVal() )
			{
				return list1;
			}
			list1= list1.getNext();
			list2=list2.getNext();
			
		}

		return new Node();

	}


}
