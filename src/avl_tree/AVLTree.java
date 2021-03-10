package avl_tree;

import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;

// Balanced Binary Search tree where the height of immidiate subtrees of any node differs by at most one( also called balance factor)
/*
 * If at any time the heights differ by more than 1 then rotation required to balanceing the tree .
 * height is the number of edge from leaf to that node from where height need to calculate.
 * height of null or empty is always considered as -1. 
 * Suppose any node has one child then  height for other empty node is -1 and existing one is 0
 * if no child define for that node.
 */
public class AVLTree {
	
 private BinaryNode root;
 
 public BinaryNode getRoot()
 {
	 return root;
 }
 
  AVLTree()
 {
	this.root=null; 
 }
  
  public void insert(int value)
  {
	root=  insert(root, value);
  }

private BinaryNode insert(BinaryNode currentNode, int value) {
	if(currentNode==null)
	{
		return createNewNode(value);
	}else if(value<= currentNode.getValue())
	{
		currentNode.setLeft(insert(currentNode.getLeft(),value));
	}else if(value > currentNode.getValue())
	{
		currentNode.setRight( insert(currentNode.getRight(),value));
	}
	// Balancing the tree 
	int balance=checkBalance(currentNode.getLeft(),currentNode.getRight());
	if(balance > 1)
	{
		if(checkBalance(currentNode.getLeft().getLeft(),currentNode.getLeft().getRight()) > 0 )
		{
			currentNode=rightRotate(currentNode); //LL rotation
		}else {
			currentNode.setLeft(leftRotate(currentNode.getLeft())); //LR rotation
			currentNode= rightRotate(currentNode);
		}
	}else if(balance < -1)
	{
		if(checkBalance(currentNode.getRight().getRight(),currentNode.getRight().getLeft()) > 0)
		{
			currentNode=leftRotate(currentNode); //RR rotation
		}else
		{
			currentNode.setRight(rightRotate(currentNode.getRight()));
			currentNode= leftRotate(currentNode);
		}
	}
	if(currentNode.getLeft()!=null)
	{
		currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
	}if(currentNode.getRight()!=null)
	{
		currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
	}
	currentNode.setHeight(calculateHeight(currentNode));
	return currentNode;
	
	
}

private int calculateHeight(BinaryNode currentNode) {
	if(currentNode==null)
	{
		return 0;
	}
	return 1+ Math.max(
			(currentNode.getLeft()!=null ? currentNode.getLeft().getHeight(): -1),
			( currentNode.getRight()!=null ? currentNode.getRight().getHeight() : -1)
			);
	
}

private BinaryNode leftRotate(BinaryNode currentNode) {
	BinaryNode node= currentNode.getRight();
	currentNode.setRight(currentNode.getRight().getLeft());
	node.setLeft(currentNode);
	currentNode.setHeight(calculateHeight(currentNode));
	node.setHeight(calculateHeight(node));
	return node;
}

private BinaryNode rightRotate(BinaryNode currentNode) {
	BinaryNode node= currentNode.getLeft();
	currentNode.setLeft(currentNode.getLeft().getRight());
	node.setRight(currentNode);
	currentNode.setHeight(calculateHeight(currentNode));
	node.setHeight(calculateHeight(node));
	return node;
}

private int checkBalance(BinaryNode rootLeft, BinaryNode rootRight) {
	if((rootLeft==null) &&( rootRight==null))
	{
		// if current node is leaf node
		return 0;
	}
	else if(rootLeft==null)
	{
		return -1*(rootRight.getHeight()+1); // blank node having -1 as height 
	}else if(rootRight==null)
	{
		return rootLeft.getHeight()+1;
	}else
	{
		return rootLeft.getHeight()- rootRight.getHeight();
	}
}

private BinaryNode createNewNode(int value) {
	BinaryNode node = new BinaryNode();
	node.setValue(value);
	node.setHeight(0);
	return node;
}

public void levelOrderTraversal()
{
	Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
	queue.add(root);
	if(root==null)
	{
		 throw new RuntimeException(" Tree is empty now ..");
	}
	while(!queue.isEmpty())
	{
		BinaryNode currentNode= queue.remove();
		System.out.println(currentNode.getValue()+"  ");
		if( currentNode.getLeft()!=null)
		{
			queue.add(currentNode.getLeft());
		}
		if(currentNode.getRight()!=null)
		{
			queue.add(currentNode.getRight());
		}
	}
}

public void deleteNode(int value)
{
	root=deleteNode(root, value);
}

private BinaryNode deleteNode(BinaryNode currentNode, int value) {
	if(currentNode==null)
	{
		throw new RuntimeException(" Tree is empty now ...");
	}
	if(value <= currentNode.getValue())
	{
		currentNode.setLeft(deleteNode(currentNode.getLeft(), value));
	}
	else if( value> currentNode.getValue())
	{
		currentNode.setRight(deleteNode(currentNode.getRight(),value));
	}
	else {
		if(currentNode.getLeft()!=null && currentNode.getRight()!=null)
		{
			BinaryNode temp= currentNode;
			BinaryNode minNodeFromRightSubtree=findMinElement(temp.getRight());
			currentNode.setValue(minNodeFromRightSubtree.getValue());
			deleteNode(currentNode.getRight(),minNodeFromRightSubtree.getValue()); // deleting min node from right subtree.
		}else if( currentNode.getLeft()!=null)
		{
			currentNode=currentNode.getLeft();
		}
		else if( currentNode.getRight()!= null)
		{
			currentNode= currentNode.getRight();
		}else {
			currentNode=null;
		}
		return currentNode;
	}
	// checking balanced or not 
	int balance= checkBalance(currentNode.getLeft(), currentNode.getRight());
	if( balance >1)
	{
		if( checkBalance( currentNode.getLeft().getLeft(),currentNode.getLeft().getRight())>0)
				{
			currentNode=rightRotate(currentNode); // LL rotation
				}else
				{ 
					currentNode.setLeft(leftRotate(currentNode.getLeft())); // LR condition
					currentNode= rightRotate( currentNode);
				}
	}else if( balance < -1)
	{
		if( checkBalance( currentNode.getRight().getRight(), currentNode.getRight().getLeft()) >0)
		{
			currentNode= leftRotate(currentNode); //RR Condition
		}else
		{
			currentNode.setRight(rightRotate(currentNode.getRight()));
			currentNode =leftRotate(currentNode);
		}
	}
	if( currentNode.getLeft()!= null)
	{
		currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
	}
	if( currentNode.getRight()!=null)
	{
		currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
	}
	currentNode.setHeight(calculateHeight(currentNode.getRight()));
	return currentNode;
	
}

public static BinaryNode findMinElement(BinaryNode node) {
	if( node==null)
	{
		return null;
	}
	else if(node.getLeft()==null)
	{
		return node;
	}
	return findMinElement(node.getLeft());
}
}
