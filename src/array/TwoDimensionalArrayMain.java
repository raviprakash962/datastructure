package array;

public class TwoDimensionalArrayMain {
	
	public static void main(String args[])
	{
		TwoDimensionalArray array= new TwoDimensionalArray(5,5);
		
		array.insert(0, 0, 10);
		array.insert(1, 1, 11);
		array.insert(2, 2, 22);
		array.printArray();
		array.getIndex(6, 6);
	}

}
