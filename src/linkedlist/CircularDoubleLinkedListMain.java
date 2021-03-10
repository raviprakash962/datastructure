package linkedlist;

public class CircularDoubleLinkedListMain {
	
	public static void main(String args[])
	{
		DoubleCircularLinkedList cdl= new DoubleCircularLinkedList();
		cdl.createLinkedList(12);
		cdl.insert(10, 1);
		cdl.insert(13, 2);
		cdl.insert(14, 4);
		cdl.insert(15, 6);
		cdl.insert(18, 19);
		
		cdl.traverseLinkedList();
		
		System.out.println(" Reverse Order Traversal ");
		cdl.traverseReverseOrder();
		
		cdl.deleteNode(12);
		cdl.traverseLinkedList();
		
		cdl.deleteNode(0);
		cdl.traverseLinkedList();
		cdl.deleteNode(2);
		cdl.traverseLinkedList();
		
	}

}
