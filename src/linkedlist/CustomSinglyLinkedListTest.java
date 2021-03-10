package linkedlist;

import linkedlist.CustomLinkedList.Node;

public class CustomSinglyLinkedListTest {
	public static void main(String[] args) {
		CustomLinkedList cll= new CustomLinkedList<Integer>();
		//CustomLinkedList<Integer> cll= new CustomLinkedList<Integer>();
		cll.insert(10);
		cll.insert(20);
		cll.insert(30);
		cll.insertAtStart(5);
		cll.insert(40);
		//cll.reverse();
		Node result=cll.getMiddleElement();
		cll.showData();
		System.out.println("Middle element : "+result.getVal());
		
		NthElementFromEnd nthNodeObj= new NthElementFromEnd();
		Node resultNthNodeFromEnd= nthNodeObj.NthElement(cll.getHead(), 3);
		System.out.println(" Nth Node from end "+ resultNthNodeFromEnd.getVal());
		
		System.out.println("------ getting indexed value ----");
		System.out.println(cll.get(4));
		
		
		
		//cll.insert("ravi");
		//cll.insert(13.0);
		//cll.insert(113.f);
		
		
		
		
		System.out.println(" ----checking generics ------");
		CustomLinkedList<Float> cll2= new CustomLinkedList<Float>();
		cll2.insert(12f);
		cll2.insert(13f);
		cll2.insert(14f);
		cll2.insert(15f);
		cll2.showData();
		System.out.println(" custoLinkedList size "+ cll2.size());
		
		System.out.println("+------------------------------------+");
		cll2.insertAtIndex(3, 16f);
		cll2.insertAtIndex(5, 17f);
		cll2.showData();
		System.out.println(" custoLinkedList size "+ cll2.size());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		cll2.deletFromIndex(0);
		cll2.showData();
		System.out.println("deleting from last index");
		cll2.deletFromIndex(4);
		
		cll2.showData();
		System.out.println(" Size of list : "+ cll2.size());
		
		
		
		System.out.println("--------------------------------- Custom Linkedlist Intersection testing ------------");
		CustomLinkedList<Integer> cllobj1= new CustomLinkedList<Integer>();
		CustomLinkedList<Integer> cllobj2= new CustomLinkedList<Integer>();
		IntersectionOfList intersectObj= new IntersectionOfList();
		
		
		cllobj1.insert(5);
		cllobj1.insert(6);
		cllobj1.insert(7);
		cllobj1.insert(1);
		cllobj1.insert(2);
		
		cllobj2.insert(4);
		cllobj2.insert(7);
		cllobj2.insert(1);
		cllobj2.insert(2);
		//cllobj2.insert(5);
		
		Node intersectNodeResult =intersectObj.findIntersectionNode(cllobj1, cllobj2);
		System.out.println(" Intersection found : "+intersectNodeResult.getVal());
		
	
	// Creating loop and detecting the loop 
		CustomLinkedList<Integer> customLinkedList= new CustomLinkedList<Integer>();
		customLinkedList.insert(10);
		customLinkedList.insert(20);
		customLinkedList.insert(30);
	//	customLinkedList.getHead().getNext().getNext().setNext(customLinkedList.getHead());
		
		/*customLinkedList.insert(40);
		customLinkedList.insert(50);
		customLinkedList.insert(60);
		customLinkedList.insert(70);
		*/
		
		//customLinkedList.showData();
		
		LoopDetectionInLinkedList obj= new LoopDetectionInLinkedList(customLinkedList);
		boolean loopIsAvail=obj.isLoopAvailable();
		 System.out.println(" Is loop available in list: "+loopIsAvail);
		
		
		
	}
	

}
