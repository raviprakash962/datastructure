package linkedlist;

public class SingleLinkedListMain {
	
	public static void main(String args[])
	{
		SingleLinkedList list= new SingleLinkedList();
		
		list.createSingleLinkedList(5);
		
		list.traverseLinkedList();
		
		list.insertIntoLinkedList(4, 1);
		
		list.insertIntoLinkedList(20, 2);
		
		list.insertIntoLinkedList(30, 2);
		
		list.traverseLinkedList();
		
		list.insertIntoLinkedList(100, 10);
		list.traverseLinkedList();
		
		list.search(100);
		
		list.deleteNode(2);
		
		list.traverseLinkedList();
	}

}
