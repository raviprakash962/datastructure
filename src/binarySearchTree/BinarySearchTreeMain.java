package binarySearchTree;

public class BinarySearchTreeMain {
	
	public static void main(String args[])
	{
		BinarySearchTreeByLinkedList bst= new BinarySearchTreeByLinkedList();
		
		System.out.println(" Inserting 10 nodes in the tree ");
		bst.insert(100);
		bst.insert(80);
		bst.insert(70);
		bst.insert(90);
		bst.insert(50);
		bst.levelOrderTraversal(); 
		
		bst.printGraphically();
		
		System.out.println(" searching non existing value 800");
		bst.search(800);
		
		bst.search(80);
		
		bst.levelOrderTraversal();
		
		bst.deleteNodeOfBST(60);
		
		bst.levelOrderTraversal();
		
		bst.deleteBST();
		
		bst.levelOrderTraversal();
	}

}
