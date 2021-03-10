package stack;

import java.util.Stack;

public class SpecialStack extends Stack<Integer> {
	private Stack<Integer> minStack = new Stack<Integer>();
	private int minValue;
	
	public void push(int data) {
		if( isEmpty()== true)
		{
			super.push(data);
			minStack.push(data);
			minValue= data;
		}else {
			super.push(data);
			int temp = minStack.peek();
			if( data <= temp)
			{
				minStack.push(data);
				minValue= data;
			}
		}
		
	}
	
	public Integer pop()
	{
		int val= super.pop();
		if( minValue== val)
		{
			minStack.pop();
			minValue= minStack.peek();
		}
		
		return val;
	}
	
	public Integer getMin()
	{
		return minValue;
	}
	
	

}
