package array;

public class SingleDimensionArrayMain {
	
	public static void main(String args[])
	{
		SingleDimensionArray array= new SingleDimensionArray(8);
		array.getIndexValue(0);
		
		array.printArray();
		
		array.delete(10);
		
		array.insert(0, 10);
		array.insert(1, 20);
		array.insert(2, 30);
		array.insert(3, 40);
		array.insert(4, 50);
		array.insert(5, 60);
		array.insert(0, 10);
		array.insert(6, 700);
		array.printArray();
		
		array.insertwithModify(0, 100);
		array.printArray();
		
		array.search(60);
		array.delete(3);
		array.printArray();
		array.deleteArray();
		
		}

}
