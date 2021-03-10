package array;

public class SingleDimensionArray {
	int arr[];

	public SingleDimensionArray(int sizeOfArray) {
		arr = new int[sizeOfArray];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MIN_VALUE;
		}
	}

	public void printArray() {
		try {
			System.out.println("");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
		} catch (Exception e) {
			System.out.println(" Array No longer Exists");
		}
	}

	// If value present then not modified
	public void insert(int location, int value) {
		try {
			if (arr[location] == Integer.MIN_VALUE) {
				arr[location] = value;
				System.out.println("\n Successfully inserted ");
			} else {
				System.out.println("\nThis cell is occupaid by another value. ");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("\nInvalid index to access the array");
		}
	}

	// If value present thenmodify the existing with new value.
	public void insertwithModify(int location, int value) {
		try {
			if (location < arr.length) {
				arr[location] = value;
				System.out.println("\n Successfully inserted ");
			}
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("\nInvalid index to access the array");
		}
	}

	public void getIndexValue(int index) {
		try {
			System.out.println(arr[index]);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("Invalid index to access the array");
		}
	}

	// search in the array
	public boolean search(int value) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == value) {
				System.out.println("\n"+value + " present in the array at position  " + i);
				return true;
			}
		}
		System.out.println("\n "+value + " not found !! ");
		return false;
	}

	// Delete Value From given Arrray

	public void delete(int location) {
		try {

			arr[location] = Integer.MIN_VALUE;
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("\n Out Of range from array index.");
		}
	}

	// delete entire array
	public void deleteArray() {
		arr = null;
		System.out.println("\n Array deleted ");
	}
}
