package stack;
// its works as First In First out LIFO concept.
public class StackByArray { 
	private int []arr;
	private int topOfStack; // keeps track which is last occupied cell in array, this will help in insertion and deletion .
	
	public StackByArray(int size)
	{
		this.arr=new int[size];
		this.topOfStack=-1;
		System.out.println("Empty Stack created with size "+ size);
	}
	
	public void push(int value)
	{
		
		if(isFullStack())
		{
			System.out.println(" Stack is full ");
			throw new StackOverflowError();
		}else
		{
			arr[topOfStack+1]=value;
			topOfStack++;
			System.out.println(" Inserted Successfully in stack ");
		}
	}
	
	public void pop()
	{
		if(isEmptyStack())
		{
			System.out.println(" Stack is empty ");
		}else
		{
			System.out.println(" Poping the value from stack "+ arr[topOfStack]);
			topOfStack--;
		}
	}
	
	public boolean isFullStack()
	{
		return topOfStack==arr.length-1?true:false;
	}
	public boolean isEmptyStack()
	{
		return topOfStack==-1?true:false;
	}
	
	public int peekOperation()
	{
		if(!isEmptyStack()) {
		return arr[topOfStack];
		}
		else {
			System.out.println(" Stack is empty !!");
		}
		return Integer.MIN_VALUE;
	}
	public void deleteStack()
	{
		arr=null;
		System.out.println(" Stack deleted Successfully ");
	}

}
