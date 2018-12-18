package lecture_1;

//Class ArrayIntList can be used to store a list of integers.

public class ArrayIntList implements IntList{
	private int[] elementData; // list of integers
	private int size; // current number of elements in the list
	
	public static final int DEFAULT_CAPACITY = 100;

	// constructs a list with a capacity of 100
	public ArrayIntList() {
		this(DEFAULT_CAPACITY); // call most args constructor to construct others
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

	// checks if the list contains a given value
	public boolean contains(int value) {
		return (indexOf(value) >= 0); // use indexOf() method to do this for us
	}

	// return index of value if found in the list, otherwise, returns -1
	public int indexOf(int value) {
		for (int i = 0; i < size; i++) {
			if (elementData[i] == value) {
				return i;
			}
		}
		return -1;
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
	public int get(int index) {
		checkIndex(index);
		return elementData[index];
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	// appends another list to the end of this list
	// NOTE: we have access to private fields because were adding 'one of our own'
	// (same class object)
	public void addAll(ArrayIntList other) {
		for (int i = 0; i < other.size; i++) {
			add(other.elementData[i]);
		}
	}

	// returns size of the list
	public int size() {
		return size;
	}

	// pre: checks if new size will be less than fixed capacity (throws exception if
	// not)
	// post: appends the given value to the end of the list
	public void add(int value) {
		checkCapacity(size + 1);
		elementData[size] = value;
		size++;
	}

	// pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not), then
	// checks if new size will be less than fixed capacity (throws exception if not)
	// post: inserts the given value at the given index, shifting subsequent
	// values right
	public void add(int index, int value) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
		checkCapacity(size + 1);
		for (int i = size; i > index; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	private void checkCapacity(int new_size) {
		if (new_size > elementData.length) {
			throw new IllegalStateException("Would exceed list capacity!");
		}
	}

	// remove an element at a given index
	public void remove(int index) {
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		size--;
	}
}