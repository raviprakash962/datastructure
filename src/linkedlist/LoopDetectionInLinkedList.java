package linkedlist;

import java.util.HashSet;

import linkedlist.CustomLinkedList.Node;

public class LoopDetectionInLinkedList {

	private CustomLinkedList cll;

	LoopDetectionInLinkedList( ){

	}
	LoopDetectionInLinkedList( CustomLinkedList cll){
		this.cll=cll;
	}

	public boolean isLoopAvailable() {
		if( cll.size()==0)
		{
			throw new RuntimeException("Empty List");
		}
		Node current= cll.getHead();
		HashSet<Node> visitedNode= new HashSet<Node>();
		while( current!= null)
		{
			if(visitedNode.contains(current))
			{
				return true;
			}
			visitedNode.add(current);
			current = current.getNext();


		}
		return false;
	}


}
