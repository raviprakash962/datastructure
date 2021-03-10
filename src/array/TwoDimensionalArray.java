package array;

public class TwoDimensionalArray {

	int arr[][]=null;

	public TwoDimensionalArray(int rows, int columns)
	{
		arr= new int[rows][columns];

		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<columns;j++)
			{
				arr[i][j]=Integer.MIN_VALUE;
			}
		}
	}

	// traverse the array
	public void printArray()
	{
		try {
			for(int row=0;row<arr.length;row++)
			{
				for(int col=0;col<arr[0].length;col++)
				{
					System.out.print(arr[row][col]+" ");
				}
				System.out.println();
			}
			System.out.println("\n");
		}catch(Exception ex)
		{
			System.out.println("\n Array  does not exists.");
		}
	}
	
	
	//insert
	public void insert(int row,int col, int value)
	{
		try {
			 arr[row][col]=value;
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("\n Index out of Bound Exception !!!");
		}
	}
	
	//access the index 
	public void getIndex(int row,int col)
	{
		try {
			int value= arr[row][col];
			System.out.println(value);
		}catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("\n Index out of Bound Exception !!!");
		}
	}
}
