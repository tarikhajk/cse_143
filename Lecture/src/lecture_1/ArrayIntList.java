package lecture_1;

//Class ArrayIntList can be used to store a list of integers.

public class ArrayIntList {
	private int[] elementData; // list of integers
	private int size; // current number of elements in the list

	// constructs a list with a capacity of 100
	public ArrayIntList() {
		elementData = new int[100];
		size = 0;
	}
	
	// pre: 0 <= size (throws IllegalArgumentException)
	// post: constructs a list with a specific size
	public ArrayIntList(int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		elementData = new int[size];
		size = 0;
	}

	// returns a comma-separated, bracketed version of the list
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			String result = "[" + elementData[0];
			for (int i = 1; i < size; i++) {
				result += ", " + elementData[i];
			}
			result += "]";
			return result;
		}
	}
	
	// pre: 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: returns value at given index in the list
	public int get(int index){
		checkIndex(index);
		return elementData[index];
	}
	
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	// returns size of the list
	public int size() {
		return size;
	}

	// appends the given value to the end of the list
	public void add(int value) {
		elementData[size] = value;
		size++;
	}
	
	// remove an element at a given index
	public void remove(int index) {
		for (int i = index; i < size-1; i++) {
			elementData[i] = elementData[i+1];
		}
		size--;
	}
}