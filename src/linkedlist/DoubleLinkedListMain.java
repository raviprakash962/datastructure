package linkedlist;

public class DoubleLinkedListMain {
	public static void main(String args[])
	{
		DoubleLinkedList dll= new DoubleLinkedList();
		
		dll.createDoubleLinkedList(10);
		dll.traverseForward();
		
		dll.traverseReverseOrder();
		
		dll.insert(1, 100);
		dll.insert(2, 200);
		dll.insert(3, 300);
		dll.insert(4, 400);
		dll.traverseReverseOrder();
		dll.traverseForward();
		dll.deleteNode(2);
		dll.traverseForward();
		
		dll.search(100);
		dll.deleteLinkedList();
		dll.traverseForward();
	}

}
