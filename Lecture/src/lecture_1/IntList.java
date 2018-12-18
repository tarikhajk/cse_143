package lecture_1;

// Interface for all IntList() objects to build on

public interface IntList {

	// checks if the list contains a given value
	public boolean contains(int value);

	// return index of value if found in the list, otherwise, returns -1
	public int indexOf(int value);

	// returns a comma-separated, bracketed version of the list
	public String toString();

	// pre: 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: returns value at given index in the list
	public int get(int index);

	// returns size of the list
	public int size();

	// pre: checks if new size will be less than fixed capacity (throws exception if
	// not)
	// post: appends the given value to the end of the list
	public void add(int value);

	// pre: 0 <= index <= size() (throws IndexOutOfBoundsException if not), then
	// checks if new size will be less than fixed capacity (throws exception if not)
	// post: inserts the given value at the given index, shifting subsequent
	// values right
	public void add(int index, int value);

	// remove an element at a given index
	public void remove(int index);

}
