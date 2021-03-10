package linkedlist;

public class PalindromInLinkedListTest {
	public static void main(String[] args) {
		
		CustomLinkedList cll = new CustomLinkedList();
		/*cll.insert(10);
		cll.insert(20);
		cll.insert(30);
		cll.insert(40);
		cll.insert(50);*/
		
		cll.insert(10);
		cll.insert(20);
		cll.insert(30);
		cll.insert(20);
		cll.insert(10);
		
		PalindromInLinkedList pll= new PalindromInLinkedList(cll);
		 boolean isPalindrom=pll.isPalindrom();
		
		 System.out.println(" Is Palindrom : "+ isPalindrom);

	}

}
