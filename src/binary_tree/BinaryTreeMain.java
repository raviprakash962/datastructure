package binary_tree;

public class BinaryTreeMain {
	
	public static void main(String args[])
	{
		BinaryTreeByLinkedList btree= new BinaryTreeByLinkedList();
		btree.insert(10);
		btree.insert(20);
		btree.insert(30);
		btree.insert(40);
		btree.insert(50);
		
		System.out.println(" InOrder Traversal ");
		btree.inOrder(btree.root);
		
		System.out.println("\n\n post Order Traversal ");
		btree.postOrder(btree.root);
		
		System.out.println("\n\n Pre Order traveral");
		btree.preOrder(btree.root);
		
		System.out.println("\n\n Level order traversal ");
		btree.levelOrder();
		
		System.out.println("\n\n  in order after deletion of 30");
		btree.deleteNode(30);
		btree.inOrder(btree.root);
		
		System.out.println(" \n deleting deepest node ");
	     btree.deleteDeepestNode();
	     
	     System.out.println("\n\n");
		btree.inOrder(btree.root);
		
		System.out.println("\n\n searching ");
		btree.search(20);
		
		btree.deleteTree();
		
	}

}
