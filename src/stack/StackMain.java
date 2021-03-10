package stack;

public class StackMain {
	
	public static void main(String args[])
	{
		StackByLinkedList  stack= new StackByLinkedList();
		StackByArray arrayStk= new StackByArray(10);  
		
		stack.push(10);
		stack.pop();
		System.out.println(" Stack is empty :"+ stack.isEmpty());
		
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
	   int peekValue= stack.peek();
	   System.out.println(peekValue);
	   System.out.println(stack.isEmpty());
	}

}
