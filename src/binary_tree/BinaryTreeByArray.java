package binary_tree;

public class BinaryTreeByArray {

	int arr[];
	int lastUsedIndex;

	public BinaryTreeByArray(int size)
	{
		this.arr= new int[size+1];
		this.lastUsedIndex=0;
		System.out.println(" Blank tree created...");

	}

	public boolean isTreeFull()
	{
		return arr.length-1==lastUsedIndex ?true:false;
	}

	public void insert(int data)
	{
		if(!isTreeFull())
		{
			arr[lastUsedIndex+1]=data;
			lastUsedIndex++;
			System.out.println("Successfully inserted");
		}else
		{
			throw new IndexOutOfBoundsException(" Could Not Insert the value Tree is full");
		}
	}

	//level order traversal of Binary Tree
	public void levelOrder()
	{
		for(int i=1;i<lastUsedIndex;i++)
		{
			System.out.print(arr[i]);
		}
	}

	//pre order traversal 
	public void preOrder(int index)
	{
		if(index>lastUsedIndex )
		{
			return;
		}
		else
		{
			System.out.print(arr[index]+" ");
			preOrder(index*2);
			preOrder(index*2+1);
		}
	}

	public void postOrder(int index)
	{
		if(index> lastUsedIndex)
		{
			return;
		}
		postOrder(index*2);
		postOrder(index*2+1);
		System.out.println(arr[index]+" ");
	}
	public void inOrder(int index) {
		if(index >lastUsedIndex) {
			return;
		}
		inOrder(index*2);
		System.out.println(arr[index]+" ");
		inOrder(index*2+1);
	}
	public int search(int value)
	{
		for(int i=1;i<lastUsedIndex;i++)
		{
			if(arr[i]==value)
			{
				System.out.println(value+" found at position "+i);
				return i;
			}
		}
		System.out.println(" Not found");
		System.out.println();
		return -1;
	}
	
	public void delete(int value)
	{
		int location =search(value);
		if(location==-1)
		{
			return;
		}else
		{
			arr[location]=arr[lastUsedIndex];
			lastUsedIndex--;
			System.out.println(" Successfully deleted the value from tree");
		}
	}
	
	public void delete()
	{
		try {
			arr=null;
			System.out.println(" Tree deleted ");
		}catch(Exception e)
		{
			System.out.println(" There was an error while deleting the tree");
		}
	}
}
