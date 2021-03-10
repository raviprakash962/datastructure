package binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;

/*
 * Binary search tree by linkedlist is efficient than array implementation .
 * 
 * */
 
public class BinarySearchTreeByLinkedList {
	private BinaryNode root;

	public BinaryNode getRoot() {
		return root;
	}
	
	public BinarySearchTreeByLinkedList()
	{
		root=null;
	}
	
	public void insert(int value)
	{
		root=insert(root,value);
	}
	private BinaryNode insert(BinaryNode currentNode, int value)
	{
		if(currentNode==null)
		{
			//if tree is not created then root will be blank ,then insert new node there.
			System.out.println(" Inserting the "+value+" in BST");
			return createNewNode(value);
		}else if(value <= currentNode.getValue())
		{
			currentNode.setLeft(insert(currentNode.getLeft(),value));
			return currentNode;
		}else {
			currentNode.setRight(insert(currentNode.getRight(),value));
			return currentNode;
		}
	}
	public BinaryNode createNewNode(int value)
	{
		BinaryNode node= new BinaryNode();
		node.setValue(value);
		node.setLeft(null);
		node.setRight(null);
		return node;
	}
	
	//deleting the Node from BST
	public void deleteNodeOfBST(int value)
	{
		System.out.println("Deleting the node from tree...");
		deleteNodeOfBST(root,value);
	}
	
	private BinaryNode deleteNodeOfBST(BinaryNode root,int value)
	{
		if(root==null)
		{
			return null;
		}
		else if(value< root.getValue())
		{
			root.setLeft(deleteNodeOfBST(root.getLeft(),value));
		}
		else if( value > root.getValue())
		{
			root.setRight(deleteNodeOfBST(root.getRight(),value));
		}else
		{
			//ifCurrent node is the node need to be deleted 
			if(root.getLeft()!=null && root.getRight()!=null)
			{
				BinaryNode temp=root;
				BinaryNode minNodeForRight=minimumElement(temp.getRight());
				root.setValue(minNodeForRight.getValue());// replacing the current node with minimum node from right subtree.
				root.setRight(deleteNodeOfBST(root.getRight(),minNodeForRight.getValue()));
			}else if(root.getLeft()!=null)
			{
				// if deleted node has only left Child 
				root=root.getLeft();
			}else if(root.getRight()!=null)
			{
				//if nodeTobeDeleted has only right child
				root= root.getRight();
			}else {
				//if no child 
				root=null;
			}
		}
		return root;
	}

	public static BinaryNode minimumElement(BinaryNode root)
	{
		if(root.getLeft()==null)
		{
			return root;
		}else
		{
			return minimumElement(root.getLeft());
		}
	}
	
	public void search(int value)
	{
		search(root, value);
	}
	
	private BinaryNode search(BinaryNode node, int value)
	{
		if(node==null)
		{
			System.out.println(value+" not found in the tree ...");
			return null;
		}else if(node.getValue()==value)
		{
			System.out.println(value +" found in the tree  ");
			return node;
		}
		else if(value< node.getValue())
		{
			return search(node.getLeft(),value);
		}else {
			return search(node.getRight(),value);
		}
	}
	
	public void levelOrderTraversal()
	{
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		System.out.println(" \n printing level order trabersal of Binary search tree ");
		if(root==null)
		{
			System.out.println(" Tree is empty ");
			return;
		}
			while(!queue.isEmpty())
			{
				BinaryNode presentNode=queue.remove();
				System.out.print(presentNode.getValue()+" ");
				if(presentNode.getLeft()!=null)
				{
					queue.add(presentNode.getLeft());
				}
				if(presentNode.getRight()!=null)
				{
					queue.add(presentNode.getRight());
				}
		}	
	}
	
	public void deleteBST()
	{ 
		System.out.println("Deleting entire tree ...");
		root=null;
		System.out.println(" Tree deleted Successfully !!");
	}

	public void printGraphically()
	{
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		Queue<Integer> level= new LinkedList<Integer>();
		int currentLevel=1;
		
		boolean previousLevelWasAllNull=false;
		queue.add(root);
		
		level.add(1);
		System.out.println(" \n printing level order Traversal of Tree...");
		if(root==null)
		{
			System.out.println(" Tree is empty !!!");
			return;
		}
		
		while(!queue.isEmpty())
		{
			if(currentLevel==level.peek())
			{
				//if we are at same level..
				if(queue.peek()==null)
				{
					queue.add(null);
					level.add(currentLevel+1);
				}else {
					queue.add(queue.peek().getLeft());
					level.add(currentLevel+1);
					queue.add(queue.peek().getRight());
					level.add(currentLevel+1);
					previousLevelWasAllNull=false;
				}
				System.out.println(queue.remove()+" ");
				level.remove();
			}else {
				System.out.println("\n");
				currentLevel++;
				if(previousLevelWasAllNull==true)
				{
					break;
				}
				previousLevelWasAllNull=true;
			}
		}
		
	}
}
