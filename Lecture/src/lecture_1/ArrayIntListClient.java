package lecture_1;

//sample client code that manipulates two ArrayIntList objects

public class ArrayIntListClient {
	public static void main(String[] args) {
		ArrayIntList list1 = new ArrayIntList();
		ArrayIntList list2 = new ArrayIntList(25);
		list1.add(1);
		list1.add(82);
		list1.add(97);
		list2.add(7);
		list2.add(-8);
		System.out.println(list1 + " has size " + list1.size());
		System.out.println(list2);
		
		list1.remove(1);
		System.out.println(list1 + " now has size " + list1.size());
		
		// this will trigger the exception to be thrown
		System.out.println(list1.get(45));
	}
}
