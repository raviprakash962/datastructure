package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;

public class BinaryTreeByLinkedList {
	BinaryNode root;

	public BinaryTreeByLinkedList()
	{
		this.root=null;
	}

	public void insert(int value)
	{
		BinaryNode node= new BinaryNode();
		node.setValue(value);
		if(root==null)
		{
			root= node;
			System.out.println(" Successfully inserted new node at root ");
			return;
		}
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode= queue.remove();
			if(presentNode.getLeft()==null)
			{
				presentNode.setLeft(node);
				System.out.println(" Successfully inserted ");
				break;
			}
			else if( presentNode.getRight()==null)
			{
				presentNode.setRight(node);
				System.out.println(" inserted Successfully");
				break;
			}else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight()); 
			}

		}


	}

	public void search(int value)
	{
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode= queue.remove();
			if(presentNode.getValue()==value)
			{
				System.out.println(value +" found in the tree");
				return;
			}
			else {
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

	}

	public void deleteNode(int value)
	{
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode= queue.remove();
			if(presentNode.getValue()==value)
			{
				presentNode.setValue(getDeepestNode().getValue());
				deleteDeepestNode();
				System.out.println("Deleted node !!");
				return;
			}else {
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
		System.out.println("Did not find the suc h node in tree.");

	}
	public void deleteDeepestNode()
	{
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode previousNode,presentNode=null;
		while(!queue.isEmpty())
		{
			previousNode=presentNode;
			presentNode= queue.remove();
			if(presentNode.getLeft()==null)
			{   //if left is null then data node is in right side of tree so make null here. it means deleting right node value.
				previousNode.setRight(null);
				return;
			}if(presentNode.getRight()==null)
			{ 
				//if rightSide is null then data node is in left side of tree so make null here. it means deleting left node value.
				previousNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
		}

	}
	//getLast Node of BinaryTree
	public BinaryNode getDeepestNode() {
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		BinaryNode presentNode=null;
		while(!queue.isEmpty())
		{
			presentNode= queue.remove();
			if(presentNode.getLeft()!=null)
			{
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight()!=null)
			{
				queue.add(presentNode.getRight());
			}
		}
		return presentNode;
	}
	
	public void preOrder(BinaryNode node)
	{
		if(node==null)
		{
			return;
		}
		System.out.print(node.getValue()+" ");
		preOrder(node.getLeft());
		preOrder(node.getRight());
		
	}
	
	public void postOrder(BinaryNode node)
	{
		if(node==null)
		{
			return;
		}
		postOrder(node.getLeft());
		postOrder(node.getRight());
		System.out.print(node.getValue()+" ");
	}
	
	public void inOrder(BinaryNode node)
	{
		if(node==null)
		{
			return;
		}
		inOrder(node.getLeft());
		System.out.print(node.getValue()+" ");
		inOrder(node.getRight());
		
	}
	
	public void levelOrder()
	{
		Queue<BinaryNode> queue= new LinkedList<BinaryNode>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			BinaryNode presentNode =queue.remove();
			System.out.print(presentNode.getValue()+" ");
			
			if(presentNode.getLeft()!=null)
			{
				queue.add(presentNode.getLeft());
			}
			if(presentNode.getRight()!=null) {
				queue.add(presentNode.getRight());
			}
		}
	}
	
	public void deleteTree()
	{
		root= null;
		System.out.println(" Tree Deleted ...");
	}
}
